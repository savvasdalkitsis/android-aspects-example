package com.savvasdalkitsis.android.aspect.example.loading;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;

public abstract class LoaderBackedFetcher<T> implements Fetcher<T>, LoaderManager.LoaderCallbacks<T> {

    protected final Context context;
    protected final LoaderManager loaderManager;
    protected final int loaderId;
    private final FetcherListener.NoOp<T> noOpListener = new FetcherListener.NoOp<>();
    protected FetcherListener<T> listener = noOpListener;

    public LoaderBackedFetcher(Context context, LoaderManager loaderManager, int loaderId) {
        this.context = context;
        this.loaderManager = loaderManager;
        this.loaderId = loaderId;
    }

    public void fetch() {
        loaderManager.restartLoader(loaderId, null, this);
    }

    public void setListener(FetcherListener<T> listener) {
        this.listener = listener;
    }

    public FetcherListener<T> getListener() {
        return listener;
    }

    public void clearListener() {
        listener = noOpListener;
    }

    public void onLoaderReset(Loader<T> loader) {
        // Do nothing.
    }
}
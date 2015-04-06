package com.savvasdalkitsis.android.aspect.example.loading;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

public class DataLoader<T> extends AsyncTaskLoader<T> {

    private final DataRetriever<T> dataRetriever;
    private T result; // Keep hold of the result between attempts to re-load.

    public DataLoader(Context context, DataRetriever<T> dataRetriever) {
        super(context);
        this.dataRetriever = dataRetriever;
    }

    /**
     * Called by AsyncTaskLoader on a new thread.
     */
    @Override
    public T loadInBackground() {
        result = null;
        try {
            result = dataRetriever.retrieveData();
        } catch (ContentLoadingException e) {
            Log.e("DataLoader", "Retrieve failed... ", e);
            result = null;
        }

        return result;
    }

    @Override
    public void deliverResult(final T data) {
        if (isReset()) {
            return;
        }

        if (isStarted()) {
            super.deliverResult(data);
        }
    }

    @Override
    protected void onStartLoading() {
        if (result != null) {
            deliverResult(result);
        }
        if (takeContentChanged() || result == null) {
            forceLoad();
        }
    }

    @Override
    protected void onReset() {
        super.onReset();
        result = null;
    }
}

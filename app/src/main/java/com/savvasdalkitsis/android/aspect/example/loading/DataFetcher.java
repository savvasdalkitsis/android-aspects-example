package com.savvasdalkitsis.android.aspect.example.loading;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

public class DataFetcher<T> extends LoaderBackedFetcher<T> {

    private final DataRetriever<T> retriever;

    public DataFetcher(LoaderManager loaderManager,
                       int loaderId,
                       Context context,
                       DataRetriever<T> retriever) {
        super(context, loaderManager, loaderId);
        this.retriever = retriever;
    }

    @Override
    public DataLoader<T> onCreateLoader(int id, Bundle bundle) {
        return new DataLoader<>(context, retriever);
    }

    @Override
    public void onLoadFinished(Loader<T> loader, T data) {
        if (data == null) {
            listener.onDataFailedToLoad();
        } else {
            listener.onDataFetched(data);
        }
    }
}

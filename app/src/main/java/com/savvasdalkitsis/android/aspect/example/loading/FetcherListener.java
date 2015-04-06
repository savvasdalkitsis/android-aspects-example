package com.savvasdalkitsis.android.aspect.example.loading;

import android.support.annotation.NonNull;

public interface FetcherListener<T> {

    void onDataFetched(@NonNull T data);

    void onDataFailedToLoad();

    class NoOp<T> implements FetcherListener<T> {

        @Override
        public void onDataFetched(@NonNull T data) {
        }

        @Override
        public void onDataFailedToLoad() {
        }
    }
}
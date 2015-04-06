package com.savvasdalkitsis.android.aspect.example.loading;

/**
 * This interface allows the retrieval of data in the background.
 * Clients can register listeners to be notified of successful retrieval or failures.
 */
public interface Fetcher<T> {

    /**
     * Fetches the data.
     */
    void fetch();

    void setListener(FetcherListener<T> listener);

    FetcherListener<T> getListener();

    void clearListener();

    class NO_OP<T> implements Fetcher<T> {

        @Override
        public void fetch() {
        }

        @Override
        public void setListener(FetcherListener<T> listener) {
        }

        @Override
        public FetcherListener<T> getListener() {
            return null;
        }

        @Override
        public void clearListener() {
        }
    }
}
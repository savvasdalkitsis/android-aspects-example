package com.savvasdalkitsis.android.aspect.example.loading;

import android.support.annotation.NonNull;

/**
 * Synchronously calls that retrieve data. Ideal for long running operations (e.g. network).
 * @param <T> the type this retriever will bring back
 */
public interface DataRetriever<T> {

    /**
     * <strong>Must</strong> return a non-null value, otherwise the loader will mark it as an error
     */
    @NonNull
    T retrieveData() throws ContentLoadingException;
}

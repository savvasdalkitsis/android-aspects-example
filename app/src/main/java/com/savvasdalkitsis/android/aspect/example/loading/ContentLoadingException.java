package com.savvasdalkitsis.android.aspect.example.loading;

/**
 * Thrown when something goes wrong loading content for a URI, rather than it declaring it throws Exception like it used
 * to.
 */
public class ContentLoadingException extends Exception {

    public ContentLoadingException() {
    }

    public ContentLoadingException(String detailMessage) {
        super(detailMessage);
    }

    public ContentLoadingException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public ContentLoadingException(Throwable throwable) {
        super(throwable);
    }
}
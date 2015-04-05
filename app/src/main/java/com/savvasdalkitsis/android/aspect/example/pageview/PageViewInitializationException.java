package com.savvasdalkitsis.android.aspect.example.pageview;

public class PageViewInitializationException extends RuntimeException {

    public PageViewInitializationException(String msg) {
        super(msg);
    }

    public PageViewInitializationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

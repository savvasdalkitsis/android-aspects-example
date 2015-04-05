package com.savvasdalkitsis.android.aspect.example.pageview;

public interface PageRetriever {

	Page retrieveConfiguredPageFrom(Object annotatedObject) throws PageViewInitializationException;
}
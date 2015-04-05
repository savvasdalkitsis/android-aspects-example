package com.savvasdalkitsis.android.aspect.example.pageview;

import android.os.SystemClock;
import android.util.Log;

public class PageViewSessionManager {

    private String pageName;
    private long startTime;

    public void startPageView(Object objectWithPageView) {
        pullAttributesForPageView(objectWithPageView);
        Log.v("PageView", "PageView " + pageName + " started");
        startTime = SystemClock.elapsedRealtime();
    }

    public void stopPageView(Object objectWithPageView) {
        long duration = SystemClock.elapsedRealtime() - startTime;
        Log.v("PageView", "PageView " + pageName + " stopped. PageView lasted " + duration);
    }

    private void pullAttributesForPageView(Object objectWithPageView) {
        WithPageView sessionAnnotation = objectWithPageView.getClass().getAnnotation(WithPageView.class);
        pageName = sessionAnnotation.pageName();
    }
}

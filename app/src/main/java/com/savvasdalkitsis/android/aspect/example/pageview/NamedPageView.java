package com.savvasdalkitsis.android.aspect.example.pageview;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import com.shazam.android.aspects.aspects.activity.NoOpActivityAspect;
import com.shazam.android.aspects.base.activity.AspectActivity;

public class NamedPageView extends NoOpActivityAspect {

    private long startTime;
    private String pageName;

    @Override
    public void onCreate(AspectActivity activity, Bundle savedInstanceState) {
        pullAttributesForPageView(activity);
    }

    @Override
    public void onStart(AspectActivity activity) {
        Log.v("PageView", "Activity '" + pageName + "' started");
        startTime = SystemClock.elapsedRealtime();
    }

    @Override
    public void onStop(AspectActivity activity) {
        long duration = SystemClock.elapsedRealtime() - startTime;
        Log.v("PageView", "Activity '" + pageName + "' stopped. PageView lasted " + duration);
    }

    private void pullAttributesForPageView(Object objectWithPageView) {
        WithPageView sessionAnnotation = objectWithPageView.getClass().getAnnotation(WithPageView.class);
        pageName = sessionAnnotation.pageName();
    }
}

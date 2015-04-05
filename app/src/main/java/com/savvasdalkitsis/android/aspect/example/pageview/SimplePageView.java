package com.savvasdalkitsis.android.aspect.example.pageview;

import android.os.SystemClock;
import android.util.Log;

import com.shazam.android.aspects.aspects.activity.NoOpActivityAspect;
import com.shazam.android.aspects.base.activity.AspectActivity;

public class SimplePageView extends NoOpActivityAspect {

    private long startTime;

    @Override
    public void onStart(AspectActivity activity) {
        Log.v("PageView", "Activity started");
        startTime = SystemClock.elapsedRealtime();
    }

    @Override
    public void onStop(AspectActivity activity) {
        long duration = SystemClock.elapsedRealtime() - startTime;
        Log.v("PageView", "Activity stopped. PageView lasted " + duration);
    }
}

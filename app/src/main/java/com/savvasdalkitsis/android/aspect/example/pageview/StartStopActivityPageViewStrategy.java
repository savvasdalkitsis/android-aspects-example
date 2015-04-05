package com.savvasdalkitsis.android.aspect.example.pageview;

import com.shazam.android.aspects.base.activity.AspectActivity;

public class StartStopActivityPageViewStrategy extends ActivityPageViewStrategy {

    private PageViewSessionManager pageViewSessionManager;

    public StartStopActivityPageViewStrategy(PageViewSessionManager pageViewSessionManager) {
        this.pageViewSessionManager = pageViewSessionManager;
    }

    @Override
    public void onStart(AspectActivity activity) {
        pageViewSessionManager.startPageView(activity);
    }

    @Override
    public void onStop(AspectActivity activity) {
        pageViewSessionManager.stopPageView(activity);
    }
}

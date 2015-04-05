package com.savvasdalkitsis.android.aspect.example.pageview;

import com.shazam.android.aspects.base.activity.AspectActivity;

public class ResumePauseActivityPageViewStrategy extends ActivityPageViewStrategy {

    private PageViewSessionManager pageViewSessionManager;

    public ResumePauseActivityPageViewStrategy(PageViewSessionManager pageViewSessionManager) {
        this.pageViewSessionManager = pageViewSessionManager;
    }

    @Override
    public void onResume(AspectActivity activity) {
        pageViewSessionManager.startPageView(activity);
    }

    @Override
    public void onPause(AspectActivity activity) {
        pageViewSessionManager.stopPageView(activity);
    }
}

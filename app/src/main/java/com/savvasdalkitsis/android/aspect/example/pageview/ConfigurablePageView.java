package com.savvasdalkitsis.android.aspect.example.pageview;

import android.app.Activity;
import android.os.Bundle;

import com.shazam.android.aspects.aspects.activity.NoOpActivityAspect;
import com.shazam.android.aspects.base.activity.AspectActivity;

public class ConfigurablePageView extends NoOpActivityAspect {

    private ActivityPageViewStrategyFactory strategyFactory = new DefaultActivityPageViewStrategyFactory();
    private ActivityPageViewStrategy sessionStrategy;

    @Override
    public void onCreate(AspectActivity activity, Bundle bundle) {
        pullAttributesForPageView(activity);
    }

    @Override
    public void onStart(AspectActivity activity) {
        sessionStrategy.onStart(activity);
    }

    @Override
    public void onResume(AspectActivity activity) {
        sessionStrategy.onResume(activity);
    }

    @Override
    public void onPause(AspectActivity activity) {
        sessionStrategy.onPause(activity);
    }

    @Override
    public void onStop(AspectActivity activity) {
        sessionStrategy.onStop(activity);
    }

    private void pullAttributesForPageView(Activity activity) {
        WithPageView sessionAnnotation = activity.getClass().getAnnotation(WithPageView.class);
        if (sessionAnnotation == null) {
            throw new PageViewInitializationException("Could not initialize Session for activity "
                    + activity.getClass().toString()
                    + ". Use " + WithPageView.class.toString());
        }
        sessionStrategy = strategyFactory.createSessionStrategy(sessionAnnotation.pageViewStrategy());
    }
}

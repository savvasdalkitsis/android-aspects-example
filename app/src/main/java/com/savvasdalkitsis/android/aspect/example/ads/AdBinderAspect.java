package com.savvasdalkitsis.android.aspect.example.ads;

import android.app.Activity;
import android.os.Bundle;

import com.savvasdalkitsis.android.aspect.example.R;
import com.savvasdalkitsis.android.aspect.example.pageview.PageViewInitializationException;
import com.shazam.android.aspects.aspects.activity.NoOpActivityAspect;
import com.shazam.android.aspects.base.activity.AspectActivity;

public class AdBinderAspect extends NoOpActivityAspect {

    private String adPageName;
    private AdConfiguration adConfiguration = new StaticAdconfiguration();

    @Override
    public void onCreate(AspectActivity activity, Bundle bundle) {
        pullAttributesForPageView(activity);
    }

    @Override
    public void onResume(AspectActivity activity) {
        AdView adView = (AdView) activity.findViewById(R.id.advert);
        if (adView != null) {
            adView.setAdId(adConfiguration.getAdId(adPageName));
            adView.loadAd();
        }
    }

    private void pullAttributesForPageView(Activity activity) {
        WithAd adAnnotation = activity.getClass().getAnnotation(WithAd.class);
        if (adAnnotation == null) {
            throw new PageViewInitializationException("Could not initialize Ad for activity "
                    + activity.getClass().toString()
                    + ". Use " + WithAd.class.toString());
        }
        adPageName = adAnnotation.adPageName();
    }
}

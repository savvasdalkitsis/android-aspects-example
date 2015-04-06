package com.savvasdalkitsis.android.aspect.example.analytics;

import android.util.Log;
import android.view.View;

import com.savvasdalkitsis.android.aspect.example.R;
import com.savvasdalkitsis.android.aspect.example.pageview.AnnotatedPageRetriever;
import com.savvasdalkitsis.android.aspect.example.pageview.Page;
import com.savvasdalkitsis.android.aspect.example.pageview.PageRetriever;
import com.shazam.android.aspects.aspects.activity.NoOpActivityAspect;
import com.shazam.android.aspects.base.activity.AspectActivity;

import java.util.Map;

import static com.savvasdalkitsis.android.aspect.example.analytics.EventParameters.Builder.eventParameters;

public class AttachPageViewToRootAspect extends NoOpActivityAspect {

    private PageRetriever pageRetriever = new AnnotatedPageRetriever();
    private Page page;

    @Override
    public void onResume(AspectActivity activity) {
        pullAttributesForPageView(activity);
        if (page != null) {
            View root = activity.findViewById(android.R.id.content);
            EventParameters.Builder eventParams = eventParameters()
                    .withParam("screenname", page.getPageName());
            for (Map.Entry<String, String> param : page.getParameters().entrySet()) {
                eventParams.withParam(param.getKey(), param.getValue());
            }
            root.setTag(R.id.tag_key_event_parameters, eventParams.build());
        }
    }

    private void pullAttributesForPageView(Object objectWithPageView) {
        try {
            page = pageRetriever.retrieveConfiguredPageFrom(objectWithPageView);
        } catch (Exception e) {
            Log.e("PageView", "Error creating page object for pageview", e);
        }
    }
}

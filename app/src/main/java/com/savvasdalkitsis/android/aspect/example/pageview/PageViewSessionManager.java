package com.savvasdalkitsis.android.aspect.example.pageview;

import android.os.SystemClock;
import android.util.Log;

import java.util.Map;

public class PageViewSessionManager {

    private long startTime;
    private Page page;
    private PageRetriever pageRetriever = new AnnotatedPageRetriever();

    public void startPageView(Object objectWithPageView) {
        pullAttributesForPageView(objectWithPageView);
        if (page != null) {
            Log.v("PageView", "\nPageView started:\n" + "name: '" + page.getPageName() + "'\n");
            startTime = SystemClock.elapsedRealtime();
        }
    }

    @SuppressWarnings("UnusedParameters")
    public void stopPageView(Object objectWithPageView) {
        if (page != null) {
            long duration = SystemClock.elapsedRealtime() - startTime;

            StringBuilder msg = new StringBuilder()
                    .append("\nPageView stopped:\n")
                    .append("name: '").append(page.getPageName()).append("'\n")
                    .append("duration: ").append(duration).append("\n");
            for (Map.Entry<String, String> param : page.getParameters().entrySet()) {
                msg.append("parameter '").append(param.getKey()).append("' = '").append(param.getValue()).append("'\n");
            }
            Log.v("PageView", msg.toString());
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

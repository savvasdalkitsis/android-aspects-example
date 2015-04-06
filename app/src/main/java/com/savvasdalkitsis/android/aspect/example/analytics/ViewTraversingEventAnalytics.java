package com.savvasdalkitsis.android.aspect.example.analytics;

import android.view.View;

import java.util.Map;

import static com.savvasdalkitsis.android.aspect.example.analytics.EventParameters.Builder.from;

public class ViewTraversingEventAnalytics implements EventAnalyticsFromView {

    private final EventAnalytics eventAnalytics;

    public ViewTraversingEventAnalytics(EventAnalytics eventAnalytics) {
        this.eventAnalytics = eventAnalytics;
    }

    @Override
    public void sendEvent(View view, EventType userEvent, EventParameters eventParameters) {
        EventParameters fromHierarchy = EventParametersFromHierarchy.findInHierarchy(view);
        eventAnalytics.sendEvent(userEvent, merge(eventParameters, fromHierarchy));
    }

    private EventParameters merge(EventParameters eventParameters, EventParameters fromHierarchy) {
        EventParameters.Builder builder = from(eventParameters);
        if (fromHierarchy != null) {
            for (Map.Entry<String, String> param : fromHierarchy.getParams().entrySet()) {
                builder.withParam(param.getKey(), param.getValue());
            }
        }
        return builder.build();
    }
}
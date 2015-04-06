package com.savvasdalkitsis.android.aspect.example.analytics;

import android.util.Log;

import java.util.Map;

public class LoggingEventAnalytics implements EventAnalytics {
    @Override
    public void sendEvent(EventType eventType, EventParameters eventParameters) {
        Log.v("Event", "EventType: " + eventType);
        for (Map.Entry<String, String> param : eventParameters.getParams().entrySet()) {
            Log.v("Event", "param: " + param.getKey() + " = " + param.getValue());
        }
    }
}

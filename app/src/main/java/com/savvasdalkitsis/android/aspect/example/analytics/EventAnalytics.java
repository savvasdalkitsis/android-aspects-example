package com.savvasdalkitsis.android.aspect.example.analytics;

public interface EventAnalytics {

    void sendEvent(EventType userEvent, EventParameters build);
}

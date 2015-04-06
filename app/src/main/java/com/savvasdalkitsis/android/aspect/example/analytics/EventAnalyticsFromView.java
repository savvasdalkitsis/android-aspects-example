package com.savvasdalkitsis.android.aspect.example.analytics;

import android.view.View;

public interface EventAnalyticsFromView {

    void sendEvent(View view, EventType userEvent, EventParameters build);
}

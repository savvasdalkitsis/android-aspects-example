package com.savvasdalkitsis.android.aspect.example;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.savvasdalkitsis.android.aspect.example.analytics.EventAnalyticsFromView;
import com.savvasdalkitsis.android.aspect.example.analytics.EventType;
import com.savvasdalkitsis.android.aspect.example.analytics.LoggingEventAnalytics;
import com.savvasdalkitsis.android.aspect.example.analytics.ViewTraversingEventAnalytics;
import com.savvasdalkitsis.android.aspect.example.model.beans.Track;

import static com.savvasdalkitsis.android.aspect.example.analytics.EventParameters.Builder.eventParameters;

public class BuyButton extends Button {

    private String trackId;
    private final EventAnalyticsFromView eventAnalytics = new ViewTraversingEventAnalytics(
            new LoggingEventAnalytics());

    public BuyButton(Context context) {
        super(context);
        init();
    }

    public BuyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BuyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setText("Buy track");
        setOnClickListener(new SendEventOnClick());
    }

    public void bindTo(Track track) {
        trackId = track.getTrackId();
    }

    private class SendEventOnClick implements OnClickListener {
        @Override
        public void onClick(@NonNull View v) {
            eventAnalytics.sendEvent(BuyButton.this, EventType.USER_EVENT, eventParameters()
                    .withParam("usereventtype", "buybuttonclick")
                    .withParam("trackid", trackId)
                    .build());
        }
    }
}

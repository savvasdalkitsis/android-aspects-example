package com.savvasdalkitsis.android.aspect.example.widgets;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.savvasdalkitsis.android.aspect.example.BuyButton;
import com.savvasdalkitsis.android.aspect.example.activities.SecondActivity;
import com.savvasdalkitsis.android.aspect.example.model.beans.Track;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class TrackRowView extends LinearLayout {

    private TextView title;
    private BuyButton buyButton;

    public TrackRowView(Context context) {
        super(context);
        init();
    }

    public TrackRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TrackRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(HORIZONTAL);
        setPadding(20, 0, 20, 0);
        title = new TextView(getContext());
        LayoutParams titleParams = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        titleParams.weight = 1;
        buyButton = new BuyButton(getContext());
        LayoutParams buyParams = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        buyParams.weight = 0;
        addView(title, titleParams);
        addView(buyButton, buyParams);
    }

    public void bindTo(Track track) {
        title.setText(track.getTitle());
        buyButton.bindTo(track);
        setOnClickListener(new LaunchNewActivityClickListener(track));
    }

    private void launchTrackDetails(String trackId) {
        Intent intent = new Intent(getContext(), SecondActivity.class);
        intent.putExtra(SecondActivity.PARAM_TRACK_ID, trackId);
        getContext().startActivity(intent);
    }

    private class LaunchNewActivityClickListener implements View.OnClickListener {

        private Track track;

        public LaunchNewActivityClickListener(Track track) {
            this.track = track;
        }

        @Override
        public void onClick(@NonNull View v) {
            launchTrackDetails(track.getTrackId());
        }
    }
}

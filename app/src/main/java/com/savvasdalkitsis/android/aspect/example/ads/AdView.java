package com.savvasdalkitsis.android.aspect.example.ads;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.savvasdalkitsis.android.aspect.example.R;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.applyDimension;

public class AdView extends RelativeLayout implements AdFacade {

    private TextView adId;
    private TextView adKeywords;

    public AdView(Context context) {
        super(context);
    }

    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        adId = (TextView) findViewById(R.id.ad_id);
        adKeywords = (TextView) findViewById(R.id.ad_keywords);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightDp = 56;
        setMeasuredDimension(getMeasuredWidth(),
                (int) applyDimension(COMPLEX_UNIT_DIP, heightDp, getResources().getDisplayMetrics()));
    }

    public void setAdId(String adId) {
        this.adId.setText("AdId: " + adId);
    }

    @Override
    public void addKeyWord(String key, String value) {
        adKeywords.setText(adKeywords.getText().toString() + "key: " + key + " value: " + value + "\n");
    }

    public void loadAd() {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                setBackgroundColor(Color.GREEN);
            }
        }, 1000);
    }
}

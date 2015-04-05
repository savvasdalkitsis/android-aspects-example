package com.savvasdalkitsis.android.aspect.example.activities;

import android.os.Bundle;

import com.savvasdalkitsis.android.aspect.example.R;
import com.savvasdalkitsis.android.aspect.example.pageview.PageViewConfigurator;
import com.savvasdalkitsis.android.aspect.example.pageview.SecondPage;
import com.savvasdalkitsis.android.aspect.example.pageview.WithPageView;
import com.shazam.android.aspects.base.activity.AspectActivity;

@WithPageView(page = SecondPage.class)
public class SecondActivity extends AspectActivity implements PageViewConfigurator<SecondPage> {

    public static final String PARAM_TRACK_ID = SecondActivity.class.getName() + ".PARAM_TRACK_ID";
    private String trackID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        trackID = getIntent().getStringExtra(PARAM_TRACK_ID);
    }

    @Override
    public void configurePage(SecondPage page) {
        page.addPageParameter("track_id", trackID);
    }
}

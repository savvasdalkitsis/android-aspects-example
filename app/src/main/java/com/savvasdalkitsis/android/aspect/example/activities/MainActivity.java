package com.savvasdalkitsis.android.aspect.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.savvasdalkitsis.android.aspect.example.R;
import com.savvasdalkitsis.android.aspect.example.pageview.SimplePageView;
import com.shazam.android.aspects.annotations.Aspects;
import com.shazam.android.aspects.base.activity.AspectActivity;

@Aspects(aspects = SimplePageView.class)
public class MainActivity extends AspectActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_new_activity).setOnClickListener(new LaunchNewActivityClickListener());
    }

    private class LaunchNewActivityClickListener implements View.OnClickListener {
        @Override
        public void onClick(@NonNull View v) {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }
    }
}

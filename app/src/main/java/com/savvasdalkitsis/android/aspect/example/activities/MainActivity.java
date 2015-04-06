package com.savvasdalkitsis.android.aspect.example.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.savvasdalkitsis.android.aspect.example.R;
import com.savvasdalkitsis.android.aspect.example.analytics.AttachPageViewToRoot;
import com.savvasdalkitsis.android.aspect.example.loading.DataFetcher;
import com.savvasdalkitsis.android.aspect.example.model.MainPresenter;
import com.savvasdalkitsis.android.aspect.example.model.MainView;
import com.savvasdalkitsis.android.aspect.example.model.TracksRetriever;
import com.savvasdalkitsis.android.aspect.example.model.beans.Track;
import com.savvasdalkitsis.android.aspect.example.pageview.MainPage;
import com.savvasdalkitsis.android.aspect.example.pageview.PageViewStrategy;
import com.savvasdalkitsis.android.aspect.example.pageview.WithPageView;
import com.shazam.android.aspects.base.activity.AspectActivity;

import java.util.List;

@WithPageView(page = MainPage.class, pageViewStrategy = PageViewStrategy.RESUME_PAUSE)
@AttachPageViewToRoot
public class MainActivity extends AspectActivity implements MainView {

    private MainPresenter presenter;
    private View progress;
    private ListView tracksList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = findViewById(R.id.progress);
        tracksList = (ListView) findViewById(R.id.tracks);
        presenter = new MainPresenter(this, new DataFetcher<>(getLoaderManager(), 0, this,
                new TracksRetriever()));
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.startPresenting();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.stopPresenting();
    }

    @Override
    public void onTracksLoaded(List<Track> tracks) {
        progress.setVisibility(View.INVISIBLE);
        tracksList.setVisibility(View.VISIBLE);
        tracksList.setAdapter(new TracksAdapter(tracks));
    }
}

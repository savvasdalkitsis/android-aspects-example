package com.savvasdalkitsis.android.aspect.example.model;

import android.support.annotation.NonNull;

import com.savvasdalkitsis.android.aspect.example.loading.Fetcher;
import com.savvasdalkitsis.android.aspect.example.loading.FetcherListener;
import com.savvasdalkitsis.android.aspect.example.model.beans.Track;

import java.util.List;

public class MainPresenter {

    private MainView mainView;
    private final Fetcher<List<Track>> tracksFetcher;

    public MainPresenter(MainView mainView, Fetcher<List<Track>> tracksFetcher) {
        this.mainView = mainView;
        this.tracksFetcher = tracksFetcher;
    }

    public void startPresenting() {
        tracksFetcher.setListener(new DeliverTracksToViewListener());
        tracksFetcher.fetch();
    }

    public void stopPresenting() {
        tracksFetcher.clearListener();
    }

    private class DeliverTracksToViewListener implements FetcherListener<List<Track>> {
        @Override
        public void onDataFetched(@NonNull List<Track> data) {
            mainView.onTracksLoaded(data);
        }

        @Override
        public void onDataFailedToLoad() {

        }
    }
}

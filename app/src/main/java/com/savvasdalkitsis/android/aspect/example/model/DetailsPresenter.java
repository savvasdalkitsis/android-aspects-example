package com.savvasdalkitsis.android.aspect.example.model;

import android.support.annotation.NonNull;

import com.savvasdalkitsis.android.aspect.example.loading.Fetcher;
import com.savvasdalkitsis.android.aspect.example.loading.FetcherListener;
import com.savvasdalkitsis.android.aspect.example.model.beans.Track;

public class DetailsPresenter {

    private DetailsView detailsView;
    private final Fetcher<Track> trackFetcher;

    public DetailsPresenter(DetailsView detailsView, Fetcher<Track> trackFetcher) {
        this.detailsView = detailsView;
        this.trackFetcher = trackFetcher;
    }

    public void startPresenting() {
        trackFetcher.setListener(new DeliverTrackToViewListener());
        trackFetcher.fetch();
    }

    public void stopPresenting() {
        trackFetcher.clearListener();
    }

    private class DeliverTrackToViewListener implements FetcherListener<Track> {

        @Override
        public void onDataFetched(@NonNull Track data) {
            detailsView.onTrackLoaded(data);
        }

        @Override
        public void onDataFailedToLoad() {

        }
    }
}

package com.savvasdalkitsis.android.aspect.example.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.savvasdalkitsis.android.aspect.example.BuyButton;
import com.savvasdalkitsis.android.aspect.example.R;
import com.savvasdalkitsis.android.aspect.example.analytics.AttachPageViewToRoot;
import com.savvasdalkitsis.android.aspect.example.model.TrackRetriever;
import com.savvasdalkitsis.android.aspect.example.ads.AdConfigurator;
import com.savvasdalkitsis.android.aspect.example.ads.AdFacade;
import com.savvasdalkitsis.android.aspect.example.ads.WithAd;
import com.savvasdalkitsis.android.aspect.example.loading.DataFetcher;
import com.savvasdalkitsis.android.aspect.example.model.DetailsPresenter;
import com.savvasdalkitsis.android.aspect.example.model.DetailsView;
import com.savvasdalkitsis.android.aspect.example.model.beans.Track;
import com.savvasdalkitsis.android.aspect.example.pageview.PageViewConfigurator;
import com.savvasdalkitsis.android.aspect.example.pageview.SecondPage;
import com.savvasdalkitsis.android.aspect.example.pageview.WithPageView;
import com.shazam.android.aspects.base.activity.AspectActivity;

@WithPageView(page = SecondPage.class)
@WithAd(adPageName = "second_page")
@AttachPageViewToRoot
public class SecondActivity extends AspectActivity implements PageViewConfigurator<SecondPage>,
        AdConfigurator, DetailsView {

    public static final String PARAM_TRACK_ID = SecondActivity.class.getName() + ".PARAM_TRACK_ID";
    private String trackID;
    private BuyButton buyButton;
    private DetailsPresenter presenter;
    private TextView track;
    private SecondPage page;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        trackID = getIntent().getStringExtra(PARAM_TRACK_ID);
        track = (TextView) findViewById(R.id.track);
        track.setText(trackID);
        buyButton = (BuyButton) findViewById(R.id.buy_button);
        presenter = new DetailsPresenter(this, new DataFetcher<>(getLoaderManager(), 1, this,
                new TrackRetriever(trackID)));
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
    public void configurePage(SecondPage page) {
        this.page = page;
        this.page.addPageParameter("trackid", trackID);
    }

    @Override
    public void configureAd(AdFacade adFacade) {
        adFacade.addKeyWord("trackId", trackID);
    }

    @Override
    public void onTrackLoaded(Track track) {
        this.track.setText(track.getTitle());
        buyButton.bindTo(track);
    }
}

package com.savvasdalkitsis.android.aspect.example.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.savvasdalkitsis.android.aspect.example.loading.ContentLoadingException;
import com.savvasdalkitsis.android.aspect.example.loading.DataRetriever;
import com.savvasdalkitsis.android.aspect.example.model.beans.Track;

import java.util.List;

public class TrackRetriever implements DataRetriever<Track> {

    private String trackID;

    public TrackRetriever(String trackID) {
        this.trackID = trackID;
    }

    @NonNull
    @Override
    public Track retrieveData() throws ContentLoadingException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Log.w("TrackRetriever", e);
        }
        List<Track> testTracks = TestData.TEST_TRACKS;
        for (Track track : testTracks) {
            if (track.getTrackId().equals(trackID)) {
                return track;
            }
        }
        throw new ContentLoadingException("Found no track with ID: " + trackID);
    }
}

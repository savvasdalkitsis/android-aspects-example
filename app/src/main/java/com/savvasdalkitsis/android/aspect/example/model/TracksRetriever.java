package com.savvasdalkitsis.android.aspect.example.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.savvasdalkitsis.android.aspect.example.loading.ContentLoadingException;
import com.savvasdalkitsis.android.aspect.example.loading.DataRetriever;
import com.savvasdalkitsis.android.aspect.example.model.beans.Track;

import java.util.List;

public class TracksRetriever implements DataRetriever<List<Track>> {

    @NonNull
    @Override
    public List<Track> retrieveData() throws ContentLoadingException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Log.w("TracksRetriever", e);
        }
        return TestData.TEST_TRACKS;
    }
}

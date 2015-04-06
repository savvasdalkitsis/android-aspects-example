package com.savvasdalkitsis.android.aspect.example.model;

import com.savvasdalkitsis.android.aspect.example.model.beans.Track;

import java.util.List;

public interface MainView {
    void onTracksLoaded(List<Track> tracks);
}

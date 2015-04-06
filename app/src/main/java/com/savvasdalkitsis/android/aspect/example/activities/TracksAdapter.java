package com.savvasdalkitsis.android.aspect.example.activities;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.savvasdalkitsis.android.aspect.example.model.beans.Track;
import com.savvasdalkitsis.android.aspect.example.widgets.TrackRowView;

import java.util.List;

public class TracksAdapter extends BaseAdapter {

    private List<Track> tracks;

    public TracksAdapter(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public int getCount() {
        return tracks.size();
    }

    @Override
    public Object getItem(int position) {
        return tracks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        TrackRowView trackRowView = (TrackRowView) convertView;
        if (convertView == null) {
            trackRowView = new TrackRowView(parent.getContext());
        }
        trackRowView.bindTo(tracks.get(position));
        return trackRowView;
    }
}

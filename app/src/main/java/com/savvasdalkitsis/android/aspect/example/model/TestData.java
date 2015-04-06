package com.savvasdalkitsis.android.aspect.example.model;

import com.savvasdalkitsis.android.aspect.example.model.beans.Track;

import java.util.List;
import java.util.UUID;

import static com.savvasdalkitsis.android.aspect.example.model.beans.Track.Builder.track;
import static java.util.Arrays.asList;

public class TestData {
    public static final List<Track> TEST_TRACKS = asList(
            track().withTitle("Smells like teen spirit").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("Firestone").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("Cheerleader").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("Hold my hand").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("Earned it").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("Rumors").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("King").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("Elastic heart").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("Can't stop playing").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("So freaking tight").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("Bloodstream").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("When the beat drops out").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("Lay me down").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("Say something").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("All cried out").withTrackId(UUID.randomUUID().toString()).build(),
            track().withTitle("Hold back the river").withTrackId(UUID.randomUUID().toString()).build()
    );
}

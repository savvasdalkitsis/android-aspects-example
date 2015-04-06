package com.savvasdalkitsis.android.aspect.example.model.beans;

public class Track {

    private String trackId;
    private String title;

    private Track(Builder builder) {
        this.trackId = builder.trackId;
        this.title = builder.title;
    }

    public String getTrackId() {
        return trackId;
    }

    public String getTitle() {
        return title;
    }

    public static class Builder {
        private String trackId;
        private String title;

        public static Builder track() {
            return new Builder();
        }

        public Builder withTrackId(String trackId) {
            this.trackId = trackId;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Track build() {
            return new Track(this);
        }
    }
}

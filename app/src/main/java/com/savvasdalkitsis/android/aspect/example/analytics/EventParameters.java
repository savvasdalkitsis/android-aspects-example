package com.savvasdalkitsis.android.aspect.example.analytics;

import java.util.HashMap;
import java.util.Map;

public class EventParameters {

    private final Map<String, String> params;

    private EventParameters(Builder builder) {
        this.params = builder.params;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public static class Builder {
        private Map<String, String> params = new HashMap<String, String>();

        public static Builder eventParameters() {
            return new Builder();
        }

        public Builder withParam(String key, String value) {
            this.params.put(key, value);
            return this;
        }

        public EventParameters build() {
            return new EventParameters(this);
        }
    }
}

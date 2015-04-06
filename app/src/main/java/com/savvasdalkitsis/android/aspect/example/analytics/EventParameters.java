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

        public static Builder from(EventParameters eventParameters) {
            Builder builder = eventParameters();
            for (Map.Entry<String, String> param : eventParameters.getParams().entrySet()) {
                builder.withParam(param.getKey(), param.getValue());
            }
            return builder;
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

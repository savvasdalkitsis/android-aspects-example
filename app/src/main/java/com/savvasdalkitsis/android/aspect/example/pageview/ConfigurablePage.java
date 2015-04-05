package com.savvasdalkitsis.android.aspect.example.pageview;

import java.util.HashMap;

public abstract class ConfigurablePage implements Page {

    private final HashMap<String, String> parameters = new HashMap<>();

    @Override
    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public void addPageParameter(String key, String value) {
        parameters.put(key, value);
    }
}

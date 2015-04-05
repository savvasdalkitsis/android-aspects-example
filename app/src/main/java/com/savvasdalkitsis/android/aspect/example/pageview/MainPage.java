package com.savvasdalkitsis.android.aspect.example.pageview;

import java.util.Collections;
import java.util.Map;

public class MainPage implements Page {

    @Override
    public String getPageName() {
        return "main";
    }

    @Override
    public Map<String, String> getParameters() {
        return Collections.emptyMap();
    }
}

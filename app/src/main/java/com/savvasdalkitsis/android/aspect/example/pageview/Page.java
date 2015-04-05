package com.savvasdalkitsis.android.aspect.example.pageview;

import java.util.Map;

public interface Page {

    String getPageName();

    Map<String,String> getParameters();
}

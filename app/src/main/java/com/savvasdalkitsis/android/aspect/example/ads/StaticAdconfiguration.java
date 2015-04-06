package com.savvasdalkitsis.android.aspect.example.ads;

import java.util.HashMap;
import java.util.Map;

public class StaticAdconfiguration implements AdConfiguration {

    private final static Map<String, String> AD_IDS = new HashMap<>();
    static {
        AD_IDS.put("second_page", "second_page_ad_id");
    }

    @Override
    public String getAdId(String adPageName) {
        return AD_IDS.get(adPageName);
    }
}

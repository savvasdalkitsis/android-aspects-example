package com.savvasdalkitsis.android.aspect.example.analytics;

import android.view.View;
import android.view.ViewParent;

import com.savvasdalkitsis.android.aspect.example.R;

public class EventParametersFromHierarchy {

    public static EventParameters findInHierarchy(View view) {
        Object tag = view.getTag(R.id.tag_key_event_parameters);
        if (tag != null) {
            return (EventParameters) tag;
        }
        ViewParent parent = view.getParent();
        if (parent != null && parent instanceof View) {
            return findInHierarchy((View) parent);
        }
        return null;
    }
}

package com.savvasdalkitsis.android.aspect.example.pageview;

import com.shazam.android.aspects.annotations.Aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Aspects(aspects = NamedPageView.class)
public @interface WithPageView {

    String pageName();
}

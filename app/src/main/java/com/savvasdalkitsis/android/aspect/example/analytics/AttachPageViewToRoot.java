package com.savvasdalkitsis.android.aspect.example.analytics;

import com.shazam.android.aspects.annotations.Aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Aspects(aspects = AttachPageViewToRootAspect.class)
public @interface AttachPageViewToRoot {
}

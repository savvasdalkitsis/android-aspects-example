package com.savvasdalkitsis.android.aspect.example.pageview;

public interface PageViewConfigurator<T extends ConfigurablePage> {

    void configurePage(T page);

}

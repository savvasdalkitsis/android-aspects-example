package com.savvasdalkitsis.android.aspect.example.pageview;

public class DefaultActivityPageViewStrategyFactory implements ActivityPageViewStrategyFactory {

    private final PageViewSessionManager pageViewSessionManager = new PageViewSessionManager();

    @Override
    public ActivityPageViewStrategy createSessionStrategy(PageViewStrategy strategyType) {
        switch (strategyType) {
            case RESUME_PAUSE:
                return new ResumePauseActivityPageViewStrategy(pageViewSessionManager);
            case START_STOP:
                return new StartStopActivityPageViewStrategy(pageViewSessionManager);
        }
        return new ActivityPageViewStrategy(){};
    }
}

package com.epam.spring.loggers;

import com.epam.spring.events.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger{

    Collection loggers;

    CombinedEventLogger(Collection loggers){
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        loggers.forEach(lgr -> logEvent(event));
    }

}

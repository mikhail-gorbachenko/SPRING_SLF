package com.epam.spring.loggers;

import com.epam.spring.events.Event;

import java.util.Collection;
import java.util.List;

public class CombinedEventLogger implements EventLogger{

    private Collection<EventLogger> loggers;

    CombinedEventLogger(Collection<EventLogger> loggers){
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger:loggers) { //почему здесь не сработала лямбда?
            logger.logEvent(event);
        }
    }

}

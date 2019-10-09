package com.epam.spring.loggers;

import com.epam.spring.events.Event;

public interface EventLogger {

    void logEvent(Event event);

}

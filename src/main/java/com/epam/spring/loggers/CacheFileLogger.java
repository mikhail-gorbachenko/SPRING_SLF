package com.epam.spring.loggers;

import com.epam.spring.events.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

    CacheFileLogger(String path, String encoding, int cacheSize) {
        super(path, encoding);
        this.cacheSize = cacheSize;
        cache = new ArrayList<Event>(cacheSize);
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        cache.forEach(super::logEvent);
    }

    private void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
    }

}

package com.epam.spring;

import com.epam.spring.events.Event;
import com.epam.spring.events.EventType;
import com.epam.spring.loggers.EventLogger;
import com.epam.spring.objects.Client;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

import static com.epam.spring.events.EventType.ERROR;
import static com.epam.spring.events.EventType.INFO;

public class App {

    private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    private Client cl;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client cl, EventLogger logger, Map<EventType, EventLogger> loggers) {
        this.cl = cl;
        this.defaultLogger = logger;
        this.loggers = loggers;
    }

    private void logEvent(EventType type, String msg) {

        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }

        Event event = (Event) ctx.getBean("event");
        String message = msg.replaceAll(cl.getId(), cl.getName());
        event.setMsg(message);
        logger.logEvent(event);
    }


    public static void main(String[] args) {

        App app = (App) ctx.getBean("app");
        app.logEvent(ERROR, "Don't mess with 1");
        app.logEvent(INFO, "Don't mess with 1");
        app.logEvent(null, "Don't mess with 1");
        ctx.close();

    }

}

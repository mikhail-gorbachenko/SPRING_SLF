package com.epam.spring;

import com.epam.spring.events.Event;
import com.epam.spring.loggers.EventLogger;
import com.epam.spring.objects.Client;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    private Client cl;
    private EventLogger cel;

    public App(Client cl, EventLogger cel) {
        this.cl = cl;
        this.cel = cel;
    }

    private void logEvent(String msg){
        Event event = (Event) ctx.getBean("event");
        String message = msg.replaceAll(cl.getId(), cl.getName());
        event.setMsg(message);
        cel.logEvent(event);
    }



    public static void main(String[] args) {

        App app =  (App) ctx.getBean("app");
        app.logEvent("Don't mess with 1");
        ctx.close();

    }

}

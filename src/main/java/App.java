import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    Client cl;
    ConsoleEventLogger cel;

    public App(Client cl, ConsoleEventLogger cel) {
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

    }

}

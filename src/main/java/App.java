import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    Client cl;
    ConsoleEventLogger cel;

    public App(Client cl, ConsoleEventLogger cel) {
        this.cl = cl;
        this.cel = cel;
    }

    private void logEvent(String msg){
        String message = msg.replaceAll(cl.getId(), cl.getName());
        cel.logEvent(message);
    }



    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        app.logEvent("Don't mess with 1");

    }

}

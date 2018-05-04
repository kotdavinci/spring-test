import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class App {
    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(String msg) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Event event = (Event) context.getBean("event");
        event.setMsg(msg);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        app.logEvent("some event for user 1");
        app.logEvent("some event for 2");
        app.logEvent("some event for 3");
        app.logEvent("some event for 4");
        app.logEvent("some event for 5");

        ctx.close();
    }
}

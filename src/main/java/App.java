import beans.Client;
import beans.Event;
import beans.EventType;
import loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;

    private Map<EventType, EventLogger> loggers;

    public App(Client client, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.loggers = loggers;
    }

    public void logEvent(EventType type, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        eventLogger = loggers.get(type);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "some event for user 1"); // console

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "some event for 2"); // console + file = combined

        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "some event for 3"); // cached = default

        ctx.close();
    }
}

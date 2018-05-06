package loggers;

import beans.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger{
    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }

    }
}

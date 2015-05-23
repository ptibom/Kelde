package se.computerscience.kelde.controller.events;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Eventbus for managing screens.
 *
 * @author: Philip Tibom
 */
public enum  ScreenEventBus {
    INSTANCE;

    private final List<IScreenEventHandler> handlers = new ArrayList<>();

    public void register(IScreenEventHandler handler) {
        handlers.add(handler);
    }

    public void unregister(IScreenEventHandler handler) {
        handlers.remove(handler);
    }

    public void publish(ScreenEvent event) {
        for (final IScreenEventHandler handler : handlers) {
            handler.onScreenChange(event);
        }
    }

    public void unregisterAll () {
        handlers.clear();
    }
}

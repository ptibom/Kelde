package se.computerscience.kelde.controller.events;

import java.util.ArrayList;
import java.util.List;

public enum ItemEventBus {
    INSTANCE;

    private final List<IItemEventHandler> handlers = new ArrayList<>();

    public void register(IItemEventHandler handler) {
        handlers.add(handler);
    }

    public void unregister(IItemEventHandler handler) {
        handlers.remove(handler);
    }

    public void publish(ItemEvent event) {
        for (IItemEventHandler handler : handlers) {
            handler.onEvent(event);

        }
    }

    public void unregisterAll () {
        handlers.clear();
    }
}
/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.events;

import java.util.ArrayList;
import java.util.List;

public enum ModifyPlayerEventBus {
    INSTANCE;

    private final List<IModifyPlayerEventHandler> handlers = new ArrayList<>();

    public void register(IModifyPlayerEventHandler handler) {
        handlers.add(handler);
    }

    public void unregister(IModifyPlayerEventHandler handler) {
        handlers.remove(handler);
    }

    public void publish(ModifyPlayerEvent event) {
        for (final IModifyPlayerEventHandler handler : handlers) {
            handler.onModifyPlayerEvent(event);
        }
    }

    public void unregisterAll() {
        handlers.clear();
    }
}
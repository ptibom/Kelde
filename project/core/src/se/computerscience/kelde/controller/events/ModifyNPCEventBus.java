/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.events;

import java.util.ArrayList;
import java.util.List;

public enum  ModifyNPCEventBus {
    INSTANCE;

    private final List<IModifyNPCEventHandler> handlers = new ArrayList<>();

    public void register(IModifyNPCEventHandler handler) {
        handlers.add(handler);
    }

    public void unregister(IModifyNPCEventHandler handler) {
        handlers.remove(handler);
    }

    public void publish(ModifyNPCEvent event) {
        for (final IModifyNPCEventHandler handler : handlers) {
            handler.onModifyNPCEvent(event);
        }
    }

    public void unregisterAll () {
        handlers.clear();
    }
}
package se.computerscience.kelde.controller.events;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anders on 2015-05-25.
 *
 * @author Anders Bolin
 */
public enum  MonsterEventBus {
    INSTANCE;

    private final List<IMonsterEventHandler> handlers = new ArrayList<>();

    public void register(IMonsterEventHandler handler) {
        handlers.add(handler);
    }

    public void unregister(IMonsterEventHandler handler) {
        handlers.remove(handler);
    }

    public void publish(MonsterEvent event) {
        for (final IMonsterEventHandler handler : handlers) {
            handler.onMonsterEvent(event);
        }
    }

    public void unregisterAll () {
        handlers.clear();
    }
}

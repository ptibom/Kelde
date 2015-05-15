/**
 * Description: Singleton EventBus, to distribute collisions to various controllers.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller.events;


import java.util.ArrayList;
import java.util.List;

public enum CollisionEventBus {

    INSTANCE;

    private final List<ICollisionEventHandler> handlers = new ArrayList<>();

    public void register(ICollisionEventHandler handler) {
        handlers.add(handler);
    }

    public void unregister(ICollisionEventHandler handler) {
        handlers.remove(handler);
    }

    public void publish(CollisionEvent event) { // No need for Event-Tags. We want to reduce uses of "new" in game-loop.
        for (ICollisionEventHandler handler : handlers) {
            handler.onCollisionEvent(event);
        }
    }
}

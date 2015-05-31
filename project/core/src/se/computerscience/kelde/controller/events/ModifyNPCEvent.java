/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.events;

public class ModifyNPCEvent {
    public enum Tag {
        DAMAGE;
    }

    private final Tag tag;
    private final Object object;
    private final int damage;

    public ModifyNPCEvent(Tag tag, Object object, int damage) {
        this.tag = tag;
        this.object = object;
        this.damage = damage;
    }

    public Tag getTag() {
        return tag;
    }

    public Object getObject() {
        return object;
    }

    public int getDamage() {
        return damage;
    }
}
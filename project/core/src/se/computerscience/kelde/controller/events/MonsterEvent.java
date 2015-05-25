package se.computerscience.kelde.controller.events;

/**
 * Created by Anders on 2015-05-25.
 *
 * @author Anders Bolin
 */
public class MonsterEvent {

    public enum MonsterTag {
        START_WORLD, LAVA_WORLD, START_MENU
    }

    private final MonsterTag tag;

    public MonsterEvent(MonsterTag tag) {
        this.tag = tag;
    }

    public MonsterTag getTag() {
        return tag;
    }

}

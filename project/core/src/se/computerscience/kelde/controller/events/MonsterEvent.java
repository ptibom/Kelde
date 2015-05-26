package se.computerscience.kelde.controller.events;

/**
 * Created by Anders on 2015-05-25.
 *
 * @author Anders Bolin
 */
public class MonsterEvent {


    private final Object object;

    public MonsterEvent(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

}

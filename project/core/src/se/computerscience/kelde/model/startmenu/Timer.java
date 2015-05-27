package se.computerscience.kelde.model.startmenu;

/**
 * @author: Daniel Olsson
 */

public class Timer {

    private float stateTime;

    public void updateStateTime(float delta) {
        stateTime += delta;
    }

    public float getStateTime() {

        return stateTime;
    }


}

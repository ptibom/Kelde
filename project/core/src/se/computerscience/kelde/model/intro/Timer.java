package se.computerscience.kelde.model.intro;

/**
 * @author: Daniel Olsson
 */
public class Timer {

    private double startTime;
    private double menuTime;
    private float stateTime;


    public void updateTimer() {
        menuTime = System.currentTimeMillis() - startTime;
    }


    public void updateStateTime(float delta) {
        stateTime += delta;
    }

    public float getStateTime() {

        return stateTime;
    }


    public double getMenuTime() {

        return menuTime;
    }

    public void resetTimer() {

        startTime = System.currentTimeMillis();

    }

    public void setStartTime(float startTime) {


    }


    public void addTimerTIme(double t) {

        menuTime += t;
    }


}

package se.computerscience.kelde.model.startmenu;

import com.badlogic.gdx.Gdx;

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


    public void updateStateTime(){
        stateTime += Gdx.graphics.getDeltaTime();
    }

    public float getStateTime(){

        return stateTime;
    }

    public float getDeltaTime(){

        return Gdx.graphics.getDeltaTime();
    }

    public double getMenuTime(){

        return menuTime;
    }

    public void resetTimer(){

        startTime = System.currentTimeMillis();

    }

    public void setStartTime(float startTime){


    }


    public void addTimerTIme(double t){

        menuTime += t;
    }


}

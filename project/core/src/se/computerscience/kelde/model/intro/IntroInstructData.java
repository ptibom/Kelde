package se.computerscience.kelde.model.intro;

/**
 * Created by Daniel on 5/27/2015.
 */
public class IntroInstructData {

    private final int xVelocity;
    private final int yVelocity;
    private final int  heightChange;
    private final int widthChange;


    public IntroInstructData(int xVelocity, int yVelocity, int heightChange, int widthChange){
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.heightChange = heightChange;
        this.widthChange = widthChange;
    }


    public int getXvel(){
        return xVelocity;
    }

    public int getYvel(){
        return yVelocity;
    }

    public int getHeightChange(){
        return heightChange;
    }

    public int getWidthChange(){
        return widthChange;
    }
}

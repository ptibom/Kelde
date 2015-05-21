package se.computerscience.kelde.model.intro;

/**
 * @author: Daniel Olsson
 */

public class IntroInstruction {

    private boolean flipped;
    private double startCount = 0;
    private float keyFrame = -1;
    private int dialogNumber = -1;
    private double startTime = 0;
    private double endTime = 0;
    private double xvelocity = 0;
    private double yvelocity = 0;
    private double widthChange = 0;
    private double heightChange = 0;
    private String animationName;

    public IntroInstruction(int dialogNumber, double startTime, double endTime) {

        this.dialogNumber = dialogNumber;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public IntroInstruction(double startCount, double startTime, double endTime, String animationName) {

        this.startCount = startCount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.animationName = animationName;
    }

    public IntroInstruction(double startTime, double endTime, int widthChange, int heightChange, int xvelocity, int yvelocity, String animationName) {

        this.startTime = startTime;
        this.endTime = endTime;
        this.widthChange = widthChange;
        this.heightChange = heightChange;
        this.xvelocity = xvelocity;
        this.yvelocity = yvelocity;
        this.animationName = animationName;

    }

    public IntroInstruction(double startTime, double endTime, float keyFrame, int widthChange, int heightChange, int xvelocity, int yvelocity, String animationName) {
        this.keyFrame = keyFrame;
        this.startTime = startTime;
        this.endTime = endTime;
        this.widthChange = widthChange;
        this.heightChange = heightChange;
        this.xvelocity = xvelocity;
        this.yvelocity = yvelocity;
        this.animationName = animationName;

    }

    public float getKeyFrame() {
        return keyFrame;

    }

    public double getStartTime() {
        return startTime;

    }

    public double getEndTime() {

        return endTime;
    }

    public double getXVelocity() {
        return xvelocity;

    }

    public double getYVelocity() {

        return yvelocity;
    }

    public double getWidthChange() {

        return widthChange;
    }

    public double getHeightChange() {
        return heightChange;

    }
    public boolean isFlipped(){
        return flipped;
    }

    public String getAnimationName() {
        return animationName;
    }

    public int getDialogNumber() {
        return dialogNumber;
    }

    public double getStartCount() {
        return startCount;
    }


}

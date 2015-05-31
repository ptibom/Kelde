package se.computerscience.kelde.model.intro;

/**
 * @author: Daniel Olsson
 */

public class IntroInstruction {

    private boolean flipped;
    private double startCount;
    private float keyFrame = -1;
    private int dialogNumber = -1;
    private final double  startTime;
    private final double endTime;
    private IntroInstructData instructData;
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
        instructData = new IntroInstructData(xvelocity,yvelocity,widthChange,heightChange);
        this.animationName = animationName;
    }

    public IntroInstruction(double startTime, double endTime, float keyFrame, int widthChange, int heightChange, int xvelocity, int yvelocity, String animationName) {
        this.keyFrame = keyFrame;
        this.startTime = startTime;
        this.endTime = endTime;
        instructData = new IntroInstructData(xvelocity,yvelocity,widthChange,heightChange);
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

    public IntroInstructData getInstructData() {
        return instructData;
    }

    public boolean isFlipped() {
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

package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.intro.AnimationService;
import se.computerscience.kelde.model.intro.AnimationToolsUtilites;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.model.intro.IntroInstruction;

import java.util.Map;

/**
 * @author: Daniel Olsson
 */
public class AnimationHandler {

    private double introDelay;
    private Intro introModel;
    private TextureRegion currentFrame;
    private Map<String, Animation> animations;
    private final int ORIGIN_X, ORIGIN_Y;
    private int  width, height;
    private double offsetX, offsetY, heightChangeX, heightChangeY;
    private int[] animPathInterpolatedX;
    private int[] animPathInterpolatedY;


    // An animationhandler suited for each specificn sprite with their own coordinates and height

    public AnimationHandler(Intro introModel, Map<String, Animation> animations, int x, int y, int height, int width, double introDelay) {
        this.width = width;
        this.height = height;
        this.introModel = introModel;
        this.animations = animations;
        this.ORIGIN_X = x;
        this.ORIGIN_Y = y;
        this.introDelay = introDelay;

    }

    public void drawAnimation(SpriteBatch batch, AnimationService animationloader, IntroInstruction instruct, double scale) {

        boolean isFlipped = instruct.isFlipped();
        double startCount = instruct.getStartCount();
        double startTime = instruct.getStartTime();
        double endTime = instruct.getEndTime();
        String animation = instruct.getAnimationName();


        //Drawing an interpolated animation using X and Y coordinates from arrays,

        if (AnimationToolsUtilites.timeRange(introModel.getMenuTime(), startTime + introDelay, endTime + introDelay)) {

            double timePassed = introModel.getMenuTime() / 1000 - startCount - introDelay;

            animPathInterpolatedX = animationloader.getInterpolDataX();
            animPathInterpolatedY = animationloader.getInterpolDataY();


            float interPolX = (float) (animPathInterpolatedX[(int) (timePassed * 24)]);
            float interPolY = (float) (animPathInterpolatedY[(int) (timePassed * 24)]);

            currentFrame = animations.get(animation).getKeyFrame(introModel.getStateTime(), true);

            spriteFlip(currentFrame, isFlipped);

            batch.draw(currentFrame, (int)(interPolX*scale), (int)(interPolY*scale), (int)(100*scale), (int)(100*scale));

        }


    }

    //Drawing a moving character
    public void drawAnimation(SpriteBatch batch, IntroInstruction instruct, float delta, double scale) {


        boolean isFlipped = instruct.isFlipped();
        double startTime = instruct.getStartTime();
        double endTime = instruct.getEndTime();
        int widthChange = (int) instruct.getInstructData().getWidthChange();
        int heightChange = (int) instruct.getInstructData().getHeightChange();
        int xvelocity = (int) instruct.getInstructData().getXvel();
        int yvelocity = (int) instruct.getInstructData().getYvel();
        String animation = instruct.getAnimationName();


        if (AnimationToolsUtilites.timeRange(introModel.getMenuTime(), startTime + introDelay, endTime + introDelay)) {

            calculateNewDrawValues(xvelocity, yvelocity, widthChange, heightChange, delta);

            currentFrame = animations.get(animation).getKeyFrame(introModel.getStateTime(), true);

            spriteFlip(currentFrame, isFlipped);

            int heightIn = (int)(height + (int) heightChangeY);
            int widthIn = this.width + (int) this.heightChangeX;
            int xIn =  ORIGIN_X + (int) offsetX;
            int yIn = ORIGIN_Y + (int) offsetY;


            batch.draw(currentFrame,(int)(xIn*scale),(int)(yIn*scale), (int)(widthIn*scale),(int)(heightIn*scale) );

        }


    }


    // Drawing a still image
    public void drawAnimation(SpriteBatch batch, IntroInstruction instruct, float delta, float specialKeyframe, double scale) {

        double startTime = instruct.getStartTime();
        double endTime = instruct.getEndTime();
        int widthChange = instruct.getInstructData().getWidthChange();
        int heightChange = instruct.getInstructData().getHeightChange();
        int xvelocity =  instruct.getInstructData().getXvel();
        int yvelocity =  instruct.getInstructData().getYvel();
        String animation = instruct.getAnimationName();


        // This function will be used if you want to lock the animation in to a certain keyframe
        if (AnimationToolsUtilites.timeRange(introModel.getMenuTime(), startTime + introDelay, endTime + introDelay)) {

            calculateNewDrawValues(xvelocity, yvelocity, widthChange, heightChange, delta);

            currentFrame = animations.get(animation).getKeyFrame(specialKeyframe, true);

            int xIn = ORIGIN_X + (int) offsetX;
            int yIn =  ORIGIN_Y + (int) offsetY;
            int widthIn = width + (int) heightChangeX;
            int heightIn = height + (int) heightChangeY;

            batch.draw(currentFrame,(int)(xIn*scale) ,(int)(yIn*scale),(int)(widthIn*scale) ,(int)(heightIn*scale) );

        }


    }


    //calculating new x and y values as well as height and weight
    public void calculateNewDrawValues(int xvelocity, int yvelocity, int widthChange, int heightChange, float delta) {

        this.heightChangeX += heightChange * delta;
        this.heightChangeY += widthChange * delta;
        this.offsetX += xvelocity * delta;
        this.offsetY += yvelocity * delta;

    }

    // To flip or not to flip the sprite
    public void spriteFlip(TextureRegion currentFrame, boolean drawFlipped) {

        if (drawFlipped) {
            if (!currentFrame.isFlipX()) {
                currentFrame.flip(true, false);
            }

        } else {

            if (currentFrame.isFlipX()) {
                currentFrame.flip(true, false);
            }
        }

    }


}

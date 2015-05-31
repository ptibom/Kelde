package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.intro.AnimationService;
import se.computerscience.kelde.model.intro.AnimationTools;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.model.intro.IntroInstruction;

import java.util.Map;

/**
 * @author: Daniel Olsson
 */
public class AnimationHandler {

    private final double INTRO_DELAY;
    final private Intro introModel;
    private TextureRegion currentFrame;
    final private Map<String, Animation> animations;
    private final int ORIGIN_X, ORIGIN_Y;
    private final int width, height;
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
        INTRO_DELAY = introDelay;

    }

    public void drawAnimation(SpriteBatch batch, AnimationService animationloader, IntroInstruction instruct, double scale) {

        //Drawing an interpolated animation using X and Y coordinates from arrays,
        if (AnimationTools.timeRange(introModel.getMenuTime(), instruct.getStartTime() + INTRO_DELAY, instruct.getEndTime() + INTRO_DELAY)) {

            final double timePassed = introModel.getMenuTime() / 1000 - instruct.getStartCount() - INTRO_DELAY;

            animPathInterpolatedX = animationloader.getInterpolDataX();
            animPathInterpolatedY = animationloader.getInterpolDataY();


            final float interPolX = (float) (animPathInterpolatedX[(int) (timePassed * 24)]);
            final float interPolY = (float) (animPathInterpolatedY[(int) (timePassed * 24)]);

            currentFrame = animations.get(instruct.getAnimationName()).getKeyFrame(introModel.getStateTime(), true);

            spriteFlip(currentFrame, instruct.isFlipped());

            batch.draw(currentFrame, (int) (interPolX * scale), (int) (interPolY * scale), (int) (100 * scale), (int) (100 * scale));

        }
    }

    //Drawing a moving character
    public void drawAnimation(SpriteBatch batch, IntroInstruction instruct, float delta, double scale) {

        if (AnimationTools.timeRange(introModel.getMenuTime(), instruct.getStartTime() + INTRO_DELAY, instruct.getEndTime() + INTRO_DELAY)) {

            calculateNewDrawValues(instruct.getInstructData().getXvel(), instruct.getInstructData().getYvel(),
                    instruct.getInstructData().getWidthChange(), instruct.getInstructData().getHeightChange(), delta);

            currentFrame = animations.get(instruct.getAnimationName()).getKeyFrame(introModel.getStateTime(), true);

            spriteFlip(currentFrame, instruct.isFlipped());

            final int heightIn = height + (int) heightChangeY;
            final int widthIn = this.width + (int) this.heightChangeX;
            final int xIn = ORIGIN_X + (int) offsetX;
            final int yIn = ORIGIN_Y + (int) offsetY;

            batch.draw(currentFrame, (int) (xIn * scale), (int) (yIn * scale), (int) (widthIn * scale), (int) (heightIn * scale));
        }
    }

    // Drawing a still image
    public void drawAnimation(SpriteBatch batch, IntroInstruction instruct, float delta, float specialKeyframe, double scale) {

        // This function will be used if you want to lock the animation in to a certain keyframe
        if (AnimationTools.timeRange(introModel.getMenuTime(), instruct.getStartTime() + INTRO_DELAY, instruct.getEndTime() + INTRO_DELAY)) {

            calculateNewDrawValues(instruct.getInstructData().getXvel(), instruct.getInstructData().getYvel(),
                    instruct.getInstructData().getWidthChange(), instruct.getInstructData().getHeightChange(), delta);

            currentFrame = animations.get(instruct.getAnimationName()).getKeyFrame(specialKeyframe, true);

            final int xIn = ORIGIN_X + (int) offsetX;
            final int yIn = ORIGIN_Y + (int) offsetY;
            final int widthIn = width + (int) heightChangeX;
            final int heightIn = height + (int) heightChangeY;

            batch.draw(currentFrame, (int) (xIn * scale), (int) (yIn * scale), (int) (widthIn * scale), (int) (heightIn * scale));
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

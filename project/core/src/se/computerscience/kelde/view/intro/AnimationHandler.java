package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.intro.AnimationLoader;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.startmenu.AnimationTools;

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
    private int xvelocity, yvelocity, width, height;
    private double offsetX, offsetY, heightChangeX, heightChangeY;
    private int[] animPathInterpolatedX;
    private int[] animPathInterpolatedY;


    // Animeringsklassen håller reda på all animeringsdata för en speciell sprite

    public AnimationHandler(Intro introModel, Map<String, Animation> animations, int x, int y, int height, int width, double introDelay) {
        this.width = width;
        this.height = height;
        this.introModel = introModel;
        this.animations = animations;
        this.ORIGIN_X = x;
        this.ORIGIN_Y = y;
        this.introDelay = introDelay;

    }

    public void drawAnimation(SpriteBatch batch, AnimationLoader animationloader, double startCount, double startTime, double endTime, String animation) {

        if (AnimationTools.timeRange(introModel.getMenuTime(), startTime + introDelay, endTime + introDelay)) {

            double timePassed = introModel.getMenuTime() / 1000 - startCount - introDelay;

            animPathInterpolatedX = animationloader.getInterpolDataX();
            animPathInterpolatedY = animationloader.getInterpolDataY();


            float interPolX = (float) (animPathInterpolatedX[(int) (timePassed * 24)]);
            float interPolY = (float) (animPathInterpolatedY[(int) (timePassed * 24)]);

            currentFrame = animations.get(animation).getKeyFrame(introModel.getStateTime(), true);
            batch.draw(currentFrame, interPolX, interPolY, 100, 100);

        }


    }

    public void drawAnimation(SpriteBatch batch, double startTime, double endTime, int widthChange, int heightChange, int xvelocity, int yvelocity, String animation, float delta) {

        // We get in the speed in x and y way, as well as height change and width change.

        if (AnimationTools.timeRange(introModel.getMenuTime(), startTime + introDelay, endTime + introDelay)) {

            calculateNewDrawValues(xvelocity, yvelocity, widthChange, heightChange, delta);

            currentFrame = animations.get(animation).getKeyFrame(introModel.getStateTime(), true);
            batch.draw(currentFrame, ORIGIN_X + (int) offsetX, ORIGIN_Y + (int) offsetY, this.width + (int) this.heightChangeX, this.height + (int) heightChangeY);
        }


    }

    public void drawAnimation(SpriteBatch batch, double startTime, double endTime, float keyFrame, int widthChange, int heightChange, int xvelocity, int yvelocity, String animation, float delta) {

        // This function will be used if you want to lock the animation in to a certain keyframe
        if (AnimationTools.timeRange(introModel.getMenuTime(), startTime + introDelay, endTime + introDelay)) {

            calculateNewDrawValues(xvelocity, yvelocity, widthChange, heightChange, delta);

            currentFrame = animations.get(animation).getKeyFrame(keyFrame, true);
            batch.draw(currentFrame, ORIGIN_X + (int) offsetX, ORIGIN_Y + (int) offsetY, this.width + (int) this.heightChangeX, this.height + (int) heightChangeY);

        }


    }


    public void drawAnimation(SpriteBatch batch, double startTime, double endTime, int widthChange, int heightChange,
                              int xvelocity, int yvelocity, String animation, boolean drawFlipped, float delta) {

        // This function will be drawn if you want to flip the image


        if (AnimationTools.timeRange(introModel.getMenuTime(), startTime + introDelay, endTime + introDelay)) {

            calculateNewDrawValues(xvelocity, yvelocity, widthChange, heightChange, delta);

            currentFrame = animations.get(animation).getKeyFrame(introModel.getStateTime(), true);


            if (drawFlipped) {
                if (!currentFrame.isFlipX()) {
                    currentFrame.flip(true, false);
                }

            } else {

                if (currentFrame.isFlipX()) {
                    currentFrame.flip(true, false);
                }
            }


            batch.draw(currentFrame, ORIGIN_X + (int) offsetX, ORIGIN_Y + (int) offsetY, this.width + (int) this.heightChangeX, this.height + (int) heightChangeY);

        }


    }

    //calculating new x and y values as well as height and weight
    public void calculateNewDrawValues(int xvelocity, int yvelocity, int widthChange, int heightChange, float delta) {

        this.heightChangeX += heightChange * delta;
        this.heightChangeY += widthChange * delta;
        this.offsetX += xvelocity * delta;
        this.offsetY += yvelocity * delta;

    }


}

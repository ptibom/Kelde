package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.intro.AnimationLoader;
import se.computerscience.kelde.model.startmenu.StartMenu;

import java.util.Map;

/**
 * Created by Daniel on 5/19/2015.
 */
public class AnimationHandler {

        private StartMenu startMenuModel;
        private TextureRegion currentFrame;
        private Map<String, Animation> animations;
        private final int ORIGIN_X, ORIGIN_Y;
        private int  xvelocity,yvelocity,width,height;
        private double offsetX, offsetY, heightChangeX,heightChangeY;
        private boolean resetTrigger = true;
        private int[] animPathInterpolatedX;
        private int[] animPathInterpolatedY;


    // Animeringsklassen håller reda på all animeringsdata för en speciell sprite

    public AnimationHandler(StartMenu startMenuModel, Map<String, Animation> animations, int x, int y, int height, int width){
        this.width = width;
        this.height = height;
        this.startMenuModel = startMenuModel;
        this.animations = animations;
        this.ORIGIN_X = x;
        this.ORIGIN_Y = y;

    }

    public void drawAnimation(SpriteBatch batch, AnimationLoader animationloader,double startCount,double startTime, double endTime, String animation){

        if(AnimationTools.timeRange(startMenuModel.getMenuTime(), startTime,endTime)){

            double timePassed = startMenuModel.getMenuTime()/1000-startCount;

            animPathInterpolatedX = animationloader.getInterpolDataX();
            animPathInterpolatedY = animationloader.getInterpolDataY();


            float interPolX = (float)(animPathInterpolatedX[(int)(timePassed*24)] );
            float interPolY  = (float)(animPathInterpolatedY[(int)(timePassed * 24)]);

            currentFrame = animations.get(animation).getKeyFrame(startMenuModel.getStateTime(), true);
            batch.draw(currentFrame, interPolX, interPolY, 100, 100);

        }


    }

    public void drawAnimation(SpriteBatch batch, double startTime, double endTime, int widthChange, int heightChange,int xvelocity, int yvelocity, String animation){

        // Vi får in förändringsdata för X och Y koordinaterna såväl som för storleksförändringen för spritsen

        if(AnimationTools.timeRange(startMenuModel.getMenuTime(), startTime,endTime)){

            calculateNewDrawValues(xvelocity,yvelocity,widthChange,heightChange);

            currentFrame = animations.get(animation).getKeyFrame(startMenuModel.getStateTime(), true);
            batch.draw(currentFrame, ORIGIN_X+(int)offsetX, ORIGIN_Y + (int)offsetY, this.width+(int)this.heightChangeX, this.height + (int) heightChangeY);
        }


    }

    public void drawAnimation(SpriteBatch batch, double startTime, double endTime, float keyFrame, int widthChange, int heightChange,int xvelocity, int yvelocity, String animation){

        // Överladdad funktion, ifall du vill ha en speciell keyframe hela tiden.
        if(AnimationTools.timeRange(startMenuModel.getMenuTime(), startTime, endTime)){

            calculateNewDrawValues(xvelocity,yvelocity,widthChange,heightChange);

            currentFrame = animations.get(animation).getKeyFrame(keyFrame, true);
            batch.draw(currentFrame, ORIGIN_X+(int)offsetX,ORIGIN_Y + (int)offsetY, this.width+(int)this.heightChangeX, this.height + (int) heightChangeY);

        }




    }


    public void drawAnimation(SpriteBatch batch, double startTime, double endTime, int widthChange, int heightChange,
                              int xvelocity, int yvelocity, String animation,boolean drawFlipped){

        // Överladdad funktion, ifall du vill flippa en animation




        if(AnimationTools.timeRange(startMenuModel.getMenuTime(), startTime, endTime)){

            calculateNewDrawValues(xvelocity,yvelocity,widthChange,heightChange);

            currentFrame = animations.get(animation).getKeyFrame(startMenuModel.getStateTime(), true);


            if(drawFlipped){
                if(!currentFrame.isFlipX()){
                    currentFrame.flip(true,false);
                }

            }
            else{

                if(currentFrame.isFlipX()){
                    currentFrame.flip(true,false);
                }
            }




            batch.draw(currentFrame, ORIGIN_X+(int)offsetX,ORIGIN_Y + (int)offsetY, this.width+(int)this.heightChangeX, this.height + (int) heightChangeY);

        }




    }


    public void calculateNewDrawValues(int xvelocity, int yvelocity, int widthChange, int heightChange){

        this.heightChangeX += heightChange *startMenuModel.getDeltaTime();
        this.heightChangeY += widthChange *startMenuModel.getDeltaTime();
        this.offsetX += xvelocity *startMenuModel.getDeltaTime();
        this.offsetY += yvelocity*startMenuModel.getDeltaTime();

    }





}

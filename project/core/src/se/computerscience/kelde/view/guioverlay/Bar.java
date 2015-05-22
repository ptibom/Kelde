package se.computerscience.kelde.view.guioverlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author: Daniel Olsson
 */
public class Bar {

// This class does the work for the subclasses.
    protected Texture progressBarBackground;
    protected Texture progressBarForeground;
    protected Texture progressBar;
    protected TextureRegion barLengthRegion;
    protected  int barWidth, barHeight;
    protected final int barPositionX, barPositionY;

    protected Bar(int barPositionX, int barPositionY){
        this.barPositionX = barPositionX;
        this.barPositionY = barPositionY;
    }

    public void render(SpriteBatch batch,  int health){
        batch.draw(progressBarBackground, barPositionX, barPositionY);
        batch.draw(barLengthRegion,barPositionX+24,barPositionY+12,(int)calculateNewStatusBar(health) , barHeight);
        batch.draw(progressBarForeground, barPositionX, barPositionY);
    }

    // We want to initialize the bar on load
    public void initBar(int health){
        barWidth = 154;
        barHeight =26;
        barLengthRegion = new TextureRegion(progressBar,24,12,barWidth,barHeight);
    }

    // returns the new  value of the length of the bar
    public double calculateNewStatusBar(int health){
        double calcBarWidth = barWidth;
        return   (calcBarWidth/100) * health;
    }

}

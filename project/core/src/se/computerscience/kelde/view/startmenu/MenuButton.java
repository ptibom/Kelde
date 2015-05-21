/**
 * @author: Daniel Olsson
 */

package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;


public class MenuButton extends Button {

    Sprite buttonSprite;
    int loadx, loady;
    int loadHeight, loadWidth;
    int newx, newy;
    int newHeight, newWidth;
    int exitx, exity;
    int exitHeight, exitWidth;


    public MenuButton(Texture texture, float x, float y, float width, float height) {
        buttonSprite = new Sprite(texture); // your image
        buttonSprite.setPosition(x, y);
        buttonSprite.setSize(width, height);

        newy = 586;
        newx = 781;
        newWidth = 302;
        newHeight = 113;
        loady = 473;
        loadx = 781;
        loadWidth = 302;
        loadHeight = 113;
        exitx = 1083;
        exity = 586;
        exitWidth = 93;
        exitHeight = 241;


    }

    public void update(SpriteBatch batch) {


        buttonSprite.draw(batch); // draw the button
    }


    public int checkIfClicked(float ix, float iy, boolean isTouched) {
        if (isTouched) {

            if ((ix > newx && ix < newx + newWidth) && (iy < newy && iy > newy - newHeight)) {
                return 1;

            }

            if ((ix > loadx && ix < loadx + loadWidth) && (iy < loady && iy > loady - loadHeight)) {
                return 2;

            }

            if ((ix > exitx && ix < exitx + exitWidth) && (iy < exity && iy > exity - exitHeight)) {
                return 3;

            }


        }
        return 0;
    }


}

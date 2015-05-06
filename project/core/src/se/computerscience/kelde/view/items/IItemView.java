package se.computerscience.kelde.view.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Hossein Hussain
 */
public interface IItemView {
    public void draw (SpriteBatch batch);
    public boolean isVisble();
    public void setVisble(boolean visble);
}

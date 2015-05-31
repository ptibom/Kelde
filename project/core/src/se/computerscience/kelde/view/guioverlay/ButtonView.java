/**
 * @author: Philip Tibom
 */

package se.computerscience.kelde.view.guioverlay;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;


public class ButtonView {
    private final CharSequence text;
    private final Sprite sprite;
    private final BitmapFont font;
    private final static int OFFSET_X = 60;
    private final static int OFFSET_Y = 35;
    private final Viewport viewport;
    private final Vector2 position;
    private final Vector2 size;

    public ButtonView(String text, Texture texture, int x, int y, Viewport viewport) {
        this.viewport = viewport;
        this.text = text;
        sprite = new Sprite(texture);
        sprite.setPosition(x, y);
        font = new BitmapFont();
        font.setColor(Color.YELLOW);
        position = new Vector2(x, y);
        size = new Vector2(sprite.getWidth(), sprite.getHeight());
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
        font.draw(batch, text, sprite.getX() + OFFSET_X, sprite.getY() + OFFSET_Y);
    }

    public boolean isClicked(int x, int y) {
        // Check if x and y is within area of the button. And project new coordinates for scaling
        final Vector2 maxBoundaries = viewport.project(new Vector2(position.x + size.x, position.y + size.y));
        final Vector2 minBoundaries = viewport.project(new Vector2(position.x, position.y));
        return x > minBoundaries.x && x < maxBoundaries.x
                && y > minBoundaries.y && y < maxBoundaries.y;
    }
}

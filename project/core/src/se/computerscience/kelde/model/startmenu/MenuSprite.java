package se.computerscience.kelde.model.startmenu;

/**
 * @author: Daniel Olsson
 */

// Definition of a single frame
public class MenuSprite {

    private final int spriteStartXPosition;
    private final int spriteStartYPosition;

    private final int spriteWidth;
    private final int spriteHeight;


    public MenuSprite(int spriteStartXPosition, int spriteStartYPosition, int spriteWidth, int spriteHeight) {

        this.spriteStartXPosition = spriteStartXPosition;
        this.spriteStartYPosition = spriteStartYPosition;
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;

    }


    public int getSpriteStartXPosition() {
        return spriteStartXPosition;
    }

    public int getSpriteStartYPosition() {

        return spriteStartYPosition;

    }

    public int getSpriteWidth() {
        return spriteWidth;
    }

    public int getSpriteHeight() {
        return spriteHeight;
    }

}

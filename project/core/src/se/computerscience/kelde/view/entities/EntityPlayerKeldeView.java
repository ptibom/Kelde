/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;

public class EntityPlayerKeldeView implements InputProcessor {
    private final EntityPlayerKelde entityPlayerKelde;
    private final Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 48;
    private final String SPRITE_LOCATION = "testSprite.png";

    private float ELAPSED_TIME = 0;
    private TextureAtlas keldeWalkNorth, keldeWalkWest, keldeWalkSouth, keldeWalkEast, keldeLookNorth, keldeLookEast, keldeLookSouth, keldeLookWest;
    private Animation animation, animationWalkNorth, animationWalkWest, animationWalkSouth, animationWalkEast, STANDING_STILL_NORTH, STANDING_STILL_WEST, STANDING_STILL_EAST, STANDING_STILL_SOUTH;
    private TextureAtlas keldeNorthKnife, keldeEastKnife, keldeSouthKnife, keldeWestKnife;
    private Animation knifeslashnorth, knifeslasheast,knifeslashwest,knifeslashsouth;
    private HEADING direction;
    private float oldX, oldY;
    private int SPACE_KEY = 62, RIGHT_ARROW = 22, LEFT_ARROW = 21, UP_ARROW = 19, DOWN_ARROW = 20;
    private Boolean SLASH = false;

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == SPACE_KEY) {
            SLASH = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == SPACE_KEY) {
            SLASH = false;
        }
        return false;
    }




    public enum HEADING {
        NORTH, SOUTH, WEST, EAST
    }

    public EntityPlayerKeldeView(EntityPlayerKelde entityPlayerKelde) {
        Gdx.input.setInputProcessor(this);
        this.entityPlayerKelde = entityPlayerKelde;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
        direction = HEADING.NORTH;

        createNorthTexture();
        createWestTexture();
        createSouthTexture();
        createEastTexture();
        createKeldeStanding();
        createKnifeSlash();
    }

    public void draw (SpriteBatch batch) {

        Boolean walk = false;
        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        float newX = entityPlayerKelde.getPositionX();
        float newY = entityPlayerKelde.getPositionY();
        animation = animationWalkNorth;
        if (oldY < newY) {
            animation = animationWalkNorth;
            direction = HEADING.NORTH;
            walk = true;
        }
        else if (oldY > newY) {
            animation = animationWalkSouth;
            direction = HEADING.SOUTH;
            walk = true;
        }
        if (oldX < newX) {
            animation = animationWalkEast;
            direction = HEADING.EAST;
            walk = true;
        }
        else if (oldX > newX) {
            animation = animationWalkWest;
            direction = HEADING.WEST;
            walk = true;
        }

        if(direction == HEADING.NORTH && oldX == newX && walk == false) {
            animation = STANDING_STILL_NORTH;
        }
        if (direction == HEADING.WEST && oldY == newY && walk == false) {
            animation = STANDING_STILL_WEST;
        }
        if(direction == HEADING.EAST && oldX == newX && walk == false) {
            animation = STANDING_STILL_EAST;
        }
        if(direction == HEADING.SOUTH && oldY == newY && walk == false) {
            animation = STANDING_STILL_SOUTH;
        }

        if(SLASH && direction == HEADING.NORTH) {
            animation = knifeslashnorth;
        } else if (SLASH && direction == HEADING.WEST) {
            animation = knifeslashwest;
        } else if(SLASH && direction == HEADING.EAST) {
            animation = knifeslasheast;
        } else if(SLASH && direction == HEADING.SOUTH) {
            animation = knifeslashsouth;
        }

        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        //sprite.setPosition(entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        sprite.draw(batch);
        oldX = entityPlayerKelde.getPositionX();
        oldY = entityPlayerKelde.getPositionY();
    }

    private void createKnifeSlash() {
        keldeNorthKnife = new TextureAtlas(Gdx.files.internal("kslashNorth.atlas"));
        knifeslashnorth = new Animation(0.05f, keldeNorthKnife.getRegions());
        keldeEastKnife = new TextureAtlas((Gdx.files.internal("kslashEast.atlas")));
        knifeslasheast = new Animation(0.05f, keldeEastKnife.getRegions());
        keldeSouthKnife = new TextureAtlas((Gdx.files.internal("kslashSouth.atlas")));
        knifeslashsouth = new Animation(0.05f, keldeSouthKnife.getRegions());
        keldeWestKnife = new TextureAtlas((Gdx.files.internal("kslashWest.atlas")));
        knifeslashwest = new Animation(0.05f, keldeWestKnife.getRegions());

    }

    private void createKeldeStanding() {
        keldeLookNorth = new TextureAtlas(Gdx.files.internal("keldelooknorth.atlas"));
        STANDING_STILL_NORTH = new Animation(0.1f, keldeLookNorth.getRegions());
        keldeLookEast = new TextureAtlas(Gdx.files.internal("keldelookeast.atlas"));
        STANDING_STILL_EAST = new Animation(0.1f, keldeLookEast.getRegions());
        keldeLookSouth = new TextureAtlas(Gdx.files.internal("keldelooksouth.atlas"));
        STANDING_STILL_SOUTH = new Animation(0.1f, keldeLookSouth.getRegions());
        keldeLookWest = new TextureAtlas(Gdx.files.internal("keldelookwest.atlas"));
        STANDING_STILL_WEST = new Animation(0.1f, keldeLookWest.getRegions());
    }

    private void createNorthTexture() {
        keldeWalkNorth = new TextureAtlas(Gdx.files.internal("kelde_walk.atlas"));
        animationWalkNorth = new Animation(0.07f, keldeWalkNorth.getRegions());
    }

    private void createWestTexture() {
        keldeWalkWest = new TextureAtlas(Gdx.files.internal("kelde_walk_west.atlas"));
        animationWalkWest = new Animation(0.07f, keldeWalkWest.getRegions());
    }

    private void createSouthTexture() {
        keldeWalkSouth = new TextureAtlas(Gdx.files.internal("kelde_walk_south.atlas"));
        animationWalkSouth = new Animation(0.07f, keldeWalkSouth.getRegions());
    }

    private void createEastTexture() {
        keldeWalkEast = new TextureAtlas(Gdx.files.internal("kelde_walk_east.atlas"));
        animationWalkEast = new Animation(0.07f, keldeWalkEast.getRegions());
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.gameworld.Heading;

public class EntityPlayerKeldeView {
    private final EntityPlayerKelde entityPlayerKelde;
    private final Sprite sprite;
    private final Texture texture;
    private final int WIDTH = 32, HEIGHT = 48;
    private final String SPRITE_LOCATION = "testSprite.png";

    private float ELAPSED_TIME = 0;
    private TextureAtlas keldeWalkNorth, keldeWalkWest, keldeWalkSouth, keldeWalkEast, keldeLookNorth, keldeLookEast, keldeLookSouth, keldeLookWest;
    private Animation animation, animationWalkNorth, animationWalkWest, animationWalkSouth, animationWalkEast, STANDING_STILL_NORTH, STANDING_STILL_WEST, STANDING_STILL_EAST, STANDING_STILL_SOUTH;
    private TextureAtlas keldeNorthKnife, keldeEastKnife, keldeSouthKnife, keldeWestKnife;
    private TextureAtlas keldeNorthArrow, keldeWestArrow, keldeSouthArrow, keldeEastArrow;
    private Animation knifeslashnorth, knifeslasheast,knifeslashwest,knifeslashsouth;
    private Animation keldeShootArrowNorth, keldeShootArrowWest, keldeShootArrowSouth, keldeShootArrowEast;
    private Heading direction;
    private float oldX, oldY;


    public EntityPlayerKeldeView(EntityPlayerKelde entityPlayerKelde) {
        this.entityPlayerKelde = entityPlayerKelde;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
        direction = Heading.NORTH;

        createNorthTexture();
        createWestTexture();
        createSouthTexture();
        createEastTexture();
        createKeldeStanding();
        createKnifeSlash();
        createArrowShoot();
    }

    public void draw (SpriteBatch batch) {
        Boolean SLASH = entityPlayerKelde.getSlash();
        Boolean ARROW = entityPlayerKelde.getArrow();
        Boolean walk = false;
        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        float newX = entityPlayerKelde.getPositionX();
        float newY = entityPlayerKelde.getPositionY();
        animation = animationWalkNorth;
        if (oldY < newY) {
            animation = animationWalkNorth;
            direction = Heading.NORTH;
            walk = true;
        }
        else if (oldY > newY) {
            animation = animationWalkSouth;
            direction = Heading.SOUTH;
            walk = true;
        }
        if (oldX < newX) {
            animation = animationWalkEast;
            direction = Heading.EAST;
            walk = true;
        }
        else if (oldX > newX) {
            animation = animationWalkWest;
            direction = Heading.WEST;
            walk = true;
        }

        if(direction == Heading.NORTH && walk == false) {
            animation = STANDING_STILL_NORTH;
        }
        if (direction == Heading.WEST && walk == false) {
            animation = STANDING_STILL_WEST;
        }
        if(direction == Heading.EAST && walk == false) {
            animation = STANDING_STILL_EAST;
        }
        if(direction == Heading.SOUTH && walk == false) {
            animation = STANDING_STILL_SOUTH;
        }

        if(SLASH && direction == Heading.NORTH) {
            animation = knifeslashnorth;
        } else if (SLASH && direction == Heading.WEST) {
            animation = knifeslashwest;
        } else if(SLASH && direction == Heading.EAST) {
            animation = knifeslasheast;
        } else if(SLASH && direction == Heading.SOUTH) {
            animation = knifeslashsouth;
        }

        if(ARROW && direction == Heading.NORTH) {
            animation = keldeShootArrowNorth;
        } else if(ARROW && direction == Heading.WEST) {
            animation = keldeShootArrowWest;
        } else if(ARROW && direction == Heading.SOUTH) {
            animation = keldeShootArrowSouth;
        } else if(ARROW && direction == Heading.EAST) {
            animation = keldeShootArrowEast;
        }

        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        //sprite.setPosition(entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        sprite.draw(batch);
        oldX = entityPlayerKelde.getPositionX();
        oldY = entityPlayerKelde.getPositionY();
    }

    private void createArrowShoot() {
        keldeNorthArrow = new TextureAtlas(Gdx.files.internal("kArrowNorth.atlas"));
        keldeShootArrowNorth = new Animation(0.05f,keldeNorthArrow.getRegions());
        keldeWestArrow = new TextureAtlas((Gdx.files.internal("kArrowWest.atlas")));
        keldeShootArrowWest = new Animation(0.05f,keldeWestArrow.getRegions());
        keldeSouthArrow = new TextureAtlas(Gdx.files.internal("kArrowSouth.atlas"));
        keldeShootArrowSouth = new Animation(0.05f, keldeSouthArrow.getRegions());
        keldeEastArrow = new TextureAtlas(Gdx.files.internal("kArrowEast.atlas"));
        keldeShootArrowEast = new Animation(0.05f, keldeEastArrow.getRegions());
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

}

/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.Heading;

import javax.xml.soap.Text;

public class EntityPlayerKeldeView {
    private final EntityPlayerKelde entityPlayerKelde;
    private final Texture texture;
    private final Sprite sprite;
    private final int WIDTH = 32, HEIGHT = 32;
    private final String SPRITE_LOCATION = "arrow.png";
    private float ELAPSED_TIME = 0;
    private Animation animation;
    private Animation[] walkAnimation;
    private Animation[] weaponAnimation;
    private Heading direction;
    private float oldX, oldY;



    public EntityPlayerKeldeView(EntityPlayerKelde entityPlayerKelde) {
        this.entityPlayerKelde = entityPlayerKelde;
        texture = new Texture(SPRITE_LOCATION);
        sprite = new Sprite(texture, WIDTH, HEIGHT);
        direction = Heading.NORTH;
        weaponAnimation = new Animation[8];
        walkAnimation = new Animation[8];
        createTexture();
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
        animation = walkAnimation[4];
        if (oldY < newY) {
            animation = walkAnimation[4];
            direction = Heading.NORTH;
            walk = true;
        }
        else if (oldY > newY) {
            animation = walkAnimation[6];
            direction = Heading.SOUTH;
            walk = true;
        }
        if (oldX < newX) {
            animation = walkAnimation[7];
            direction = Heading.EAST;
            walk = true;
        }
        else if (oldX > newX) {
            animation = walkAnimation[5];
            direction = Heading.WEST;
            walk = true;
        }

        if(!walk) {
            if (direction == Heading.NORTH) {
                animation = walkAnimation[0];
            }
            if (direction == Heading.WEST) {
                animation = walkAnimation[3];
            }
            if (direction == Heading.EAST) {
                animation = walkAnimation[1];
            }
            if (direction == Heading.SOUTH) {
                animation = walkAnimation[2];
            }
        }

        if(SLASH && direction == Heading.NORTH) {
            animation = weaponAnimation[4];
        } else if (SLASH && direction == Heading.WEST) {
            animation = weaponAnimation[7];
        } else if(SLASH && direction == Heading.EAST) {
            animation = weaponAnimation[5];
        } else if(SLASH && direction == Heading.SOUTH) {
            animation = weaponAnimation[6];
        }

        if(ARROW && direction == Heading.NORTH) {
            animation = weaponAnimation[0];
        } else if(ARROW && direction == Heading.WEST) {
            animation = weaponAnimation[1];
        } else if(ARROW && direction == Heading.SOUTH) {
            animation = weaponAnimation[2];
        } else if(ARROW && direction == Heading.EAST) {
            animation = weaponAnimation[3];
        }




        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        //sprite.setPosition(entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        //sprite.draw(batch);
        oldX = entityPlayerKelde.getPositionX();
        oldY = entityPlayerKelde.getPositionY();
        if(ELAPSED_TIME > 100.0f) { ELAPSED_TIME = 0; }
    }

    private void createArrowShoot() {
        TextureAtlas keldeNorthArrow = new TextureAtlas(Gdx.files.internal("kArrowNorth.atlas"));
        Animation keldeShootArrowNorth = new Animation(0.05f,keldeNorthArrow.getRegions());
        weaponAnimation[0] = keldeShootArrowNorth;
        TextureAtlas keldeWestArrow = new TextureAtlas((Gdx.files.internal("kArrowWest.atlas")));
        Animation keldeShootArrowWest = new Animation(0.05f,keldeWestArrow.getRegions());
        weaponAnimation[1] = keldeShootArrowWest;
        TextureAtlas keldeSouthArrow = new TextureAtlas(Gdx.files.internal("kArrowSouth.atlas"));
        Animation keldeShootArrowSouth = new Animation(0.05f, keldeSouthArrow.getRegions());
        weaponAnimation[2] = keldeShootArrowSouth;
        TextureAtlas keldeEastArrow = new TextureAtlas(Gdx.files.internal("kArrowEast.atlas"));
        Animation keldeShootArrowEast = new Animation(0.05f, keldeEastArrow.getRegions());
        weaponAnimation[3] = keldeShootArrowEast;
    }

    private void createKnifeSlash() {
        TextureAtlas keldeNorthKnife = new TextureAtlas(Gdx.files.internal("kslashNorth.atlas"));
        Animation knifeslashnorth = new Animation(0.05f, keldeNorthKnife.getRegions());
        weaponAnimation[4] = knifeslashnorth;
        TextureAtlas keldeEastKnife = new TextureAtlas((Gdx.files.internal("kslashEast.atlas")));
        Animation knifeslasheast = new Animation(0.05f, keldeEastKnife.getRegions());
        weaponAnimation[5] = knifeslasheast;
        TextureAtlas keldeSouthKnife = new TextureAtlas((Gdx.files.internal("kslashSouth.atlas")));
        Animation knifeslashsouth = new Animation(0.05f, keldeSouthKnife.getRegions());
        weaponAnimation[6] = knifeslashsouth;
        TextureAtlas keldeWestKnife = new TextureAtlas((Gdx.files.internal("kslashWest.atlas")));
        Animation knifeslashwest = new Animation(0.05f, keldeWestKnife.getRegions());
        weaponAnimation[7] = knifeslashwest;
    }

    private void createKeldeStanding() {
        TextureAtlas keldeLookNorth = new TextureAtlas(Gdx.files.internal("keldelooknorth.atlas"));
        Animation STANDING_STILL_NORTH = new Animation(0.1f, keldeLookNorth.getRegions());
        walkAnimation[0] = STANDING_STILL_NORTH;
        TextureAtlas keldeLookEast = new TextureAtlas(Gdx.files.internal("keldelookeast.atlas"));
        Animation STANDING_STILL_EAST = new Animation(0.1f, keldeLookEast.getRegions());
        walkAnimation[1] = STANDING_STILL_EAST;
        TextureAtlas keldeLookSouth = new TextureAtlas(Gdx.files.internal("keldelooksouth.atlas"));
        Animation STANDING_STILL_SOUTH = new Animation(0.1f, keldeLookSouth.getRegions());
        walkAnimation[2] = STANDING_STILL_SOUTH;
        TextureAtlas keldeLookWest = new TextureAtlas(Gdx.files.internal("keldelookwest.atlas"));
        Animation STANDING_STILL_WEST = new Animation(0.1f, keldeLookWest.getRegions());
        walkAnimation[3] = STANDING_STILL_WEST;
    }

    private void createTexture() {
        TextureAtlas keldeWalkNorth = new TextureAtlas(Gdx.files.internal("kelde_walk.atlas"));
        Animation animationWalkNorth = new Animation(0.07f, keldeWalkNorth.getRegions());
        walkAnimation[4] = animationWalkNorth;
        TextureAtlas keldeWalkWest = new TextureAtlas(Gdx.files.internal("kelde_walk_west.atlas"));
        Animation animationWalkWest = new Animation(0.07f, keldeWalkWest.getRegions());
        walkAnimation[5] = animationWalkWest;
        TextureAtlas keldeWalkSouth = new TextureAtlas(Gdx.files.internal("kelde_walk_south.atlas"));
        Animation animationWalkSouth = new Animation(0.07f, keldeWalkSouth.getRegions());
        walkAnimation[6] = animationWalkSouth;
        TextureAtlas keldeWalkEast = new TextureAtlas(Gdx.files.internal("kelde_walk_east.atlas"));
        Animation animationWalkEast = new Animation(0.07f, keldeWalkEast.getRegions());
        walkAnimation[7] = animationWalkEast;
    }
}

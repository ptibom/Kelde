/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;

public class EntityPlayerKeldeView {
    private final EntityPlayerKelde entityPlayerKelde;
    private float ELAPSED_TIME = 0;
    private Animation animation;
    private Animation[] standAnimation;
    private Animation[] daggerAnimation;
    private Animation[] bowAnimation;
    private Animation[] walkAnimation;
    private int direction;
    private float oldX, oldY;
    private final int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;



    public EntityPlayerKeldeView(EntityPlayerKelde entityPlayerKelde) {
        this.entityPlayerKelde = entityPlayerKelde;
        direction = NORTH;
        daggerAnimation = new Animation[4];
        bowAnimation = new Animation[4];
        walkAnimation = new Animation[4];
        standAnimation = new Animation[4];
        createTexture();
        createKeldeStanding();
        createDaggerAnimation();
        createBowAnimation();
    }

    public void draw (SpriteBatch batch) {
        Boolean slashing = entityPlayerKelde.getSlash();
        Boolean shooting = entityPlayerKelde.getArrow();
        Boolean walk = false;
        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        float newX = entityPlayerKelde.getPositionX();
        float newY = entityPlayerKelde.getPositionY();
        if (oldY < newY) {
            direction = NORTH;
            animation = standAnimation[direction];
            walk = true;
        }
        else if (oldY > newY) {
            direction = SOUTH;
            walk = true;
        }
        if (oldX < newX) {
            direction = EAST;
            walk = true;
        }
        else if (oldX > newX) {
            direction = WEST;
            walk = true;
        }

        if (!walk) {
            animation = standAnimation[direction];
        }
        else {
            animation = walkAnimation[direction];
        }

        if (slashing) {
            animation = daggerAnimation[direction];
        }

        if (shooting) {
            animation = bowAnimation[direction];
        }

        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        //sprite.setPosition(entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        //sprite.draw(batch);
        oldX = newX;
        oldY = newY;
        if(ELAPSED_TIME > 100.0f) { ELAPSED_TIME = 0; }
    }

    private void createBowAnimation() {
        TextureAtlas keldeNorthArrow = new TextureAtlas(Gdx.files.internal("kArrowNorth.atlas"));
        Animation keldeShootArrowNorth = new Animation(0.05f,keldeNorthArrow.getRegions());
        bowAnimation[NORTH] = keldeShootArrowNorth;
        TextureAtlas keldeWestArrow = new TextureAtlas((Gdx.files.internal("kArrowWest.atlas")));
        Animation keldeShootArrowWest = new Animation(0.05f,keldeWestArrow.getRegions());
        bowAnimation[WEST] = keldeShootArrowWest;
        TextureAtlas keldeSouthArrow = new TextureAtlas(Gdx.files.internal("kArrowSouth.atlas"));
        Animation keldeShootArrowSouth = new Animation(0.05f, keldeSouthArrow.getRegions());
        bowAnimation[SOUTH] = keldeShootArrowSouth;
        TextureAtlas keldeEastArrow = new TextureAtlas(Gdx.files.internal("kArrowEast.atlas"));
        Animation keldeShootArrowEast = new Animation(0.05f, keldeEastArrow.getRegions());
        bowAnimation[EAST] = keldeShootArrowEast;
    }

    private void createDaggerAnimation() {
        TextureAtlas keldeNorthKnife = new TextureAtlas(Gdx.files.internal("kslashNorth.atlas"));
        Animation knifeslashnorth = new Animation(0.05f, keldeNorthKnife.getRegions());
        daggerAnimation[NORTH] = knifeslashnorth;
        TextureAtlas keldeEastKnife = new TextureAtlas((Gdx.files.internal("kslashEast.atlas")));
        Animation knifeslasheast = new Animation(0.05f, keldeEastKnife.getRegions());
        daggerAnimation[EAST] = knifeslasheast;
        TextureAtlas keldeSouthKnife = new TextureAtlas((Gdx.files.internal("kslashSouth.atlas")));
        Animation knifeslashsouth = new Animation(0.05f, keldeSouthKnife.getRegions());
        daggerAnimation[SOUTH] = knifeslashsouth;
        TextureAtlas keldeWestKnife = new TextureAtlas((Gdx.files.internal("kslashWest.atlas")));
        Animation knifeslashwest = new Animation(0.05f, keldeWestKnife.getRegions());
        daggerAnimation[WEST] = knifeslashwest;
    }

    private void createKeldeStanding() {
        TextureAtlas keldeLookNorth = new TextureAtlas(Gdx.files.internal("keldelooknorth.atlas"));
        Animation STANDING_STILL_NORTH = new Animation(0.1f, keldeLookNorth.getRegions());
        standAnimation[NORTH] = STANDING_STILL_NORTH;
        TextureAtlas keldeLookEast = new TextureAtlas(Gdx.files.internal("keldelookeast.atlas"));
        Animation STANDING_STILL_EAST = new Animation(0.1f, keldeLookEast.getRegions());
        standAnimation[EAST] = STANDING_STILL_EAST;
        TextureAtlas keldeLookSouth = new TextureAtlas(Gdx.files.internal("keldelooksouth.atlas"));
        Animation STANDING_STILL_SOUTH = new Animation(0.1f, keldeLookSouth.getRegions());
        standAnimation[SOUTH] = STANDING_STILL_SOUTH;
        TextureAtlas keldeLookWest = new TextureAtlas(Gdx.files.internal("keldelookwest.atlas"));
        Animation STANDING_STILL_WEST = new Animation(0.1f, keldeLookWest.getRegions());
        standAnimation[WEST] = STANDING_STILL_WEST;
    }

    private void createTexture() {
        TextureAtlas keldeWalkNorth = new TextureAtlas(Gdx.files.internal("kelde_walk.atlas"));
        Animation animationWalkNorth = new Animation(0.07f, keldeWalkNorth.getRegions());
        walkAnimation[NORTH] = animationWalkNorth;
        TextureAtlas keldeWalkWest = new TextureAtlas(Gdx.files.internal("kelde_walk_west.atlas"));
        Animation animationWalkWest = new Animation(0.07f, keldeWalkWest.getRegions());
        walkAnimation[WEST] = animationWalkWest;
        TextureAtlas keldeWalkSouth = new TextureAtlas(Gdx.files.internal("kelde_walk_south.atlas"));
        Animation animationWalkSouth = new Animation(0.07f, keldeWalkSouth.getRegions());
        walkAnimation[SOUTH] = animationWalkSouth;
        TextureAtlas keldeWalkEast = new TextureAtlas(Gdx.files.internal("kelde_walk_east.atlas"));
        Animation animationWalkEast = new Animation(0.07f, keldeWalkEast.getRegions());
        walkAnimation[EAST] = animationWalkEast;
    }
}

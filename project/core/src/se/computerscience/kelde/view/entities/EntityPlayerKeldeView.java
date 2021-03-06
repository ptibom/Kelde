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
import se.computerscience.kelde.model.constants.Direction;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;

public class EntityPlayerKeldeView {


    private final EntityPlayerKelde entityPlayerKelde;
    private float elapsedTime;

    private Animation[] standAnimation = new Animation[4];
    private Animation[] daggerAnimation = new Animation[4];
    private Animation[] bowAnimation = new Animation[4];
    private Animation[] walkAnimation = new Animation[4];

    private int direction;

    public EntityPlayerKeldeView(EntityPlayerKelde entityPlayerKelde) {
        this.entityPlayerKelde = entityPlayerKelde;
        direction = Direction.NORTH;
        createKeldeWalkingAnimation();
        createKeldeStandingAnimation();
        createDaggerAnimation();
        createBowAnimation();
    }


    public void draw(SpriteBatch batch) {
        Animation currentAnimation;
        direction = entityPlayerKelde.getDirection();
        elapsedTime += Gdx.graphics.getDeltaTime();


        if (entityPlayerKelde.isSlashing()) {
            currentAnimation = daggerAnimation[direction];
        } else if (entityPlayerKelde.getIsShooting()) {
            currentAnimation = bowAnimation[direction];
        } else if (entityPlayerKelde.isWalking()) {
            currentAnimation = walkAnimation[direction];
        } else {
            currentAnimation = standAnimation[direction];
        }


        batch.draw(currentAnimation.getKeyFrame(elapsedTime, true), entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());

        if (elapsedTime > 100.0f) {
            elapsedTime = 0;
        }

        //batch.draw(currentAnimation.getKeyFrame(elapsedTime, true), entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        //sprite.setPosition(entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        //sprite.draw(batch);


    }

    private void createBowAnimation() {
        final TextureAtlas keldeNorthBow = new TextureAtlas("kArrowNorth.atlas");
        bowAnimation[Direction.NORTH] = new Animation(0.05f, keldeNorthBow.getRegions());

        final TextureAtlas keldeEastBow = new TextureAtlas("kArrowEast.atlas");
        bowAnimation[Direction.EAST] = new Animation(0.05f, keldeEastBow.getRegions());

        final TextureAtlas keldeSouthBow = new TextureAtlas("kArrowSouth.atlas");
        bowAnimation[Direction.SOUTH] = new Animation(0.05f, keldeSouthBow.getRegions());

        final TextureAtlas keldeWestBow = new TextureAtlas("kArrowWest.atlas");
        bowAnimation[Direction.WEST] = new Animation(0.05f, keldeWestBow.getRegions());
    }

    private void createDaggerAnimation() {
        final TextureAtlas keldeNorthDagger = new TextureAtlas("kslashNorth.atlas");
        daggerAnimation[Direction.NORTH] = new Animation(0.05f, keldeNorthDagger.getRegions());

        final TextureAtlas keldeEastDagger = new TextureAtlas("kslashEast.atlas");
        daggerAnimation[Direction.EAST] = new Animation(0.05f, keldeEastDagger.getRegions());

        final TextureAtlas keldeSouthDagger = new TextureAtlas("kslashSouth.atlas");
        daggerAnimation[Direction.SOUTH] = new Animation(0.05f, keldeSouthDagger.getRegions());

        final TextureAtlas keldeWestDagger = new TextureAtlas("kslashWest.atlas");
        daggerAnimation[Direction.WEST] = new Animation(0.05f, keldeWestDagger.getRegions());
    }

    private void createKeldeStandingAnimation() {
        final TextureAtlas keldeStandNorth = new TextureAtlas("keldelooknorth.atlas");
        standAnimation[Direction.NORTH] = new Animation(0.1f, keldeStandNorth.getRegions());

        final TextureAtlas keldeStandEast = new TextureAtlas("keldelookeast.atlas");
        standAnimation[Direction.EAST] = new Animation(0.1f, keldeStandEast.getRegions());

        final TextureAtlas keldeStandSouth = new TextureAtlas("keldelooksouth.atlas");
        standAnimation[Direction.SOUTH] = new Animation(0.1f, keldeStandSouth.getRegions());

        final TextureAtlas keldeStandWest = new TextureAtlas("keldelookwest.atlas");
        standAnimation[Direction.WEST] = new Animation(0.1f, keldeStandWest.getRegions());
    }

    private void createKeldeWalkingAnimation() {
        final TextureAtlas keldeWalkNorth = new TextureAtlas("kelde_walk.atlas");
        walkAnimation[Direction.NORTH] = new Animation(0.07f, keldeWalkNorth.getRegions());

        final TextureAtlas keldeWalkEast = new TextureAtlas("kelde_walk_east.atlas");
        walkAnimation[Direction.EAST] = new Animation(0.07f, keldeWalkEast.getRegions());

        final TextureAtlas keldeWalkSouth = new TextureAtlas("kelde_walk_south.atlas");
        walkAnimation[Direction.SOUTH] = new Animation(0.07f, keldeWalkSouth.getRegions());

        final TextureAtlas keldeWalkWest = new TextureAtlas("kelde_walk_west.atlas");
        walkAnimation[Direction.WEST] = new Animation(0.07f, keldeWalkWest.getRegions());
    }
}

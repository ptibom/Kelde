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
    private float elapsedTime = 0;

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
        direction = entityPlayerKelde.getDirection();
        Animation currentAnimation = standAnimation[direction];
        if (entityPlayerKelde.isWalking()) {
            currentAnimation = walkAnimation[direction];
        }

        if (entityPlayerKelde.getIsSlashing()) {
            currentAnimation = daggerAnimation[direction];
        }

        if (entityPlayerKelde.getIsShooting()) {
            currentAnimation = bowAnimation[direction];
        }

        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(currentAnimation.getKeyFrame(elapsedTime, true), entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());


        if (elapsedTime > 100.0f) {
            elapsedTime = 0;
        }

        batch.draw(currentAnimation.getKeyFrame(elapsedTime, true), entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        //sprite.setPosition(entityPlayerKelde.getPositionX(), entityPlayerKelde.getPositionY());
        //sprite.draw(batch);


    }

    private void createBowAnimation() {
        TextureAtlas keldeNorthBow = new TextureAtlas("kArrowNorth.atlas");
        bowAnimation[Direction.NORTH] = new Animation(0.05f, keldeNorthBow.getRegions());

        TextureAtlas keldeEastBow = new TextureAtlas("kArrowEast.atlas");
        bowAnimation[Direction.EAST] = new Animation(0.05f, keldeEastBow.getRegions());

        TextureAtlas keldeSouthBow = new TextureAtlas("kArrowSouth.atlas");
        bowAnimation[Direction.SOUTH] = new Animation(0.05f, keldeSouthBow.getRegions());

        TextureAtlas keldeWestBow = new TextureAtlas("kArrowWest.atlas");
        bowAnimation[Direction.WEST] = new Animation(0.05f, keldeWestBow.getRegions());
    }

    private void createDaggerAnimation() {
        TextureAtlas keldeNorthDagger = new TextureAtlas("kslashNorth.atlas");
        daggerAnimation[Direction.NORTH] = new Animation(0.05f, keldeNorthDagger.getRegions());

        TextureAtlas keldeEastDagger = new TextureAtlas("kslashEast.atlas");
        daggerAnimation[Direction.EAST] = new Animation(0.05f, keldeEastDagger.getRegions());

        TextureAtlas keldeSouthDagger = new TextureAtlas("kslashSouth.atlas");
        daggerAnimation[Direction.SOUTH] = new Animation(0.05f, keldeSouthDagger.getRegions());

        TextureAtlas keldeWestDagger = new TextureAtlas("kslashWest.atlas");
        daggerAnimation[Direction.WEST] = new Animation(0.05f, keldeWestDagger.getRegions());
    }

    private void createKeldeStandingAnimation() {
        TextureAtlas keldeStandNorth = new TextureAtlas("keldelooknorth.atlas");
        standAnimation[Direction.NORTH] = new Animation(0.1f, keldeStandNorth.getRegions());

        TextureAtlas keldeStandEast = new TextureAtlas("keldelookeast.atlas");
        standAnimation[Direction.EAST] = new Animation(0.1f, keldeStandEast.getRegions());

        TextureAtlas keldeStandSouth = new TextureAtlas("keldelooksouth.atlas");
        standAnimation[Direction.SOUTH] = new Animation(0.1f, keldeStandSouth.getRegions());

        TextureAtlas keldeStandWest = new TextureAtlas("keldelookwest.atlas");
        standAnimation[Direction.WEST] = new Animation(0.1f, keldeStandWest.getRegions());
    }

    private void createKeldeWalkingAnimation() {
        TextureAtlas keldeWalkNorth = new TextureAtlas("kelde_walk.atlas");
        walkAnimation[Direction.NORTH] = new Animation(0.07f, keldeWalkNorth.getRegions());

        TextureAtlas keldeWalkEast = new TextureAtlas("kelde_walk_east.atlas");
        walkAnimation[Direction.EAST] = new Animation(0.07f, keldeWalkEast.getRegions());

        TextureAtlas keldeWalkSouth = new TextureAtlas("kelde_walk_south.atlas");
        walkAnimation[Direction.SOUTH] = new Animation(0.07f, keldeWalkSouth.getRegions());

        TextureAtlas keldeWalkWest = new TextureAtlas("kelde_walk_west.atlas");
        walkAnimation[Direction.WEST] = new Animation(0.07f, keldeWalkWest.getRegions());
    }
}

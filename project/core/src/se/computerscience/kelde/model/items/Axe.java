package se.computerscience.kelde.model.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;

/**
 * Description: An axe-item, makes damage.
 *
 * @author: Hossein Hussain
 */
public class Axe extends Item {
    private final boolean isConsumable = false;
    private final boolean isWeapon = true;
    private final int damage = 10;
    public Axe() {
    }
    @Override
    protected void setRegion() {
        region.setRegion(textureAtlas.findRegion("0003"));
    }
    public int getDamage() {
        return damage;
    }
    @Override
    public boolean isConsumable() {
        return isConsumable;
    }
    @Override
    public boolean isWeapon() {
        return isWeapon;
    }
}
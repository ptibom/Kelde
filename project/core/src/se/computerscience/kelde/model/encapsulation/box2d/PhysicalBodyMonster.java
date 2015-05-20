package se.computerscience.kelde.model.encapsulation.box2d;

/**
 * Created by Anders on 2015-05-20.
 */
public class PhysicalBodyMonster extends PhysicalBody {

    public PhysicalBodyMonster(float x, float y, float width, float height, IB2DWorld ib2DWorld, Object userdata) {
        super(x, y, width, height, ib2DWorld, userdata);
    }

    @Override
    protected void setFilter() {
        fdef.filter.groupIndex = -2;
        fdef.filter.categoryBits = 0x0002;
        short MASK_MONSTER = 0x0002 | 0x0001;
        fdef.filter.maskBits = MASK_MONSTER;
    }
}

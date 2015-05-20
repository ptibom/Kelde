/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class PhysicalBodyStatic extends PhysicalBody {

    public PhysicalBodyStatic(float x, float y, float width, float height, IB2DWorld ib2DWorld, Object userdata) {
        super(x, y, width, height, ib2DWorld, userdata);
    }

    @Override
    protected void setBodyType() {
        def.type = BodyType.StaticBody;
    }

    @Override
    protected void setFilter() {
        fdef.filter.groupIndex = -2;
        fdef.filter.categoryBits = 0x0002;
        short MASK = 0x0001 | 0x0002;
        fdef.filter.maskBits = MASK;
    }
}

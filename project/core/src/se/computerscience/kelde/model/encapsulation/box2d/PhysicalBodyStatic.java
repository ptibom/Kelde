/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class PhysicalBodyStatic extends PhysicalBody {

    public PhysicalBodyStatic(float x, float y, float width, float height, IB2DWorld ib2DWorld) {
        super(x, y, width, height, ib2DWorld);
    }

    @Override
    protected void setBodyType() {
        def.type = BodyType.StaticBody;
    }
}

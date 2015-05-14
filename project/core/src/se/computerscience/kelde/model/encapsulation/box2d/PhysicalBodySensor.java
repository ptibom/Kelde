/**
 * Description: 
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.physics.box2d.BodyDef;

public class PhysicalBodySensor extends PhysicalBody {
    public PhysicalBodySensor(float x, float y, float width, float height, IB2DWorld ib2DWorld, Object userdata) {
        super(x, y, width, height, ib2DWorld, userdata); // userdata borde heta ID eller nåt sånt.
        getBody().setUserData(userdata);
    }
    @Override
    protected void setBodyType() {
        def.type = BodyDef.BodyType.StaticBody;
    }
    @Override
    protected void setIsSensor() {
        fdef.isSensor = true;
    }

}
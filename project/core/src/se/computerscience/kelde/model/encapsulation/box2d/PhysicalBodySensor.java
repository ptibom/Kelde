/**
 * Description: 
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.physics.box2d.BodyDef;

public class PhysicalBodySensor extends PhysicalBody {
    public PhysicalBodySensor(float x, float y, float width, float height, IB2DWorld ib2DWorld, String userdata) {
        super(x, y, width, height, ib2DWorld, userdata);
    }
    
    @Override
    protected void setBodyType() {
        def.type = BodyDef.BodyType.StaticBody;
    }
}
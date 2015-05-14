/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.model.worldobjects.LavaRing;
import se.computerscience.kelde.view.worldobjects.LavaRingView;
public class LavaRingController implements IWorldObjectsController{
    LavaRing lavaRing;
    LavaRingView lavaRingView;
    public LavaRingController(LavaRing lavaRing, LavaRingView lavaRingView) {
        this.lavaRing = lavaRing;
        this.lavaRingView = lavaRingView;
    }
    @Override
    public void update(float delta) {

    }
}
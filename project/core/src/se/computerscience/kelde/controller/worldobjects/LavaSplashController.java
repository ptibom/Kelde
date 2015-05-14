/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.model.worldobjects.LavaSplash;
import se.computerscience.kelde.view.worldobjects.LavaRingView;

public class LavaSplashController implements IWorldObjectsController {
    private LavaSplash lavaSplash;
    private LavaRingView lavaRingView;

    public LavaSplashController(LavaSplash lavaSplash, LavaRingView lavaRingView) {
        this.lavaSplash = lavaSplash;
        this.lavaRingView = lavaRingView;
    }

    @Override
    public void update(float delta) {

    }
}
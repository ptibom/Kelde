/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.model.worldobjects.LavaRing;
import se.computerscience.kelde.view.worldobjects.LavaRingView;
public class LavaRingController implements IWorldObjectsController{
    private LavaRing lavaRing;
    private LavaRingView lavaRingView;
    private final LavaSplashController[] lavaSplashController;
    public LavaRingController(LavaRing lavaRing, LavaRingView lavaRingView) {
        this.lavaRing = lavaRing;
        this.lavaRingView = lavaRingView;
        lavaSplashController = new LavaSplashController[lavaRing.getLavaSplash().length];
        for (int i = 0; i < lavaRing.getLavaSplash().length; i++) {
            lavaSplashController[i] = new LavaSplashController(lavaRing.getLavaSplash()[i],lavaRingView.getLavaSplashView()[i]);
        }
    }
    @Override
    public void update(float delta) {
        for (int i = 0; i < lavaRing.getLavaSplash().length; i++) {
            lavaSplashController[i].update(delta);
        }
    }
}
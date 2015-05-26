/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.model.worldobjects.LavaRing;
import se.computerscience.kelde.view.worldobjects.LavaRingView;
import se.computerscience.kelde.view.worldobjects.LavaSplashView;

import java.util.ArrayList;
import java.util.List;

public class LavaRingController implements IWorldObjectsController{

    private final List<LavaSplashController> lavaSplashControllers = new ArrayList<>();
    public LavaRingController(LavaRing lavaRing,LavaRingView lavaRingView) {
        for (final LavaSplashView lavaSplashView: lavaRingView.getLavaSplashViews()) {
            lavaSplashControllers.add(setControllers(lavaSplashView));
        }
    }
    @Override
    public void update(float delta) {
        for (final LavaSplashController lavaSplashController: lavaSplashControllers){
            lavaSplashController.update(delta);
        }
    }
    public LavaSplashController setControllers(LavaSplashView lavaSplashView){
        return new LavaSplashController(lavaSplashView.getLavaSplash());
    }
}
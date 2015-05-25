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
    private final LavaRing lavaRing;
    private final LavaRingView lavaRingView;
    //private final LavaSplashController[] lavaSplashController;
    private final List<LavaSplashController> lavaSplashControllers = new ArrayList<>();
    public LavaRingController(LavaRing lavaRing, LavaRingView lavaRingView) {
        this.lavaRing = lavaRing;
        this.lavaRingView = lavaRingView;
        /*lavaSplashController = new LavaSplashController[lavaRing.getLavaSplash().length];
        for (int i = 0; i < lavaRing.getLavaSplash().length; i++) {
            lavaSplashController[i] = new LavaSplashController(lavaRing.getLavaSplash()[i],lavaRingView.getLavaSplashView()[i]);
        }*/
        for (final LavaSplashView lavaSplashView: lavaRingView.getLavaSplashViews()){
            lavaSplashControllers.add(new LavaSplashController(lavaSplashView.getLavaSplash(),lavaSplashView));
        }
    }
    @Override
    public void update(float delta) {
        /*for (int i = 0; i < lavaRing.getLavaSplash().length; i++) {
            lavaSplashController[i].update(delta);
        }*/
        for (final LavaSplashController lavaSplashController: lavaSplashControllers){
            lavaSplashController.update(delta);
        }
    }
}
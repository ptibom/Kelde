package se.computerscience.kelde.view.startmenu;

/**
 * Created by Daniel on 5/20/2015.
 */
public class AnimationTools {

    public static boolean timeRange(double time, double x, double y){
        return ((time/1000) >= x) && ((time/1000) < y) ;

    }

}

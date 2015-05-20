package se.computerscience.kelde.view.startmenu;

/**
 * @author: Daniel Olsson
 */
public class AnimationTools {

    public static boolean timeRange(double time, double x, double y){
        return ((time/1000) >= x) && ((time/1000) < y) ;

    }

}

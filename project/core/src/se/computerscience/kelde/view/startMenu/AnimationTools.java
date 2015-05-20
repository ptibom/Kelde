package se.computerscience.kelde.view.startmenu;

/**
 * @author: Daniel Olsson
 */

// Usueful tool to time the animations
public class AnimationTools {

    public static boolean timeRange(double time, double x, double y) {
        return ((time / 1000) >= x) && ((time / 1000) < y);

    }

}

/**
 * Description: Service class to change screen
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller;

import se.computerscience.kelde.events.ScreenEvent;
import se.computerscience.kelde.events.ScreenEventBus;

public class ChangeScreen {
    private static boolean doChange = false;
    private static ScreenEvent.ScreenTag nextScreen;

    public static void setNextScreen(ScreenEvent.ScreenTag nextScreen) {
        ChangeScreen.nextScreen = nextScreen;
        doChange = true;
    }

    public static void performingChange() {
        if (doChange) {
            ScreenEventBus.INSTANCE.publish(new ScreenEvent(ScreenEvent.Tag.SET_SCREEN, nextScreen));
            doChange = false;
        }
    }
}

/**
 * Description: Service class to change screen
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller.services;

import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.controller.events.ScreenEventBus;

public final class ScreenChanger {
    private static boolean doChange;
    private static ScreenEvent.ScreenTag nextScreen;

    private ScreenChanger() {

    }

    public static void setNextScreen(ScreenEvent.ScreenTag nextScreen) {
        ScreenChanger.nextScreen = nextScreen;
        doChange = true;
    }

    public static void performingChange() {
        if (doChange) {
            ScreenEventBus.INSTANCE.publish(new ScreenEvent(ScreenEvent.Tag.SET_SCREEN, nextScreen));
            doChange = false;
        }
    }
}

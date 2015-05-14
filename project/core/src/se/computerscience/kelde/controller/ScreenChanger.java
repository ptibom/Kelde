package se.computerscience.kelde.controller;

public class ScreenChanger {
    private static ScreenChanger ourInstance = new ScreenChanger();

    public static ScreenChanger getInstance() {
        return ourInstance;
    }
    private String currentScreen = "Game";
    private ScreenChanger() {
    }

    public String getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(String currentScreen) {
        this.currentScreen = currentScreen;
    }
}

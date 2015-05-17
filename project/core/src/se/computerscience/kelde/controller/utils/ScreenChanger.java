package se.computerscience.kelde.controller.utils;

public enum ScreenChanger {
    INSTANCE;
    private String screen = "Game";

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }
}
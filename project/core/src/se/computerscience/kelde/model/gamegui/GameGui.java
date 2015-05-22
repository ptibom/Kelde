package se.computerscience.kelde.model.gamegui;

/**
 * Created by MonoMan on 5/22/2015.
 */
public class GameGui {


    private final String HEALTH_BAR = "gui/health_bar.png";
    private final String BACKGROUND_BAR = "gui/bar_background.png";
    private final String MANA_BAR = "gui/mana_bar.png";
    private final String MANA_FOREGROUND_BAR = "gui/mana_bar_foreground.png";
    private final String HEALTH_FOREGROUND_BAR = "gui/health_bar_foreground.png";
    private final String MENU_RECTANGLE = "gui/menu_rectangle.png";
    private final String TEXT_NAME = "gui/textbox_name.png";
    private final String GUI_BUTTON = "gui/gui_button.png";
    private final String[] barTexturePackage;


    public GameGui(){

        barTexturePackage = new String[]{MANA_BAR,HEALTH_BAR,BACKGROUND_BAR,MANA_FOREGROUND_BAR,HEALTH_FOREGROUND_BAR};

    }

    public String[] getBarAssets(){

        return barTexturePackage;
    }

    public String getMenuRectangleImagePath(){
        return MENU_RECTANGLE;
    }

    public String getTextBoxImagePath(){
        return TEXT_NAME;
    }

    public String getGuiButtonImagePath(){
        return GUI_BUTTON;
    }


}

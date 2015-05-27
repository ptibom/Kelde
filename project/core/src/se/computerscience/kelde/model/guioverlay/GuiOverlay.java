package se.computerscience.kelde.model.guioverlay;

/**
 * @author: Daniel Olsson
 */
public class GuiOverlay {


    private static final String HEALTH_BAR = "gui/health_bar.png";
    private static final String BACKGROUND_BAR = "gui/bar_background.png";
    private static  final String MANA_BAR = "gui/mana_bar.png";
    private static final String MANA_FOREGROUND_BAR = "gui/mana_bar_foreground.png";
    private static final String HEALTH_FOREGROUND_BAR = "gui/health_bar_foreground.png";
    private static final String MENU_RECTANGLE = "gui/menu_rectangle.png";
    private static final String TEXT_NAME = "gui/textbox_name.png";
    private static final String GUI_BUTTON = "gui/gui_button.png";
    private final String[] barTexturePackage;

    private int currentPlayerHealth;
    private int currentPlayerMana;


    public GuiOverlay(){

        barTexturePackage = new String[]{MANA_BAR,HEALTH_BAR,BACKGROUND_BAR,MANA_FOREGROUND_BAR,HEALTH_FOREGROUND_BAR};

    }

    public String[] getBarAssets(){

        return barTexturePackage;
    }

    public void update(int health, int mana){

        this.currentPlayerHealth = health;
        this.currentPlayerMana = mana;
    }


    public int getCurrentMana(){
        return currentPlayerMana;
    }
    public int getCurrentHealth(){

        return currentPlayerHealth;
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

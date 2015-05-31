package se.computerscience.kelde.model.intro;

/**
 * @author: Daniel Olsson
 */

public final class ConstantsPath {

    //Background and foreground images used in the intro
    public static final String INTRO_BORDER_PATH_IMAGE = "intro/borderintro.png";
    public static final String INTRO_BACKGROUND_PATH_IMAGE = "intro/backgroundintro.png";
    public static final String FOREGROUND_INTRO_PATH_IMAGE = "intro/foregroundintro.png";
    public static final String INTRO_CAVE_BACKGROUND = "intro/cavebackground.png";

    // The spritesheets
    public static final String INTRO_SPELL_PATH_IMAGE = "intro/spell.png";
    public static final String INTRO_DEMON_ANIMATION_PATH_IMAGE = "intro/introsprites.png";
    public static final String INTRO_WIZARD_ANIMATION_PATH_IMAGE = "intro/introtalk.png";

    private static final String INTRO_SOUND_PATH = "intro/dfear.mp3";

    private ConstantsPath(){

    }

    public static String getIntroBorderPathImage() {
        return INTRO_BORDER_PATH_IMAGE;
    }

    public static String getIntroBackgroundPathImage() {
        return INTRO_BACKGROUND_PATH_IMAGE;
    }

    public static String getForegroundIntroPathImage() {
        return FOREGROUND_INTRO_PATH_IMAGE;
    }

    public static String getIntroCaveBackground() {
        return INTRO_CAVE_BACKGROUND;
    }

    public static String getIntroSpellPathImage() {
        return INTRO_SPELL_PATH_IMAGE;
    }

    public static String getIntroDemonAnimationPathImage() {
        return INTRO_DEMON_ANIMATION_PATH_IMAGE;
    }

    public static String getIntroWizardAnimationPathImage() {
        return INTRO_WIZARD_ANIMATION_PATH_IMAGE;
    }

    public static String getIntroMusic(){
        return INTRO_SOUND_PATH;
    }
}

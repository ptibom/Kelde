package se.computerscience.kelde.model.intro;


public class ConstantsAnimation {
    // The spritesheets
    public static final String INTRO_SPELL_PATH_IMAGE = "intro/spell.png";
    public static final String INTRO_DEMON_ANIMATION_PATH_IMAGE = "intro/introsprites.png";
    public static final String INTRO_WIZARD_ANIMATION_PATH_IMAGE = "intro/introtalk.png";

    //The length of all animations, used to read in right amount of frame into the animation
    public static final int[] INTRO_WIZARD_ANIMATION_LENGTH_DATA = new int[]{3, 3, 2};
    public static final int[] INTRO_SPELL_ANIMATION_LENGTH_DATA = new int[]{3, 5, 4};
    public static final int[] INTRO_DEMON_ANIMATION_LENGTH_DATA = new int[]{4, 3, 2, 1, 3, 2, 4, 3, 3, 3, 1, 1, 1, 3, 3, 4};


    // animationPath for spell animation.
    public static int[] animPathCordsX = new int[]{740, 792, 816, 871, 921, 985, 1075, 1161, 1239, 1276, 1201, 1114, 1036, 966, 960, 1100, 1300, 1400, 1400, 1400};
    public static int[] animPathCordsY = new int[]{400, 666, 699, 747, 783, 814, 831, 810, 852, 801, 745, 700, 658, 582, 490, 418, 440, 500, 500, 500};

    //Background and foreground images used in the intro
    public static final String INTRO_BORDER_PATH_IMAGE = "intro/borderintro.png";
    public static final String INTRO_BACKGROUND_PATH_IMAGE = "intro/backgroundintro.png";
    public static final String FOREGROUND_INTRO_PATH_IMAGE = "intro/foregroundintro.png";
    public static final String INTRO_CAVE_BACKGROUND = "intro/cavebackground.png";

}

package se.computerscience.kelde.model.intro;

import java.util.Arrays;

/**
 * @author: Daniel Olsson
 */

public final  class ConstantsAnimation {


    //The length of all animations, used to read in right amount of frame into the animation
    private static final int[] INTRO_WIZARD_ANIMATION_LENGTH_DATA = new int[]{3, 3, 2};
    private static final int[] INTRO_SPELL_ANIMATION_LENGTH_DATA = new int[]{3, 5, 4};
    private static final int[] INTRO_DEMON_ANIMATION_LENGTH_DATA = new int[]{4, 3, 2, 1, 3, 2, 4, 3, 3, 3, 1, 1, 1, 3, 3, 4};


    // animationPath for spell animation.
    private static final int[] ANIM_PATH_CORDS_X = new int[]{740, 792, 816, 871, 921, 985, 1075, 1161, 1239, 1276, 1201,
            1114, 1036, 966, 960, 1100, 1300, 1400, 1400, 1400};
    private static final int[] ANIM_PATH_CORDS_Y = new int[]{400, 666, 699, 747, 783, 814, 831, 810, 852, 801,
            745, 700, 658, 582, 490, 418, 440, 500, 500, 500};


    private ConstantsAnimation() {

    }

    public static int[] getWizardLength() {

        return Arrays.copyOf(INTRO_WIZARD_ANIMATION_LENGTH_DATA, INTRO_WIZARD_ANIMATION_LENGTH_DATA.length);
    }

    public static int[] getSpellLength() {

        return Arrays.copyOf(INTRO_SPELL_ANIMATION_LENGTH_DATA, INTRO_SPELL_ANIMATION_LENGTH_DATA.length);
    }

    public static int[] getDemonLength() {

        return Arrays.copyOf(INTRO_DEMON_ANIMATION_LENGTH_DATA, INTRO_DEMON_ANIMATION_LENGTH_DATA.length);
    }

    public static int[] getAnimXCords() {

        return Arrays.copyOf(ANIM_PATH_CORDS_X, ANIM_PATH_CORDS_X.length);
    }

    public static int[] getAnimYCords() {

        return Arrays.copyOf(ANIM_PATH_CORDS_Y, ANIM_PATH_CORDS_Y.length);
    }


}

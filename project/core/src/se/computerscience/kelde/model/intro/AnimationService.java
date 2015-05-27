package se.computerscience.kelde.model.intro;

import java.util.*;

/**
 * @author: Daniel Olsson
 */

public class AnimationService {

    // The finished collection of animations
    private final Map<String, IntroAnimation> mappedWizardTalkAnimation;
    private final Map<String, IntroAnimation> mappedDemonTalkAnimation;
    private final Map<String, IntroAnimation> mappedWizard2TalkAnimation;
    private final Map<String, IntroAnimation> mappedSpellAnimation;
    private final static int LENGTH_OF_FIRST_PART = 8;

    // Path for spell animations
    private final int[] animPathInterpolatedX;
    private final int[] animPathInterpolatedY;

    public AnimationService(Intro introModel) {

        mappedWizardTalkAnimation = new HashMap<>();
        mappedWizard2TalkAnimation = new HashMap<>();
        mappedDemonTalkAnimation = new HashMap<>();
        mappedSpellAnimation = new HashMap<>();

        final int[] animPathCordsX = ConstantsAnimation.getAnimXCords();
        final int[] animPathCordsY = ConstantsAnimation.getAnimYCords();
        animPathInterpolatedX = new int[animPathCordsX.length * 4];
        animPathInterpolatedY = new int[animPathCordsY.length * 4];

        // Taking from an array of coordinates and interpolates it into a larger array with better
        // animation precision. This is for the spell animation
        int j = 0;
        for (int i = 0; j < animPathCordsX.length - 1; i += 4, j++) {

            final double deltaX = animPathCordsX[j + 1] - animPathCordsX[j];
            final double deltaY = animPathCordsY[j + 1] - animPathCordsY[j];
            animPathInterpolatedX[i] = animPathCordsX[j];
            animPathInterpolatedX[i + 1] = (int) (animPathCordsX[j] + deltaX * 0.25);
            animPathInterpolatedX[i + 2] = (int) (animPathCordsX[j] + deltaX * 0.50);
            animPathInterpolatedX[i + 3] = (int) (animPathCordsX[j] + deltaX * 0.75);
            animPathInterpolatedY[i] = animPathCordsY[j];
            animPathInterpolatedY[i + 1] = (int) (animPathCordsY[j] + deltaY * 0.25);
            animPathInterpolatedY[i + 2] = (int) (animPathCordsY[j] + deltaY * 0.50);
            animPathInterpolatedY[i + 3] = (int) (animPathCordsY[j] + deltaY * 0.75);
        }

        //////////////////////////////////////////////////////////////
        //Loading animations for wizard from textfile to animation////
        //////////////////////////////////////////////////////////////
        final String[] keyForAnimations = new String[]{"backwalk", "walkforward", "wandlight"};
        final int[] wizardAnimationLengthData = ConstantsAnimation.getWizardLength();
        final int[] wizardSpriteCoordinates = introModel.getWizardTalkCoordinates();


        final Object[] animationDataCollectionWiz = new Object[]{wizardAnimationLengthData, wizardSpriteCoordinates,
                keyForAnimations};
        final Object[] animationMapsWiz = new Object[]{mappedWizardTalkAnimation};

        readAndLoadAnimation(animationDataCollectionWiz, animationMapsWiz);

        ////////////////////////////////////////////
        //Loading animatinos for demon and wizard2//
        ////////////////////////////////////////////
        final int[] demonAndSecondWizardAnimationLengthData = ConstantsAnimation.getDemonLength();
        final int[] demonSpriteCoordinates = introModel.getIntroDemonCoordinates();


        final String[] keyForAnimations2 = new String[]{"demonspellhit", "demonlaughleft", "demontalkleft", "demonsideleft",
                "demonlaughright", "demontalkright", "demonbreathe", "demonwalk", "demonpoint", "wizardshoot",
                "wizardbehind", "wizardstandright", "wizardstandleft", "wizardtalkleft", "wizardtalkright", "wizardwalk"};

        final Object[] animationDataCollectionDem = new Object[]{demonAndSecondWizardAnimationLengthData, demonSpriteCoordinates,
                keyForAnimations2};
        final  Object[] animationMapsDem = new Object[]{mappedDemonTalkAnimation, mappedWizard2TalkAnimation};

        readAndLoadAnimation(animationDataCollectionDem, animationMapsDem);

        /////////////////////////////////
        // Loading animations for spell//
        /////////////////////////////////
        final int[] spellAnimationLengthData = ConstantsAnimation.getSpellLength();
        final   int[] spellSpriteCoordinates = introModel.getSpellIntroCoordinaters();


        final  String[] keyForAnimations3 = new String[]{"start", "explosion", "loop"};
        final Object[] animationDataCollectionSpell = new Object[]{spellAnimationLengthData, spellSpriteCoordinates,
                keyForAnimations3};
        final Object[] animationMapsSpell = new Object[]{mappedSpellAnimation};

        readAndLoadAnimation(animationDataCollectionSpell, animationMapsSpell);


    }

    // Gets information about length of animation, the coordinates of the pictures so it can load Texture regions
    // into an animation, then collect these animations into a map for ease of finding them.
    private  List<IntroAnimation> readAndLoadAnimation(Object[] animationDataCollection,
                                      Object[] animationMapArray) {

        //Converting Object to it's specific type. We need to know the length of each animation



        // The width and height of the sprite is stored in the beginning
        final List<IntroAnimation> tempAnimationList = AnimationBuilder.createListofAnimations(
                (int[])animationDataCollection[0],   (int[])animationDataCollection[1] );

        //Creates an temporary collection of sprites which is one animation


        //If we have spritesheet with two different animations, this is a special case.
        if (animationMapArray.length > 1) {


            for (int i = 0; i < ((int[]) animationDataCollection[0]).length; i++) {
                if (i > LENGTH_OF_FIRST_PART) {

                    ((Map<String, IntroAnimation>) animationMapArray[1]).put(((String[]) animationDataCollection[2])[i], tempAnimationList.get(i));

                } else {
                    ((Map<String, IntroAnimation>)animationMapArray[0]).put(((String[]) animationDataCollection[2])[i], tempAnimationList.get(i));
                }
            }
        }

        //Else we just load the animation in as usual
        else {

            for (int i = 0; i < tempAnimationList.size(); i++) {

                ((Map<String, IntroAnimation>) animationMapArray[0]).put(((String[]) animationDataCollection[2])[i], tempAnimationList.get(i));

            }
        }

        return tempAnimationList;
    }


    //Getters for the generated animations
    public Map<String, IntroAnimation> getWizardAnimations() {

        return mappedWizardTalkAnimation;
    }

    public Map<String, IntroAnimation> getWizard2Animations() {

        return mappedWizard2TalkAnimation;

    }

    public Map<String, IntroAnimation> getDemonAnimations() {

        return mappedDemonTalkAnimation;
    }

    public Map<String, IntroAnimation> getSpellAnimations() {

        return mappedSpellAnimation;
    }

    public int[] getInterpolDataX() {

        return Arrays.copyOf(animPathInterpolatedX, animPathInterpolatedX.length);


    }

    public int[] getInterpolDataY() {
        return Arrays.copyOf(animPathInterpolatedY, animPathInterpolatedY.length);
    }





}

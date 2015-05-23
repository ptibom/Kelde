package se.computerscience.kelde.model.intro;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Daniel Olsson
 */

public class AnimationService {

    Intro introModel;

    // The finished collection of animations
    Map<String, Animation> mappedWizardTalkAnimation;
    Map<String, Animation> mappedDemonTalkAnimation;
    Map<String, Animation> mappedWizard2TalkAnimation;
    Map<String, Animation> mappedSpellAnimation;


    // Animations for spell path

    int[] animPathInterpolatedX;
    int[] animPathInterpolatedY;


    public AnimationService(Intro introModel) {

        mappedWizardTalkAnimation = new HashMap<>();
        mappedWizard2TalkAnimation = new HashMap<>();
        mappedDemonTalkAnimation = new HashMap<>();
        mappedSpellAnimation = new HashMap<>();


        this.introModel = introModel;

        int[] animPathCordsX = introModel.getXAnimPathArray();
        int[] animPathCordsY = introModel.getYAnimPathArray();
        animPathInterpolatedX = new int[animPathCordsX.length * 4];
        animPathInterpolatedY = new int[animPathCordsY.length * 4];

        // Taking from a set of data and interpolates it into a larger array with better
        // animation precision. This is for the spell animation
        for (int i = 0, j = 0; j < animPathCordsX.length - 1; i += 4, j++) {

            double deltaX = animPathCordsX[j + 1] - animPathCordsX[j];
            double deltaY = animPathCordsY[j + 1] - animPathCordsY[j];
            animPathInterpolatedX[i] = animPathCordsX[j];
            animPathInterpolatedX[i + 1] = (int) (animPathCordsX[j] + deltaX * 0.25);
            animPathInterpolatedX[i + 2] = (int) (animPathCordsX[j] + deltaX * 0.50);
            animPathInterpolatedX[i + 3] = (int) (animPathCordsX[j] + deltaX * 0.75);
            animPathInterpolatedY[i] = animPathCordsY[j];
            animPathInterpolatedY[i + 1] = (int) (animPathCordsY[j] + deltaY * 0.25);
            animPathInterpolatedY[i + 2] = (int) (animPathCordsY[j] + deltaY * 0.50);
            animPathInterpolatedY[i + 3] = (int) (animPathCordsY[j] + deltaY * 0.75);
        }

        ///////////////////////////////////
        //Loading animations for wizard////
        ///////////////////////////////////
        String[] keyForAnimations = new String[]{"backwalk", "walkforward", "wandlight"};
        int[] wizardAnimationLengthData = introModel.getWizardAnimationData();
        int[] wizardSpriteCoordinates = introModel.getWizardTalkCoordinates();
        Texture wizardSpriteSheet = new Texture(introModel.getIntroWizardTalkImage());

        Object[] animationDataCollectionWiz = new Object[]{wizardAnimationLengthData, wizardSpriteCoordinates,
                wizardSpriteSheet, keyForAnimations};
        Object[] animationMapsWiz = new Object[]{mappedWizardTalkAnimation};

        readAndLoadAnimation(animationDataCollectionWiz, animationMapsWiz);

        ////////////////////////////////////////////
        //Loading animatinos for demon and wizard2//
        ////////////////////////////////////////////
        int[] demonAndSecondWizardAnimationLengthData = introModel.getDemonAnimationData();
        int[] demonSpriteCoordinates = introModel.getIntroDemonCoordinates();
        Texture demonSpriteSheet = new Texture(introModel.getDemonAnd2ndWizardImage());
        String[] keyForAnimations2 = new String[]{"demonspellhit", "demonlaughleft", "demontalkleft", "demonsideleft",
                "demonlaughright", "demontalkright", "demonbreathe", "demonwalk", "demonpoint", "wizardshoot",
                "wizardbehind", "wizardstandright", "wizardstandleft", "wizardtalkleft", "wizardtalkright", "wizardwalk"};

        Object[] animationDataCollectionDem = new Object[]{demonAndSecondWizardAnimationLengthData, demonSpriteCoordinates,
                demonSpriteSheet, keyForAnimations2};
        Object[] animationMapsDem = new Object[]{mappedDemonTalkAnimation, mappedWizard2TalkAnimation};

        readAndLoadAnimation(animationDataCollectionDem, animationMapsDem);

        /////////////////////////////////
        // Loading animations for spell//
        /////////////////////////////////
        int[] spellAnimationLengthData = introModel.getSpellAnimationLength();
        int[] spellSpriteCoordinaters = introModel.getSpellIntroCoordinaters();
        Texture spellSprite = new Texture(introModel.getSpellSpritePath());
        String[] keyForAnimations3 = new String[]{"start", "explosion", "loop"};
        Object[] animationDataCollectionSpell = new Object[]{spellAnimationLengthData, spellSpriteCoordinaters,
                spellSprite, keyForAnimations3};
        Object[] animationMapsSpell = new Object[]{mappedSpellAnimation};

        readAndLoadAnimation(animationDataCollectionSpell, animationMapsSpell);


    }

    // Gets information about length of animation, the coordinates of the pictures so it can load Texture regions
    // into an animation, then collect these animations into a map for ease of finding them.
    public void readAndLoadAnimation(Object[] animationDataCollection,
                                     Object[] outAnimationMapArray) {


        //Converting Object to it's specific type.
        int[] animationLengthData = (int[]) animationDataCollection[0];
        int[] spriteCoordinatesData = (int[]) animationDataCollection[1];
        Texture spriteSheet = (Texture) animationDataCollection[2];
        String[] keyForAnimations = (String[]) animationDataCollection[3];


        // Sets special enlargement/downsize filter
        spriteSheet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        List<Animation> tempAnimationList = new ArrayList<>();
        int width = spriteCoordinatesData[0];
        int height = spriteCoordinatesData[1];

        //Creates an temporary collection of Texture Regions and creates one animation
        for (int i = 0, k = 0; i < animationLengthData.length; i++) {
            TextureRegion[] tempTexRegArray = new TextureRegion[animationLengthData[i]];
            for (int j = 0; j < animationLengthData[i]; j++, k += 2) {
                int x = spriteCoordinatesData[k + 2];
                int y = spriteCoordinatesData[k + 3];
                TextureRegion tempRegion = new TextureRegion(spriteSheet, x, y, width, height);
                tempTexRegArray[j] = tempRegion;
            }
            tempAnimationList.add(new Animation(0.15f, tempTexRegArray));

        }

        //If we have animationdata with two different animations, this is special case.
        if (outAnimationMapArray.length > 1) {
            int lengthOfFirstPart = 8;
            @SuppressWarnings("unchecked")
            Map<String, Animation> outAnimationMap = (Map<String, Animation>) outAnimationMapArray[0];
            @SuppressWarnings("unchecked")
            Map<String, Animation> outAnimationMap2 = (Map<String, Animation>) outAnimationMapArray[1];

            for (int i = 0; i < animationLengthData.length; i++) {
                if (i > lengthOfFirstPart) {

                    outAnimationMap2.put(keyForAnimations[i], tempAnimationList.get(i));

                } else
                    outAnimationMap.put(keyForAnimations[i], tempAnimationList.get(i));
            }
        }

        //Else we just load the animation in as usual
        else {
            @SuppressWarnings("unchecked")
            Map<String, Animation> outAnimationMap = (Map<String, Animation>) outAnimationMapArray[0];

            for (int i = 0; i < tempAnimationList.size(); i++) {

                outAnimationMap.put(keyForAnimations[i], tempAnimationList.get(i));

            }
        }

    }


    //Getters for the generated animations
    public Map<String, Animation> getWizardAnimations() {

        return mappedWizardTalkAnimation;
    }

    public Map<String, Animation> getWizard2Animations() {

        return mappedWizard2TalkAnimation;

    }

    public Map<String, Animation> getDemonAnimations() {

        return mappedDemonTalkAnimation;
    }

    public Map<String, Animation> getSpellAnimations() {

        return mappedSpellAnimation;
    }

    public int[] getInterpolDataX() {

        return animPathInterpolatedX;

    }

    public int[] getInterpolDataY() {

        return animPathInterpolatedY;
    }


}

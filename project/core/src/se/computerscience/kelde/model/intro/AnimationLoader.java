package se.computerscience.kelde.model.intro;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.startmenu.StartMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Daniel Olsson
 */

public class AnimationLoader {

    Intro introModel;


    Map<String, Animation> mappedWizardTalkAnimation;
    Map<String, Animation> mappedDemonTalkAnimation;
    Map<String, Animation> mappedWizard2TalkAnimation;
    Map<String, Animation> mappedSpellAnimation;

    List<Animation> introAnimationDemonAnimations;
    List<Animation> introAnimationSpellAnimations;
    List<Animation> introWizardTalkAnimations;

    // Animations for spell path
    int[] animPathCordsX = new int[]{740, 792, 816, 871, 921, 985, 1075, 1161, 1239, 1276, 1201, 1114, 1036, 966, 960, 1100, 1300, 1400, 1400, 1400};
    int[] animPathInterpolatedX;
    int[] animPathCordsY = new int[]{400, 666, 699, 747, 783, 814, 831, 810, 852, 801, 745, 700, 658, 582, 490, 418, 440, 500, 500, 500};
    int[] animPathInterpolatedY;


    public AnimationLoader(Intro introModel) {

        mappedWizardTalkAnimation = new HashMap<String, Animation>();
        mappedWizard2TalkAnimation = new HashMap<String, Animation>();
        mappedDemonTalkAnimation = new HashMap<String, Animation>();
        mappedSpellAnimation = new HashMap<String, Animation>();
        introWizardTalkAnimations = new ArrayList<Animation>();
        introAnimationDemonAnimations = new ArrayList<Animation>();
        introAnimationSpellAnimations = new ArrayList<Animation>();

        this.introModel = introModel;

        animPathInterpolatedX = new int[animPathCordsX.length * 4];
        animPathInterpolatedY = new int[animPathCordsY.length * 4];
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


        //Loading animations for wizard

        int[] wizardAnimationLengthData = introModel.getWizardAnimationData();
        int[] wizardSpriteCoordinates = introModel.getWizardTalkCoordinates();
        Texture wizardSpriteSheet = new Texture(introModel.getIntroWizardTalkImage());
        wizardSpriteSheet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        int width = wizardSpriteCoordinates[0];
        int height = wizardSpriteCoordinates[1];

        for (int i = 0, k = 0; i < wizardAnimationLengthData.length; i++) {
            TextureRegion[] tempTexRegArray = new TextureRegion[wizardAnimationLengthData[i]];
            for (int j = 0; j < wizardAnimationLengthData[i]; j++, k += 2) {
                int x = wizardSpriteCoordinates[k + 2];
                int y = wizardSpriteCoordinates[k + 3];
                TextureRegion tempRegion = new TextureRegion(wizardSpriteSheet, x, y, width, height);
                tempTexRegArray[j] = tempRegion;
            }
            introWizardTalkAnimations.add(new Animation(0.15f, tempTexRegArray));

        }

        String[] keyForAnimations = new String[]{"backwalk", "walkforward", "wandlight"};

        for (int i = 0; i < introWizardTalkAnimations.size(); i++) {

            mappedWizardTalkAnimation.put(keyForAnimations[i], introWizardTalkAnimations.get(i));

        }

        //Loading animatinos for demon and wizard 2

        int[] demonAndSecondWizardAnimationLengthData = introModel.getDemonAnimationData();
        int[] demonSpriteCoordinates = introModel.getIntroDemonCoordinates();
        Texture demonSpriteSheet = new Texture(introModel.getDemonAnd2ndWizardImage());
        demonSpriteSheet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        int width2 = demonSpriteCoordinates[0];
        int height2 = demonSpriteCoordinates[1];

        for (int i = 0, k = 0; i < demonAndSecondWizardAnimationLengthData.length; i++) {
            TextureRegion[] tempTexRegArray = new TextureRegion[demonAndSecondWizardAnimationLengthData[i]];
            for (int j = 0; j < demonAndSecondWizardAnimationLengthData[i]; j++, k += 2) {
                int x = demonSpriteCoordinates[k + 2];
                int y = demonSpriteCoordinates[k + 3];
                TextureRegion tempRegion = new TextureRegion(demonSpriteSheet, x, y, width2, height2);
                tempTexRegArray[j] = tempRegion;
            }
            introAnimationDemonAnimations.add(new Animation(0.15f, tempTexRegArray));

        }
        String[] keyForAnimations2 = new String[]{"demonspellhit", "demonlaughleft", "demontalkleft", "demonsideleft",
                "demonlaughright", "demontalkright", "demonbreathe", "demonwalk", "demonpoint", "wizardshoot",
                "wizardbehind", "wizardstandright", "wizardstandleft", "wizardtalkleft", "wizardtalkright", "wizardwalk"};
        for (int i = 0; i < introAnimationDemonAnimations.size(); i++) {
            if (i > 8) {

                mappedWizard2TalkAnimation.put(keyForAnimations2[i], introAnimationDemonAnimations.get(i));

            } else
                mappedDemonTalkAnimation.put(keyForAnimations2[i], introAnimationDemonAnimations.get(i));
        }


        // Loading animations for spell
        int[] spellAnimationLengthData = introModel.getSpellAnimationLength();
        int[] spellSpriteCoordinaters = introModel.getSpellIntroCoordinaters();

        Texture spellSprite = new Texture(introModel.getSpellSpritePath());
        spellSprite.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        int width3 = spellSpriteCoordinaters[0];
        int height3 = spellSpriteCoordinaters[1];

        for (int i = 0, k = 0; i < spellAnimationLengthData.length; i++) {
            TextureRegion[] tempTextRegArray = new TextureRegion[spellAnimationLengthData[i]];

            for (int j = 0; j < spellAnimationLengthData[i]; j++, k += 2) {

                int x = spellSpriteCoordinaters[k + 2];
                int y = spellSpriteCoordinaters[k + 3];
                TextureRegion tempRegion = new TextureRegion(spellSprite, x, y, width3, height3);
                tempTextRegArray[j] = tempRegion;
            }
            introAnimationSpellAnimations.add(new Animation(0.15f, tempTextRegArray));

        }
        String[] keyForAnimations3 = new String[]{"start", "explosion", "loop"};
        for (int i = 0; i < introAnimationSpellAnimations.size(); i++) {

            mappedSpellAnimation.put(keyForAnimations3[i], introAnimationSpellAnimations.get(i));
        }


    }


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

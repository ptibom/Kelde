package se.computerscience.kelde.model.intro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 5/27/2015.
 */
public  final class AnimationBuilder {


    private static int k;

    private AnimationBuilder(){}


    // Creates and returns a list of all animations in a spreadsheet
    public static List<IntroAnimation> createListofAnimations(int[] data, int[] data2){
        final List<IntroAnimation> tempList = new ArrayList<>();
        k = 0;
        List<IntroSpriteFrame> tempListOfFrames;

        // First we check the length of the array containing all animation lengths
        for (int i = 0 ; i < ( data).length; i++) {
            tempListOfFrames = createNewIntroSpriteList();
            // Then we check the actual length per animation, variable k is increasing by 2 because
            // each cell in the array contains an x-coord and y-coord, to take next we must jump 2 steps.
            for (int j = 0; j < data[i]; j++, k += 2) {
                tempListOfFrames.add(createNewInstance(k,  data2));
            }
            tempList.add(createIntroAnimation(tempListOfFrames));
        }

        return tempList;
    }
    // Creates a new IntroAnimation
    public static IntroAnimation createIntroAnimation(List<IntroSpriteFrame> tempList){

        return new IntroAnimation(tempList);
    }

    public static List<IntroSpriteFrame> createNewIntroSpriteList(){
        return new ArrayList<>();
    }

    // Creates a new introsprite frame using the sprite coordinate data for the spreadsheet
    public static IntroSpriteFrame createNewInstance(int k, int[] data){

        return new IntroSpriteFrame(data[k + 2],data[k + 3],data[0],data[1]);

    }



}

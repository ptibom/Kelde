package se.computerscience.kelde.model.intro;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

// Usueful tool to time the animations
public final class AnimationToolsUtilites {


    private static  int[] textureRegionCoordinates;
    private static int dataIndex;
    private AnimationToolsUtilites(){

    }

    public static boolean timeRange(double time, double x, double y) {
        return (time / 1000) >= x && (time / 1000) < y;

    }

    // Loading the coordinates for each TextureRegion from raw input
    public static int [] loadTextureRegionData(int spriteSize, List<String> data) {

        textureRegionCoordinates = new int[data.size()-7/7];

        textureRegionCoordinates[0] = spriteSize;
        textureRegionCoordinates[1] = spriteSize;
        dataIndex = 2;
        for (int i = 7; i < data.size(); i += 7) {


            final String[] tempFormat = data.get(i - 1).split(" ");
            textureRegionCoordinates[dataIndex] = Integer.parseInt(tempFormat[3]);
            textureRegionCoordinates[dataIndex + 1] = Integer.parseInt(tempFormat[4].replaceAll("\r", ""));
            dataIndex += 2;
        }
        return Arrays.copyOf(textureRegionCoordinates,textureRegionCoordinates.length);

    }






}
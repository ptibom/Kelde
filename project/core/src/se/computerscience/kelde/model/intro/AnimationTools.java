package se.computerscience.kelde.model.intro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

// Usueful tool to time the animations
public class AnimationTools {

    public static boolean timeRange(double time, double x, double y) {
        return ((time / 1000) >= x) && ((time / 1000) < y);

    }

    // Loading the coordinates for each TextureRegion from raw input
    public static int [] loadTextureRegionData(int spriteSize, List<String> data) {

        int[] TextureRegionCoordinates = new int[(data.size()-7/7)];

        TextureRegionCoordinates[0] = spriteSize;
        TextureRegionCoordinates[1] = spriteSize;
        for (int i = 7, dataIndex = 2; i < data.size(); i += 7) {



            String[] tempFormat = data.get(i - 1).split(" ");
            TextureRegionCoordinates[dataIndex] = Integer.parseInt(tempFormat[3]);
            TextureRegionCoordinates[dataIndex + 1] = Integer.parseInt(tempFormat[4].replaceAll("\r", ""));
            dataIndex += 2;
        }
        return TextureRegionCoordinates;

    }




}
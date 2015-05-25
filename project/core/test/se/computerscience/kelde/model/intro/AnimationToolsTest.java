package se.computerscience.kelde.model.intro;

import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */
public class AnimationToolsTest {

    @Test
    public void testTimeRange() throws Exception {

        double time = 2.5;

        assertTrue(AnimationTools.timeRange(time,0,3));
    }

    @Test
    public void testLoadTextureRegionData() throws Exception {
        Charset charset = Charset.forName("UTF-8");


        List<String> test = Files.readAllLines(Paths.get("intro/introtalk.txt"), charset);

        int[] parsedData = AnimationTools.loadTextureRegionData(128, test);

        assertEquals(7,parsedData.length);


    }
}
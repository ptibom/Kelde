package se.computerscience.kelde.model.intro;

import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author: Daniel Olsson
 */
public class AnimationToolsUtilitesTest {
    // Testing if the program reads in the data correctly
    @Test
    public void testTimeRange() throws Exception {
        double time = 2.5;
        assertTrue(AnimationToolsUtilites.timeRange(time, 0, 3));
    }

    @Test
    public void testLoadTextureRegionData() throws Exception {
        Charset charset = Charset.forName("UTF-8");
        List<String> test = Files.readAllLines(Paths.get("C:/FixingTheBranch/sixthTry/EIGTHTRY/Kelde/project/core/assets/intro/introtalk.txt"), charset);
        int[] parsedData = AnimationToolsUtilites.loadTextureRegionData(128, test);
        assertEquals(59, parsedData.length);
    }
}
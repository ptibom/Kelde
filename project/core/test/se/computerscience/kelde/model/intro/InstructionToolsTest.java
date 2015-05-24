package se.computerscience.kelde.model.intro;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */
public class InstructionToolsTest {

    @Test
    public void testLoadAndGatherInstructions() throws Exception {


        List<String> arrayList = new ArrayList<>();
        arrayList.add("2 3 55 55 70 -50 demonwalk");
        List<IntroInstruction> instructinList= InstructionTools.loadAndGatherInstructions(arrayList);
        assertEquals(1, instructinList.size());

    }
}
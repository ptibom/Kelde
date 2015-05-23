package se.computerscience.kelde.model.intro;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public class InstructionTools {


    // Takes a string with instructions and converts it into instruction class to feed the animationhandler
    public static List<IntroInstruction> loadAndGatherInstructions(List<String> instructionString) throws FileNotFoundException {

        List<IntroInstruction> setOfInstruction = new ArrayList<>();
        for (String data : instructionString) {
            String[] splitData = data.split(" ");

            // We need all 5 intro files for this intro to function
            if(instructionString.isEmpty())
                throw new FileNotFoundException("Files are missing");


            if (splitData.length > 6) {
                double startTime = Double.parseDouble(splitData[0]);
                double endTime = Double.parseDouble(splitData[1]);
                int heightChange = Integer.parseInt(splitData[2]);
                int widthChange = Integer.parseInt(splitData[3]);
                int xChange = Integer.parseInt(splitData[4]);
                int yChange = Integer.parseInt(splitData[5]);
                String animationName = splitData[6];


                // Check if it's an still keyframe or regular animation
                if (splitData.length == 8) {
                    float keyFrame = Integer.parseInt(splitData[7]);
                    setOfInstruction.add(new IntroInstruction(startTime, endTime, keyFrame, heightChange, widthChange, xChange, yChange, animationName));
                } else {
                    setOfInstruction.add(new IntroInstruction(startTime, endTime, heightChange, widthChange, xChange, yChange, animationName));
                }


            }

            // Checks if it it's a interpolated X Y coordinates instruction
            else if (splitData.length == 4) {

                double startCount = Double.parseDouble(splitData[0]);
                double startTime = Double.parseDouble(splitData[1]);
                double endTime = Double.parseDouble(splitData[2]);
                String animationName = splitData[3];

                setOfInstruction.add(new IntroInstruction(startCount, startTime, endTime, animationName));

            }

            // Checks if it's an dialogue
            else if (splitData.length == 3) {

                int dialogNumber = Integer.parseInt(splitData[0]);
                double startTime = Double.parseDouble(splitData[1]);
                double endTime = Double.parseDouble(splitData[2]);
                setOfInstruction.add(new IntroInstruction(dialogNumber, startTime, endTime));
            }
        }
        return setOfInstruction;
    }


}

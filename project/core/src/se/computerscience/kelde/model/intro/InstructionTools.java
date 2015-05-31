package se.computerscience.kelde.model.intro;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public final class InstructionTools {

    private static String[] splitData;
    private static List<IntroInstruction> setOfInstruction;

    private InstructionTools() {
    }

    // Takes a string with instructions and converts it into instruction class to feed the animationhandler
    public static List<IntroInstruction> loadAndGatherInstructions(List<String> instructionString) throws FileNotFoundException {

        setOfInstruction = new ArrayList<>();

        for (final String data : instructionString) {
            splitData = data.split(" ");

            // We need all 5 intro files for this intro to function
            if (instructionString.isEmpty()) {
                throw new FileNotFoundException("Files are missing");
            }

            if (splitData.length > 6) {
                final double startTime = Double.parseDouble(splitData[0]);
                final double endTime = Double.parseDouble(splitData[1]);
                final int heightChange = Integer.parseInt(splitData[2]);
                final int widthChange = Integer.parseInt(splitData[3]);
                final int xChange = Integer.parseInt(splitData[4]);
                final int yChange = Integer.parseInt(splitData[5]);
                final String animationName = splitData[6];

                // Check if it's an still keyframe or regular animation
                if (splitData.length == 8) {
                    final float keyFrame = Integer.parseInt(splitData[7]);
                    setOfInstruction.add(createSevenParamInstruct(startTime, endTime, keyFrame, heightChange, widthChange, xChange, yChange, animationName));
                } else {
                    setOfInstruction.add(createSixParamInstruct(startTime, endTime, heightChange, widthChange, xChange, yChange, animationName));
                }
            }

            // Checks if it it's a interpolated X Y coordinates instruction
            else if (splitData.length == 4) {
                final double startCount = Double.parseDouble(splitData[0]);
                final double startTime = Double.parseDouble(splitData[1]);
                final double endTime = Double.parseDouble(splitData[2]);
                final String animationName = splitData[3];
                setOfInstruction.add(createFourParamInstruct(startCount, startTime, endTime, animationName));
            }
            // Checks if it's an dialogue
            else if (splitData.length == 3) {
                final int dialogNumber = Integer.parseInt(splitData[0]);
                final double startTime = Double.parseDouble(splitData[1]);
                final double endTime = Double.parseDouble(splitData[2]);
                setOfInstruction.add(createThreeParamInstruct(dialogNumber, startTime, endTime));
            }
        }
        return setOfInstruction;
    }

    public static IntroInstruction createSevenParamInstruct(double startTime, double endTime, float keyFrame, int heightChange, int widthChange, int xChange, int yChange, String animationName) {
        return new IntroInstruction(startTime, endTime, keyFrame, heightChange, widthChange, xChange, yChange, animationName);
    }

    public static IntroInstruction createSixParamInstruct(double startTime, double endTime, int heightChange, int widthChange, int xChange, int yChange, String animationName) {
        return new IntroInstruction(startTime, endTime, heightChange, widthChange, xChange, yChange, animationName);
    }

    public static IntroInstruction createFourParamInstruct(double startCount, double startTime, double endTime, String animationName) {
        return new IntroInstruction(startCount, startTime, endTime, animationName);
    }

    public static IntroInstruction createThreeParamInstruct(int dialogNumber, double startTime, double endTime) {
        return new IntroInstruction(dialogNumber, startTime, endTime);
    }
}

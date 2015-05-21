package se.computerscience.kelde.controller.intro;


import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.view.intro.IntroView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public class IntroController {

    private Intro introModel;
    private IntroView introView;

    public IntroController() throws IOException {

        ArrayList<List<String>> allData = new ArrayList<List<String>>();
        allData.add(Files.readAllLines(Paths.get("intro/introsprites.txt")));
        allData.add(Files.readAllLines(Paths.get("intro/introtalk.txt")));
        allData.add(Files.readAllLines(Paths.get("intro/spell.txt")));
        allData.add(Files.readAllLines(Paths.get("intro/animationdemon.intro")));
        allData.add(Files.readAllLines(Paths.get("intro/animationwizardinstr.intro")));
        allData.add(Files.readAllLines(Paths.get("intro/animationwizard2instr.intro")));
        allData.add(Files.readAllLines(Paths.get("intro/animationwizarddialogue.intro")));
        allData.add(Files.readAllLines(Paths.get("intro/animationdemondialog.intro")));
        allData.add(Files.readAllLines(Paths.get("intro/animationspellinstr.intro")));

        this.introModel = new Intro(allData);
        this.introView = new IntroView(introModel);
    }

    public void render(float delta) {
         introView.renderIntro(delta);
    }



}

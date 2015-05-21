package se.computerscience.kelde.controller.intro;


import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.view.intro.IntroView;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.Charset;

/**
 * @author: Daniel Olsson
 */

public class IntroController {

    private Intro introModel;
    private IntroView introView;

    public IntroController() throws IOException {
        Charset charset = Charset.forName("UTF-8");
        ArrayList<List<String>> allData = new ArrayList<List<String>>();
        allData.add(Files.readAllLines(Paths.get("intro/introsprites.txt"),charset));
        allData.add(Files.readAllLines(Paths.get("intro/introtalk.txt"),charset));
        allData.add(Files.readAllLines(Paths.get("intro/spell.txt"),charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationdemon.intro"),charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationwizardinstr.intro"),charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationwizard2instr.intro"),charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationwizarddialogue.intro"),charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationdemondialog.intro"),charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationspellinstr.intro"),charset));

        this.introModel = new Intro(allData);
        this.introView = new IntroView(introModel);
    }

    public void render(float delta) {
         introView.renderIntro(delta);
    }



}

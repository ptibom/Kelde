package se.computerscience.kelde.controller.intro;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.controller.events.ScreenEventBus;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.view.intro.IntroView;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public class IntroController {

    private final IntroView introView;

    // This class takes care of input to model and gets callbacks from the view.
    public IntroController() throws IOException {
        final Charset charset = Charset.forName("UTF-8");
        final ArrayList<List<String>> allData = new ArrayList<List<String>>();
        allData.add(Files.readAllLines(Paths.get("intro/introsprites.txt"), charset));
        allData.add(Files.readAllLines(Paths.get("intro/introtalk.txt"), charset));
        allData.add(Files.readAllLines(Paths.get("intro/spell.txt"), charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationdemon.intro"), charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationwizardinstr.intro"), charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationwizard2instr.intro"), charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationwizarddialogue.intro"), charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationdemondialog.intro"), charset));
        allData.add(Files.readAllLines(Paths.get("intro/animationspellinstr.intro"), charset));

        this.introView = new IntroView(new Intro(allData));

        introView.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                introView.getHandler().stopIntroMusic();
                ScreenEventBus.INSTANCE.publish(new ScreenEvent(ScreenEvent.Tag.SET_SCREEN, ScreenEvent.ScreenTag.START_WORLD));
                introView.dispose();
            }
        });


    }

    public void render(float delta) {

        introView.render(delta);
    }


    public void resize(int width, int height){
        introView.resize(width, height);
    }

    public void dispose(){
        introView.dispose();
    }
}

package se.computerscience.kelde.model.startmenu;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by MonoMan on 5/24/2015.
 */
public class AnimationLoaderTest {

    StartMenu menu;

    public AnimationLoaderTest(){
        try {
            menu = new StartMenu();
        }
        catch (IOException e){
            System.out.println("Files not found");
        }
    }

    @Test
    public void testLoadWalkingCharacters() throws Exception {




    }
}
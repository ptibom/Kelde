package se.computerscience.kelde.controller;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.EntityBat;
import se.computerscience.kelde.view.ViewBat;

import java.awt.*;


/**
 * Created by Anders on 2015-04-06.
 */
public class ControlBat {

    //Variables
    private final EntityBat ebat;
    private final ViewBat vbat;
    private Vector2 startPos;



    public ControlBat(Vector2 startVector) {
        ebat = new EntityBat();
        vbat = new ViewBat(startVector);
        startPos = startVector;
    }

    public void render(OrthographicCamera camera) {
       vbat.render(startPos, camera);
    }


    public void resize(OrthographicCamera camera) {
        vbat.resize();
    }

}

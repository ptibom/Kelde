package se.computerscience.kelde.controller;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
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




    public ControlBat(EntityBat ebat, ViewBat vbat) {
        this.ebat = ebat;
        this.vbat = vbat;
    }

    public void render() {
       vbat.render(position, camera);
    }

    public void setNewWaypoint() {
        p = ebat.getWayPoint();
        waypointX = p.x;
        waypointY = p.y;
    }


    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }

    public void dispose() {
        batch.dispose();
        textureAtlas.dispose();
    }
}

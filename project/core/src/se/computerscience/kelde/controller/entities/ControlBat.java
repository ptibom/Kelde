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
    private final OrthographicCamera camera;
    private SpriteBatch batch;
    private TextureAtlas textureAtlas;
    private Animation animation;
    private int x = 0;
    private int y = 0;
    float elapsedTime = 0;
    private Point p;
    private int waypointX,waypointY;
    private float viewportWidth;
    private float viewportHeight;

    public ControlBat(EntityBat ebat, ViewBat vbat) {
        camera = new OrthographicCamera();
        this.ebat = ebat;
        this.vbat = vbat;
        batch = vbat.getBatch();
        textureAtlas = vbat.getTextureAtlas();
        animation = vbat.getAnimationN();
        setNewWaypoint();
    }

    public void render() {
       //Gdx.gl.glClearColor(0, 0, 0, 1);
       //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        if(x == waypointX && y == waypointY) {
            setNewWaypoint();
        }
        if(x > waypointX) {
            x -= 1;
            animation = vbat.getAnimationE();
        } else if (x < waypointX) {
            x += 1;
            animation = vbat.getAnimationW();
        }
        if(y > waypointY) {
            y -= 1;
            animation = vbat.getAnimationS();
        } else if(y < waypointY) {
            y += 1;
            animation = vbat.getAnimationN();
        }

        elapsedTime += Gdx.graphics.getDeltaTime();
        if(elapsedTime > 10.0f) { elapsedTime = 0f; }
        batch.draw(animation.getKeyFrame(elapsedTime, true), x, y);
        batch.end();
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

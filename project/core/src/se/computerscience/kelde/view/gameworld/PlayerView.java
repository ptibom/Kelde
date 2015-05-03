package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import se.computerscience.kelde.model.entities.EntityPlayer;

/**
 * Created by Hossein on 2015-04-09.
 */
public class PlayerView {

    EntityPlayer player;
    //SpriteBatch batch;
    private SpriteBatch batch;

    public void resize(Camera cam) {
        batch.setProjectionMatrix(cam.combined);
    }

    public PlayerView(int x,int y){
        player = new EntityPlayer(x,y);
        batch = new SpriteBatch();
    }

    public int getX(){
        return player.getPosX();
    }
    public int getY(){
        return player.getPosY();
    }
    public String getDirection(){
        return player.getDirection();
    }

    public void render(){
        System.out.println("im a player@ " + player.getPosX() + "," + player.getPosY());
        // change pos here
        movePlayerOnCmd();

        batch.begin();
        batch.draw(new Texture("testSprite.png"), player.getPosX(), player.getPosY());
        batch.end();
    }

    public void movePlayerOnCmd(){
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.setPosY(player.getPosY() + player.getMovementSpeed());
            player.setDirection("UP");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.setPosY(player.getPosY() - player.getMovementSpeed());
            player.setDirection("DOWN");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.setPosX(player.getPosX() + player.getMovementSpeed());
            player.setDirection("RIGHT");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.setPosX(player.getPosX() - player.getMovementSpeed());
            player.setDirection("LEFT");
        }
    }

}

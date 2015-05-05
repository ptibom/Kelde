package se.computerscience.kelde.controller.gameworld;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import se.computerscience.kelde.model.gameworld.BarrelModel;
import se.computerscience.kelde.model.gameworld.TreasureModell;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.view.gameworld.BarrelView;
import se.computerscience.kelde.view.gameworld.TreasureView;

/**
 * Created by Hossein on 2015-04-28.
 */
public class TreasureController implements IWorldObjectsController {
    TreasureModell treasureModell;
    TreasureView treasureView;

    public TreasureController(TreasureModell treasureModell, TreasureView treasureView) {
        this.treasureModell = treasureModell;
        this.treasureView = treasureView;
    }
    public void update(float delta){
        //
    }
    public void openTreasure(){
        treasureView.setSprite(new Sprite(new Texture("chest1.png"),30,32));
        System.out.println("treasure open");
    }
    public void closeTreasure(){
        treasureView.setSprite(new Sprite(new Texture("chest2.png"),32,32));
        System.out.println("treasure closed");
    }
}
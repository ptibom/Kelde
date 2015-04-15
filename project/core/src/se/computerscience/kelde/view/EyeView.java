package se.computerscience.kelde.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;


/**
 * Created by Anders on 2015-04-08.
 */
public class EyeView {

    //Variables
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasE, textureAtlasW;
    private Animation animation,animationN,animationE,animationS,animationW;
    private float ELAPSED_TIME = 0;
    private Vector2 oldposition;


    public EyeView() {
        camera = new OrthographicCamera();
        
        batch = new SpriteBatch();
        textureAtlasNorth = new TextureAtlas(Gdx.files.internal("eyeballNorth.atlas"));
        animationN = new Animation(0.15f, textureAtlasNorth.getRegions());

        //Bat facing south
        textureAtlasSouth = new TextureAtlas(Gdx.files.internal("eyeballSouth.atlas"));
        animationS = new Animation(0.15f, textureAtlasSouth.getRegions());

        //Bat facing east
        textureAtlasE = new TextureAtlas(Gdx.files.internal("eyeballEast.atlas"));
        animationE = new Animation(0.15f, textureAtlasE.getRegions());

        //Bat facing west
        textureAtlasW = new TextureAtlas(Gdx.files.internal("eyeballWest.atlas"));
        animationW = new Animation(0.15f, textureAtlasW.getRegions());
    }


    public void  render(Vector2 position, Vector2 oldposition, OrthographicCamera camera) {
        this.camera = camera;
        this.oldposition = oldposition;
        float x = position.x;
        float y = position.y;

        batch.begin();

        if(x > oldposition.x) {
            x -= 1;
            animation = animationE;
        } else if (x < oldposition.x) {
            x += 1;
            animation = animationW;
        }
        if(y > oldposition.y) {
            y -= 1;
            animation = animationS;
        } else if(y < oldposition.y) {
            y += 1;
            animation = animationN;
        }

        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        if(ELAPSED_TIME > 10.0f) { ELAPSED_TIME = 0f; }
        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), x, y);
        batch.end();
    }

    public void resize() {
        batch.setProjectionMatrix(camera.combined);
    }

}

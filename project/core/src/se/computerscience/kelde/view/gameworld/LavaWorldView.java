/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.LavaWorld;
import se.computerscience.kelde.view.entities.EntityPlayerKeldeView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;
import se.computerscience.kelde.view.worldobjects.DoorView;
import se.computerscience.kelde.view.worldobjects.LavaRingView;
import se.computerscience.kelde.view.worldobjects.LavaSplashView;

public class LavaWorldView {

    private final OrthogonalTiledMapRenderer mapRenderer;
    private final LavaWorld lavaWorld;
    private final SpriteBatch batch;

    private final WorldPhysicsView worldPhysicsView;
    private final EntityPlayerKeldeView entityPlayerKeldeView;

    private final DoorView doorView;
    private final LavaRingView lavaRingView;
    //private final LavaSplashView lavaSplashView;
    private final LavaSplashView[] lavaSplashView;
    public LavaWorldView(LavaWorld lavaWorld) {
        this.lavaWorld = lavaWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(lavaWorld.getMap().getTiledMap());

        batch = new SpriteBatch();

        worldPhysicsView = new WorldPhysicsView(lavaWorld.getWorldPhysics());
        entityPlayerKeldeView = new EntityPlayerKeldeView(lavaWorld.getEntityPlayerKelde());
        doorView = new DoorView(lavaWorld.getDoor(),"door2");
        lavaRingView = new LavaRingView(lavaWorld.getLavaRing());
        lavaSplashView = new LavaSplashView[lavaWorld.getLavaRing().getLavaSplash().length];

        for (int i = 0; i < lavaWorld.getLavaRing().getLavaSplash().length ; i++) {
            lavaSplashView[i] = new LavaSplashView(lavaWorld.getLavaRing().getLavaSplash()[i]);
        }
        //lavaSplashView = new LavaSplashView(lavaWorld.getLavaRing().getLavaSplash());
    }

    public void render(float delta) {
        // Draw map
        mapRenderer.setView(lavaWorld.getCamera().getOrthographicCamera());
        mapRenderer.render();

        // Draw sprites
        batch.begin();
        doorView.draw(batch);
        lavaRingView.draw(batch);
        //lavaSplashView.draw(batch);
        for (int i = 0; i < lavaWorld.getLavaRing().getLavaSplash().length; i++) {
            lavaSplashView[i].draw(batch);
        }
        entityPlayerKeldeView.draw(batch);
        batch.end();

        // Physics debug renderer, comment out to remove debugger lines.
        worldPhysicsView.render(delta);
    }

    public void updateProjectionMatrix() {
        batch.setProjectionMatrix(lavaWorld.getCamera().getOrthographicCamera().combined);
    }

    public void dispose() {
        mapRenderer.dispose();
    }

    public OrthogonalTiledMapRenderer getMapRenderer() {
        return mapRenderer;
    }
    public WorldPhysicsView getWorldPhysicsView() {
        return worldPhysicsView;
    }
    public EntityPlayerKeldeView getEntityPlayerKeldeView() {
        return entityPlayerKeldeView;
    }

    public DoorView getDoorView() {
        return doorView;
    }

    public LavaRingView getLavaRingView() {
        return lavaRingView;
    }

    //public LavaSplashView getLavaSplashView() {
      //  return lavaSplashView;
    //}

    public LavaSplashView[] getLavaSplashView() {
        return lavaSplashView;
    }
}
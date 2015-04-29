/** Description: Modelling the world physics. Using box2d physics engine.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.physics;

import se.computerscience.kelde.encapsulation.box2d.B2DParser;
import se.computerscience.kelde.encapsulation.box2d.B2DWorld;
import se.computerscience.kelde.encapsulation.box2d.IB2DParser;
import se.computerscience.kelde.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.encapsulation.libgdx.Camera;
import se.computerscience.kelde.encapsulation.libgdx.ICamera;
import se.computerscience.kelde.encapsulation.libgdx.IMap;

public class WorldPhysics {
    // Scale 100 pixels to 1 meter. box2d uses: Meters, Kilograms, Seconds as units
    private static final float BOX2D_SCALE = 0.01f;
    private static final int VELOCITY_ITERATIONS = 6;
    private static final int POSITION_ITERATIONS = 2;

    private final ICamera ib2DCamera; // Used to debug box2d visually.
    private final IB2DWorld ib2DWorld; // Wrapping box2d World.

    public WorldPhysics(IMap map) {
        ib2DWorld = new B2DWorld();
        ib2DCamera = new Camera();

        IB2DParser parser = new B2DParser(BOX2D_SCALE);
        parser.load(ib2DWorld, map);
    }

    public void update(float delta) {
        // Simulating the box2d world.
        ib2DWorld.step(delta, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }

    public void resizeCamera(int width, int height) {
        // Prevents stretching/resizing of images. Keeps a perfect resolution when window is resized.
        ib2DCamera.setViewPortWidth(width*BOX2D_SCALE);
        ib2DCamera.setViewPortHeight(height*BOX2D_SCALE);
        ib2DCamera.setPosition(width * BOX2D_SCALE / (float)2, height * BOX2D_SCALE / (float)2, 0);
        ib2DCamera.update();
    }

    public ICamera getIb2DCamera() {
        return ib2DCamera;
    }

    public IB2DWorld getIb2DWorld() {
        return ib2DWorld;
    }

    public void dispose() {
        ib2DWorld.dispose();
    }
}

package se.computerscience.kelde.controller.gameworld;

import se.computerscience.kelde.model.gameworld.SensorModel;
import se.computerscience.kelde.view.gameworld.SensorView;

/**
 * Created by Hassan on 2015-05-05.
 */
public class SensorController implements IWorldObjectsController {
    SensorModel sensorModel;
    SensorView sensorView;

    public SensorController(SensorModel sensorModel, SensorView sensorView) {
        this.sensorModel = sensorModel;
        this.sensorView = sensorView;
    }
}

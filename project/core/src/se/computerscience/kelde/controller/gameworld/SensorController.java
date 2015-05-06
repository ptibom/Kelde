/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.gameworld;

import se.computerscience.kelde.model.gameworld.SensorModel;
import se.computerscience.kelde.view.gameworld.SensorView;

public class SensorController implements IWorldObjectsController {
    SensorModel sensorModel;
    SensorView sensorView;

    public SensorController(SensorModel sensorModel, SensorView sensorView) {
        this.sensorModel = sensorModel;
        this.sensorView = sensorView;
    }
}

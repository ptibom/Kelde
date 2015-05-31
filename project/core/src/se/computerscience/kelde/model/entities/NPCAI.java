/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.entities;

public class NPCAI {
    public static float speed = 0.5f;
    public static float getVelocity(float d){
        if (d > speed) {
            return speed;
        }
        else if (d < -speed) {
            return -speed;
        }
        return 0;
    }
}
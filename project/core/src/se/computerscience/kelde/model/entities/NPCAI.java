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

    public static float deltaX(float playerX, float monsterX){
        return playerX + 32 - monsterX;
    }
    public static float deltaY(float playerY, float monsterY ){
        return playerY + 8 - monsterY;
    }
    public static float distance(float playerX, float playerY, float monsterX, float monsterY){
        float dx = deltaX(playerX,monsterX);
        float dy = deltaY(playerY,monsterY);
        return (float) Math.sqrt(dx*dx+dy*dy);
    }
}
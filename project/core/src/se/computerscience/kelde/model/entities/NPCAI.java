/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.entities;

public final class NPCAI {
    public static final float SPEED = 0.5f;

    private NPCAI(){

    }

    public static float getVelocity(float d){
        if (d > SPEED) {
            return SPEED;
        }
        else if (d < -SPEED) {
            return -SPEED;
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
        final float dx = deltaX(playerX,monsterX);
        final float dy = deltaY(playerY,monsterY);
        return (float) Math.sqrt(dx*dx+dy*dy);
    }
}
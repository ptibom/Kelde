/* Description: This is a player controlled character with base-stats. The used player character will be extend this class for modularity.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

public class EntityPlayer implements IPlayerEntity {
    private int health = 100;
    private int mana = 100;
    private int strength = 10;
    private int intelligence = 10;
    private int posX;
    private int posY;
    private int movementSpeed=2;
    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public EntityPlayer(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }



    /* Getters */
    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    /* Temporary setters */
    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}

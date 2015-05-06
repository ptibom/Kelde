package se.computerscience.kelde.controller.items;

/**
 * Created by Hassan on 2015-05-05.
 */
public interface IitemController {
    public void setVisble(boolean visble);
    public boolean isVisble();
    public boolean isPicked();
    public void setPicked(boolean picked);
    public String itemName();
}

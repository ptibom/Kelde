/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

public interface IItemController {
    public void setVisble(boolean visble);
    public boolean isVisble();
    public boolean isPicked();
    public void setPicked(boolean picked);
}
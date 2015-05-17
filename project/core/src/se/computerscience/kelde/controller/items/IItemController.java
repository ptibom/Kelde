/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

public interface IItemController {
    public void setVisible(boolean visible);
    public boolean isVisible();
    public boolean isPicked();
    public void setPicked(boolean picked);
}
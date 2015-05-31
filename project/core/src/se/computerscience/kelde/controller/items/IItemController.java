/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

public interface IItemController {
    void setVisble(boolean visble);

    boolean isVisble();

    boolean isPicked();

    void setPicked(boolean picked);
}
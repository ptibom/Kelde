/**
 * @author: Anders Bolin
 * @revised: Philip Tibom
 */

package se.computerscience.kelde.controller.gameworld;

public interface IGameWorldController {
    void setKeyDown(int keycode);
    void setKeyUp(int keycode);
    void setMouseDown(int x, int y);
}

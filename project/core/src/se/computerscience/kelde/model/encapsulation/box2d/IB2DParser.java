/**
 * Description: Separating framework from model.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

import se.computerscience.kelde.model.encapsulation.libgdx.IMap;

public interface IB2DParser {
    public void load(IB2DWorld world, IMap map);
}

/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.constants;

import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.model.items.Bow;
import se.computerscience.kelde.model.items.IItem;
import se.computerscience.kelde.model.items.Sword;

import java.util.ArrayList;
import java.util.List;

public class ItemSets {
    public static List<IItem> getSet1() {
        List<IItem> items = new ArrayList<>();
        items.add(new Sword());
        items.add(new Axe());
        items.add(new Bow());
        return items;
    }

    public static List<IItem> getSet2() {
        List<IItem> items = new ArrayList<>();
        items.add(new Sword());
        items.add(new Axe());
        return items;
    }
}
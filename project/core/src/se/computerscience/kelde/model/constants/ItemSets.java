/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.constants;

import se.computerscience.kelde.model.items.*;

import java.util.ArrayList;
import java.util.List;

public final class ItemSets {
    private ItemSets() {

    }

    public static List<IItem> getSet1() {
        final List<IItem> items = new ArrayList<>();
        items.add(new Sword());
        items.add(new Axe());
        items.add(new Bow());
        return items;
    }

    public static List<IItem> getSet2() {
        final List<IItem> items = new ArrayList<>();
        items.add(new Sword());
        items.add(new Axe());
        items.add(new KeyLava());
        return items;
    }

    public static List<IItem> getSet3() {
        final List<IItem> items = new ArrayList<>();
        items.add(new HealthPotion());
        items.add(new ManaPotion());
        return items;
    }
}
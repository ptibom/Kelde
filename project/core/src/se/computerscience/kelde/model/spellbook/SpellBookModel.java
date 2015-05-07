package se.computerscience.kelde.model.spellbook;

import java.util.Map;

/**
 * Created by Daniel on 5/7/2015.
 */
public class SpellBookModel
{
    private final String SPELL_FOLDER_PATH = "spells";
    private Map<String, String> spellBook;

    public SpellBookModel(){

    spellBook.put("1", "firelion");
    spellBook.put("2", "iceshield");
    spellBook.put("3", "icetacle");
    spellBook.put("4", "lightningclaw");
    spellBook.put("5", "snakebite");
    spellBook.put("6", "tornado");
    spellBook.put("7", "torrentacle");
    spellBook.put("7", "turtleshell");


}

    public String getSpellFolderPath(){


        return SPELL_FOLDER_PATH;
    }

    public Map<String, String> getSpellBook(){

        return spellBook;
    }

}

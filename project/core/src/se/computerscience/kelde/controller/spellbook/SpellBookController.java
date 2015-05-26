package se.computerscience.kelde.controller.spellbook;

import se.computerscience.kelde.model.spellbook.SpellBookModel;
import se.computerscience.kelde.view.spellbook.SpellBookView;

/**
 * Created by Daniel on 5/7/2015.
 */
public class SpellBookController
{

    SpellBookModel spellBookModel;
    SpellBookView spellBookView;


    public SpellBookController(SpellBookModel spellBookModel, SpellBookView spellBookView){


    }


    public void castSpell(String spell){

        spellBookView.castSpell(spell);
    }
}

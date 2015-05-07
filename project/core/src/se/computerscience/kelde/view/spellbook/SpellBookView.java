package se.computerscience.kelde.view.spellbook;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import se.computerscience.kelde.model.spellbook.SpellBookModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniel on 5/7/2015.
 */
public class SpellBookView {

    SpellBookModel spellBookModel;
    Map<String, Animation> spellAnimations;

    public SpellBookView(SpellBookModel spellBookModel) {
        this.spellBookModel = spellBookModel;
        spellAnimations = new HashMap<String, Animation>();
    }


    public void init() {
        TextureRegion[] animationTextureRegionTemp;
        FileHandle fileHandle = Gdx.files.internal(spellBookModel.getSpellFolderPath());
        FileHandle[] fileHandleArray = fileHandle.list();

        for (FileHandle elem : fileHandleArray) {

            Texture spellTexture = new Texture(elem.path());

            if (elem.path() == (spellBookModel.getSpellFolderPath() + "/" + elem.path())) {


                for (int i = 0, yRegion = 256, xRegion = 0; i < 4; i++, yRegion -= 64, xRegion = 0) {


                    if (i == 0 || i == 2) {

                        animationTextureRegionTemp = new TextureRegion[10];
                        for (int j = 0; j < 10; xRegion += 80) {

                            animationTextureRegionTemp[j] = new TextureRegion(spellTexture, xRegion, yRegion, 128, 128);


                        }

                        spellAnimations.put(elem.path().split("/")[1], new Animation(0.025f, animationTextureRegionTemp));

                    } else {
                        animationTextureRegionTemp = new TextureRegion[7];
                        for (int j = 0; j < 7; xRegion += 80) {

                            animationTextureRegionTemp[j] = new TextureRegion(spellTexture, xRegion, yRegion, 128, 128);

                        }

                        spellAnimations.put(elem.path().split("/")[1], new Animation(0.025f, animationTextureRegionTemp));

                    }
                }


            } else {

                animationTextureRegionTemp = new TextureRegion[16];

                for (int i = 0, yRegion = 512, xRegion = 0; i < 4; i++, yRegion -= 128, xRegion = 0) {

                    for (int j = 0; j < 4; xRegion += 128) {

                        animationTextureRegionTemp[(i * 4) + j] = new TextureRegion(spellTexture, xRegion, yRegion, 128, 128);

                    }


                }

                spellAnimations.put(elem.path().split("/")[1], new Animation(0.025f, animationTextureRegionTemp));


            }


        }


    }

    public void castSpell(String key){
        String spell = spellBookModel.getSpellBook().get(key);
        Animation spellToCast = spellAnimations.get(spell);


    }


}

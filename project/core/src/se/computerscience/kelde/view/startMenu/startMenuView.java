package se.computerscience.kelde.view.startMenu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.g2d.Animation;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.MenuButton;


import java.text.DecimalFormat;
import java.util.*;


/**
 * Created by Daniel on 4/28/2015.
 */
public class StartMenuView {

    Game keldeGame;
    Stage menuStage;
    Texture walkingCharacterTexture;
    TextureAtlas walkingCharacterAtlas;
    Array<Sprite> walkingCharactersSprites;
    final int SPRITE_SHEET_SIZE = 42/3;
    List<Animation> allWalkingAnimations;
    List<Animation> introAnimationDemonAnimations;
    List<Animation> introWizardTalkAnimations;
    Map<String, Animation> mappedWizardTalkAnimation;
    TextureRegion currentFrame;
    float stateTime, introStateTime;
    float stateTimeDelta;
    boolean onlyDoOnce = true;
    boolean[] onlyDoOnceSequence = new boolean[]{true,true,true,true,true,true,true,true};
    int spreadsheetOffset = 138;
    int spriteSize = 136;
    Texture backgroundTexture, foregroundTexture, introBackgroundTexture1, introBackgroundTexture2;
    Texture introForegroundTexture, introBorderTexture;
    Sprite fadeScreenSprite;
    Sound backgroundSound;
    Music introMusic;
    MenuButton newGameButton, loadGameButton;
    int result;
    double startTime;
    double internalTimerFadeOut = 0;
    double internalTimerFadeIn = 0;
    float anim1StartTime, anim2StartTime;
    double introPassedTime;
    float fadeTimer;
    boolean startIntro = false;
    DecimalFormat df = new DecimalFormat("#.#");
    float newHeight;
    float newWidth;
    float newX;
    float newY;
    Texture[] introTextTextures = new Texture [5];
    float newXConstant = 0;
    float newYConstant = 0;
    float newHeightConstant;
    float newWidthConstant;
    private StartMenu startMenuModel;
    private SpriteBatch batch = new SpriteBatch();
    private OrthographicCamera cam2d;
    private final int[] orderOfCharacterWalk;
    private Table black;
    private boolean introStarted = false;


    public StartMenuView(StartMenu startMenuModel, Game g) {
        keldeGame = g;
        this.startMenuModel = startMenuModel;
        cam2d = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        allWalkingAnimations = new ArrayList<Animation>();
        introWizardTalkAnimations = new ArrayList<Animation>();
        introAnimationDemonAnimations = new ArrayList<Animation>();
        orderOfCharacterWalk = createRandomArray();
        backgroundTexture = new Texture(startMenuModel.getBackground());
        foregroundTexture = new Texture(startMenuModel.getForegorund());
        loadGameButton = new MenuButton(new Texture(startMenuModel.getBackground()), 750, 400,418,103);
        introBackgroundTexture1 = new Texture(startMenuModel.getIntroBackgroundImage());
        introBorderTexture = new Texture(startMenuModel.getIntroBorderImage());
        introForegroundTexture = new Texture(startMenuModel.getForegroundIntroImage());
        mappedWizardTalkAnimation = new HashMap<String, Animation>();
        fadeScreenSprite = new Sprite( new Texture(startMenuModel.getFadeScreen()));
        introBackgroundTexture2 = new Texture(startMenuModel.getCaveBackground());
        initIntro();
        menuStage = new Stage();

    }

    public void renderMenu(){
        if(result<=0 && !introStarted) {
            System.out.println(result);
            renderStartMenu();
        }
        else{
            introStarted = true;
            backgroundSound.dispose();
            introMusic.play();

            if(!startIntro) {
                startTime = System.currentTimeMillis();
                startIntro = true;

            }
            introPassedTime = System.currentTimeMillis() - startTime -1000;

            System.out.println("IntroPassedTime=" + introPassedTime);
            System.out.println(result);
            if(timeRange(introPassedTime,-1,0)) {
                renderStartMenu();
                batch.begin();
                fadeInScreen();
                batch.end();
            }

            else if(timeRange(introPassedTime,0,1)) {
                renderIntro();
                batch.begin();
              fadeOutScreen();
                batch.end();
            }
            else{
                renderIntro();
            }



        }
    }


    public void renderStartMenu() {
        stateTime += Gdx.graphics.getDeltaTime();

        GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(backgroundTexture, 0, 0);
        renderWalkSequenceRight();
        batch.draw(foregroundTexture, 0, 0);
        batch.end();

        result = loadGameButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY(), Gdx.input.isTouched());

       // if(!(result == 0)){



    }

    public void init() {

        backgroundSound= Gdx.audio.newSound(new FileHandle(startMenuModel.getBackgroundSoundPath()));

        walkingCharacterTexture = new Texture(startMenuModel.getWalkingCharacterPathPicture());


        for (int i = 0, x = 2, y = 2; i < SPRITE_SHEET_SIZE; i++) {
            TextureRegion[] tempAnimationRegions = new TextureRegion[3];
            if (x > 830) {
                x = 2;
                y += spreadsheetOffset;

            }
            tempAnimationRegions[0] = new TextureRegion(walkingCharacterTexture, x, y, spriteSize,spriteSize);

            x += spreadsheetOffset;

            if (x > 830) {
                x = 2;
                y += spreadsheetOffset;

            }
            tempAnimationRegions[1] =  new TextureRegion(walkingCharacterTexture, x, y, spriteSize,spriteSize);;

            x += spreadsheetOffset;

            if (x > 830) {
                x = 2;
                y += spreadsheetOffset;

            }
            tempAnimationRegions[2] =  new TextureRegion(walkingCharacterTexture, x, y, spriteSize,spriteSize);

            x += spreadsheetOffset;

            //Now that we have loaded an animation's textureRegions, we create an animation from it.
            // And then load it into our list of animations.
            allWalkingAnimations.add(new Animation(0.27f, tempAnimationRegions));


        }



        stateTime=0f;
        backgroundSound.loop();

    }

    public void initIntro(){
        introMusic = Gdx.audio.newMusic(new FileHandle(startMenuModel.getIntroSound()));

        String[] introTexts = startMenuModel.getIntroTextImages();
        for(int i = 0; i< introTexts.length; i++) {
            introTextTextures[i] = new Texture(introTexts[i]);
        }


    introStateTime = 0f;
        introPassedTime = -1f;

        //Phase one assets
        int[] wizardAnimationLengthData = startMenuModel.getWizardAnimationData();
        int[] wizardSpriteCoordinates = startMenuModel.getWizardTalkCoordinates();
        Texture wizardSpriteSheet = new Texture(startMenuModel.getIntroWizardTalkImage());
        wizardSpriteSheet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        int width = wizardSpriteCoordinates[0];
        int height = wizardSpriteCoordinates[1];

        for(int i = 0, k = 0; i<wizardAnimationLengthData.length; i++){
            TextureRegion[] tempTexRegArray = new TextureRegion[wizardAnimationLengthData[i]];
            for(int j = 0; j<wizardAnimationLengthData[i];j++, k+=2) {
                int x =  wizardSpriteCoordinates[k+2];
                int y = wizardSpriteCoordinates[k+ 3];
                TextureRegion tempRegion = new TextureRegion(wizardSpriteSheet, x, y, width, height);
                tempTexRegArray[j] = tempRegion;
            }
            introWizardTalkAnimations.add(new Animation(0.15f, tempTexRegArray));

        }

        String[] keyForAnimations = new String[]{"backwalk","walkforward", "wandlight" };

        for(int i = 0; i<introWizardTalkAnimations.size(); i++){

            mappedWizardTalkAnimation.put(keyForAnimations[i], introWizardTalkAnimations.get(i));

        }



    }

        public void renderIntro(){

            stateTime += Gdx.graphics.getDeltaTime();
            GL20 gl = Gdx.graphics.getGL20();
            gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            ///////////////////////////////////////////////////////
            // First part of the intro, not so much action only talk.
            ///////////////////////////////////////////////////////

            if(timeRange(introPassedTime, 0,40)) {


                batch.draw(introBackgroundTexture1, 0, 0);


                //
                // currentFrame = mappedWizardTalkAnimation.get("walkforward").getKeyFrame(stateTime,true);

                // Wizard starts to walk after 3 secons into the intro
                int currentSize = 0;
                drawWalkingWizard();
                drawIntroTexts();

                batch.draw(introForegroundTexture, 0, 0);
                if(timeRange(introPassedTime,39,40)) {
                    fadeInScreen();
                }



                //renderAnimationByIndex(mappedWizardTalkAnimation.get("walkforward").getKeyFrame(stateTime,true), 200,200,)




            }

              if(timeRange(introPassedTime,40,100)) {


                  batch.draw(introBackgroundTexture2,0,0);





                  if(timeRange(introPassedTime,39,40)) {
                      fadeOutScreen();
                  }



            }

            batch.draw(introBorderTexture, 0, 0);

            batch.end();

    }

   public boolean timeRange(double time, int x, int y){
       return ((time/1000) >= x) && ((time/1000) < y) ;

   }

    public void renderAnimationByIndex(List<Animation> theAnimation, int x, int y, int i) {


        currentFrame = theAnimation.get(i).getKeyFrame(stateTime, true);
        batch.draw(currentFrame, x + (stateTime) * 18, y);

    }

    public void renderWalkSequenceRight(){

        renderAnimationByIndex(allWalkingAnimations,-2400,130, orderOfCharacterWalk[0] );
        renderAnimationByIndex(allWalkingAnimations,-2100,130, orderOfCharacterWalk[1] );
        renderAnimationByIndex(allWalkingAnimations,-1800,130, orderOfCharacterWalk[2] );
        renderAnimationByIndex(allWalkingAnimations, -1500, 130, orderOfCharacterWalk[3]);
        renderAnimationByIndex(allWalkingAnimations, -1200, 130, orderOfCharacterWalk[4]);
        renderAnimationByIndex(allWalkingAnimations, -900, 130, orderOfCharacterWalk[5]);
        renderAnimationByIndex(allWalkingAnimations,-600,130, orderOfCharacterWalk[6] );
        renderAnimationByIndex(allWalkingAnimations,-300,130, orderOfCharacterWalk[7] );
        renderAnimationByIndex(allWalkingAnimations,0,130, orderOfCharacterWalk[8] );
        renderAnimationByIndex(allWalkingAnimations, 300, 130, orderOfCharacterWalk[9]);
        renderAnimationByIndex(allWalkingAnimations, 600, 130, orderOfCharacterWalk[10]);
        renderAnimationByIndex(allWalkingAnimations, 900, 130, orderOfCharacterWalk[11]);
        renderAnimationByIndex(allWalkingAnimations, 1200, 130, orderOfCharacterWalk[12]);
        renderAnimationByIndex(allWalkingAnimations, 1500, 130, orderOfCharacterWalk[13]);

    }



    public int[] createRandomArray(){

        Random ran = new Random();
        int[] tempRandomArray = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int index = 0;

        while(index < 14){

        int tempRandomNr = ran.nextInt(14);

            if(!contains(tempRandomArray,tempRandomNr)){

                tempRandomArray[index] = tempRandomNr;
                index++;

            }

        }

        return tempRandomArray;



    }

    public boolean contains(final int[] array, final int key) {
        int[] tempCopyArray = new int[14];
        System.arraycopy(array,0,tempCopyArray,0,array.length);
        Arrays.sort(tempCopyArray);
        int i = 0;
        while(i < tempCopyArray.length){
            if(tempCopyArray[i] == key){
                return true;
            }
            i++;

        }
        return false;
    }

    public void drawWalkingWizard(){


        if(timeRange(introPassedTime, 0,2)){

            currentFrame = mappedWizardTalkAnimation.get("walkforward").getKeyFrame(4, true);
            batch.draw(currentFrame, 1350,200);


        }
        if (timeRange(introPassedTime, 2,6)){
            newX =  1350+anim1StartTime*-120;
            newY =  200+anim1StartTime*-40;
            newHeight = Float.parseFloat((df.format(300+anim1StartTime*30)));
            newWidth = Float.parseFloat((df.format(300+anim1StartTime*30)));
            batch.draw(currentFrame,newX,newY ,newWidth, newHeight );
            currentFrame = mappedWizardTalkAnimation.get("walkforward").getKeyFrame(stateTime, true);
            // batch.draw(currentFrame, 1350+anim1StartTime*-60,200+anim1StartTime*4);
            anim1StartTime += Gdx.graphics.getDeltaTime();
        }

        if(timeRange(introPassedTime, 6,8) ){
            currentFrame = mappedWizardTalkAnimation.get("walkforward").getKeyFrame(4, true);
            batch.draw(currentFrame, newX,newY, newWidth, newHeight);

        }

        if(timeRange(introPassedTime, 8,33)) {


            currentFrame = mappedWizardTalkAnimation.get("wandlight").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, newX, newY, newWidth, newHeight);

        }



        if(timeRange(introPassedTime, 33,38)) {

            currentFrame = mappedWizardTalkAnimation.get("walkforward").getKeyFrame(4, true);
            batch.draw(currentFrame, newX,newY, newWidth, newHeight);


        }


        if(timeRange(introPassedTime, 38,50)) {
           if(onlyDoOnceSequence[4]) {
               anim1StartTime = 0; onlyDoOnceSequence[4] = false;
            newXConstant = newX; newYConstant = newY;
               newHeightConstant = newHeight; newWidthConstant = newWidth;

           }
            System.out.println(newXConstant + "|" +newYConstant+ "|" + newX+ "|" + newY);

            newX =  newXConstant+anim1StartTime*60;
            newY =  newYConstant+anim1StartTime*20;
            newHeight = Float.parseFloat((df.format(newHeightConstant+anim1StartTime*-15)));
            newWidth = Float.parseFloat(( df.format(newWidthConstant +anim1StartTime*-15)));
            batch.draw(currentFrame,newX,newY ,newWidth, newHeight );

            currentFrame = mappedWizardTalkAnimation.get("backwalk").getKeyFrame(stateTime, true);
            // batch.draw(currentFrame, 1350+anim1StartTime*-60,200+anim1StartTime*4);
            anim1StartTime += Gdx.graphics.getDeltaTime();

        }






    }

    public void drawIntroTexts(){


        if(timeRange(introPassedTime, 8,50)) {
            anim2StartTime += Gdx.graphics.getDeltaTime()*384;


            if(timeRange(introPassedTime, 8,13)){

                TextureRegion textToRender = new TextureRegion(introTextTextures[0],(int)(50+anim2StartTime),1080);
                batch.draw(textToRender, 0,0);
            }

            if(timeRange(introPassedTime, 13,18)){
                if(onlyDoOnceSequence[0]){anim2StartTime = 0;onlyDoOnceSequence[0] = false;}
                TextureRegion textToRender = new TextureRegion(introTextTextures[1],(int)(50+anim2StartTime),1080);
                batch.draw(introTextTextures[0], 0,0);
                batch.draw(textToRender, 0,0);

            }

            if(timeRange(introPassedTime, 18,23)){
                if(onlyDoOnceSequence[1]){anim2StartTime = 0; onlyDoOnceSequence[1] = false;}
                TextureRegion textToRender = new TextureRegion(introTextTextures[2],(int)(50+anim2StartTime),1080);
                batch.draw(introTextTextures[0], 0,0);
                batch.draw(introTextTextures[1], 0,0);
                batch.draw(textToRender, 0,0);


            }


            if(timeRange(introPassedTime, 23,28)){
                if(onlyDoOnceSequence[2]){anim2StartTime = 0; onlyDoOnceSequence[2] = false;}
                TextureRegion textToRender = new TextureRegion(introTextTextures[3],(int)(50+anim2StartTime),1080);
                batch.draw(introTextTextures[0], 0,0);
                batch.draw(introTextTextures[1], 0,0);
                batch.draw(introTextTextures[2], 0,0);
                batch.draw(textToRender, 0,0);
            }

            if(timeRange(introPassedTime, 28,31)){
                if(onlyDoOnceSequence[3]){anim2StartTime = 0; onlyDoOnceSequence[3] = false;}
                TextureRegion textToRender = new TextureRegion(introTextTextures[4],(int)(50+anim2StartTime),1080);
                batch.draw(introTextTextures[0], 0,0);
                batch.draw(introTextTextures[1], 0,0);
                batch.draw(introTextTextures[2], 0,0);
                batch.draw(introTextTextures[3], 0,0);
                batch.draw(textToRender, 0,0);
            }

            if(timeRange(introPassedTime, 31,40)){

                batch.draw(introTextTextures[0], 0,0);
                batch.draw(introTextTextures[1], 0,0);
                batch.draw(introTextTextures[2], 0,0);
                batch.draw(introTextTextures[3], 0,0);
                batch.draw(introTextTextures[4], 0,0);
            }

        }

    }


    public void fadeInScreen() {

        if(onlyDoOnceSequence[5]){
            internalTimerFadeIn = System.currentTimeMillis();
            onlyDoOnceSequence[5] = false;
        }

        double timeLapse = (System.currentTimeMillis() - internalTimerFadeIn) /1000;


        if (timeLapse < 1) {

            fadeScreenSprite.setAlpha((float) timeLapse);
            fadeScreenSprite.draw(batch);

        }
        else{
            onlyDoOnceSequence[6] = false;
        }
    }

        public void fadeOutScreen(){


           if( onlyDoOnceSequence[6]){
                internalTimerFadeOut = System.currentTimeMillis();
               onlyDoOnceSequence[6] = false;
            }
            double timeLapse = (System.currentTimeMillis() - internalTimerFadeOut) /1000;

            if ( timeLapse < 1) {

                fadeScreenSprite.setAlpha(1-(float)timeLapse);
                fadeScreenSprite.draw(batch);

            }
            else{
                onlyDoOnceSequence[6] = true;
            }
        }






    public Button[] getButton(){
        return new Button[]{newGameButton, loadGameButton};
     }


}



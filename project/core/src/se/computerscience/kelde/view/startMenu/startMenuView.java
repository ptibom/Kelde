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
    int[] animPathCordsX =  new int[]{740, 792, 816,871,921,985,1075,1161,1239,1276,1201,1114,1036,966,960,1100,1300,1400,1400,1400};
    int[] animPathInterpolatedX;
    int[] animPathCordsY =  new int[]{400,666, 699,747,783,814,831,810,852,801,745,700,658,582,490,418,440,500, 500,500};
    int[] animPathInterpolatedY;
    Stage menuStage;
    Texture walkingCharacterTexture;
    TextureAtlas walkingCharacterAtlas;
    Array<Sprite> walkingCharactersSprites;
    final int SPRITE_SHEET_SIZE = 42/3;
    List<Animation> allWalkingAnimations;
    List<Animation> introAnimationDemonAnimations;
    List<Animation> introAnimationSpellAnimations;
    List<Animation> introWizardTalkAnimations;
    Map<String, Animation> mappedWizardTalkAnimation;
    Map<String, Animation> mappedDemonTalkAnimation;
    Map<String, Animation> mappedSpellAnimation;
    TextureRegion currentFrame, currentFrame2, currentFrameDemon1,currentFrameDemon2;
    float stateTime, introStateTime;
    float stateTimeDelta;
    boolean onlyDoOnce = true;
    boolean[] onlyDoOnceSequence = new boolean[]{true,true,true,true,true,true,true,true,true,true,true, true,true};
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
    float anim1StartTime, anim2StartTime, anim3StartTime,anim3DeltaTime, Anim4StartTime;
    double introPassedTime;
    float fadeTimer;
    float offsetX =1285, offsetX2 =-200;
    float offsetY =580, offsetY2 = 90;
    float offsetX3 = 729, offsetY3 = 625;
    boolean startIntro = false;
    DecimalFormat df = new DecimalFormat("#.#");
    float newHeight, newHeight2 = 128;
    float newWidth, newWidth2 = 128;
    float newX;
    float newY;
    Texture[] introTextTextures = new Texture [8];
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
    String[] dialogues;
    Texture[] dialogueImages = new Texture[30];

    public StartMenuView(StartMenu startMenuModel, Game g) {
        keldeGame = g;
        this.startMenuModel = startMenuModel;
        cam2d = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        allWalkingAnimations = new ArrayList<Animation>();
        introWizardTalkAnimations = new ArrayList<Animation>();
        introAnimationDemonAnimations = new ArrayList<Animation>();
        introAnimationSpellAnimations  = new ArrayList<Animation>();
        orderOfCharacterWalk = createRandomArray();
        backgroundTexture = new Texture(startMenuModel.getBackground());
        foregroundTexture = new Texture(startMenuModel.getForegorund());
        loadGameButton = new MenuButton(new Texture(startMenuModel.getBackground()), 750, 400,418,103);
        introBackgroundTexture1 = new Texture(startMenuModel.getIntroBackgroundImage());
        introBorderTexture = new Texture(startMenuModel.getIntroBorderImage());
        introForegroundTexture = new Texture(startMenuModel.getForegroundIntroImage());
        mappedWizardTalkAnimation = new HashMap<String, Animation>();
        mappedDemonTalkAnimation = new HashMap<String, Animation>();
        mappedSpellAnimation = new HashMap<String, Animation>();
        fadeScreenSprite = new Sprite( new Texture(startMenuModel.getFadeScreen()));
        introBackgroundTexture2 = new Texture(startMenuModel.getCaveBackground());
        dialogues = startMenuModel.getDialogues();
        initIntro();
        menuStage = new Stage();
        animPathInterpolatedX = new int[animPathCordsX.length*4];
        animPathInterpolatedY = new int[animPathCordsY.length*4];
        for(int i = 0,  j = 0; j<animPathCordsX.length-1; i+=4, j++){

            double deltaX = animPathCordsX[j+1]-animPathCordsX[j];
            double deltaY = animPathCordsY[j+1]-animPathCordsY[j];
            animPathInterpolatedX[i] = animPathCordsX[j];
            animPathInterpolatedX[i+1] =(int)(animPathCordsX[j] + deltaX*0.25);
            animPathInterpolatedX[i+2] =(int)(animPathCordsX[j] + deltaX*0.50);
            animPathInterpolatedX[i+3] =(int)(animPathCordsX[j] + deltaX*0.75);
            animPathInterpolatedY[i] = animPathCordsY[j];
            animPathInterpolatedY[i+1] =(int)(animPathCordsY[j] + deltaY*0.25);
            animPathInterpolatedY[i+2] =(int)(animPathCordsY[j] + deltaY*0.50);
            animPathInterpolatedY[i+3] =(int)(animPathCordsY[j] + deltaY*0.75);
        }
        dialogues = startMenuModel.getDialogues();

    }

    public void renderMenu(){
        if(result<=0 && !introStarted) {

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
                if(onlyDoOnceSequence[7]){
                    onlyDoOnceSequence[5] = true;
                    onlyDoOnceSequence[6] = true;
                    onlyDoOnceSequence[7] = false;
                }
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

        for (int i = 0; i<dialogues.length; i++){

            dialogueImages[i] = new Texture(dialogues[i]);

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

        //Phase two assets

        int[] demonAndSecondWizardAnimationLengthData = startMenuModel.getDemonAnimationData();
        int[] demonSpriteCoordinates = startMenuModel.getIntroDemonCoordinates();
        Texture demonSpriteSheet = new Texture(startMenuModel.getDemonAnd2ndWizardImage());
        demonSpriteSheet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        int width2 = demonSpriteCoordinates[0];
        int height2 = demonSpriteCoordinates[1];

        for(int i = 0, k = 0; i<demonAndSecondWizardAnimationLengthData.length; i++){
            TextureRegion[] tempTexRegArray = new TextureRegion[demonAndSecondWizardAnimationLengthData[i]];
            for(int j = 0; j<demonAndSecondWizardAnimationLengthData[i];j++, k+=2) {
                int x =  demonSpriteCoordinates[k+2];
                int y = demonSpriteCoordinates[k+ 3];
                TextureRegion tempRegion = new TextureRegion(demonSpriteSheet, x, y, width2, height2);
                tempTexRegArray[j] = tempRegion;
            }
            introAnimationDemonAnimations.add(new Animation(0.15f, tempTexRegArray));

        }
        String[] keyForAnimations2 = new String[]{"demonspellhit","demonlaughleft", "demontalkleft","demonsideleft",
       "demonlaughright", "demontalkright","demonbreathe","demonwalk", "demonpoint", "wizardshoot",
                "wizardbehind", "wizardstandright", "wizardstandleft","wizardtalkleft", "wizardtalkright", "wizardwalk" };
        for(int i = 0; i<introAnimationDemonAnimations.size(); i++){
        mappedDemonTalkAnimation.put(keyForAnimations2[i], introAnimationDemonAnimations.get(i));
        }

        int[] spellAnimationLengthData = startMenuModel.getSpellAnimationLength();
        int[] spellSpriteCoordinaters = startMenuModel.getSpellIntroCoordinaters();

        Texture spellSprite = new Texture(startMenuModel.getSpellSpritePath());
        spellSprite.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        int width3 = spellSpriteCoordinaters[0];
        int height3 = spellSpriteCoordinaters[1];

        for(int i = 0, k = 0; i<spellAnimationLengthData.length; i++){
            TextureRegion[] tempTextRegArray = new TextureRegion[spellAnimationLengthData[i]];

            for(int j = 0; j<spellAnimationLengthData[i]; j++, k+=2){

                int x = spellSpriteCoordinaters[k+2];
                int y = spellSpriteCoordinaters[k+3];
                TextureRegion tempRegion = new TextureRegion(spellSprite, x,y,width3, height3);
                tempTextRegArray[j] = tempRegion;
            }
            introAnimationSpellAnimations.add(new Animation(0.15f, tempTextRegArray));

        }
        String[] keyForAnimations3 = new String[]{"start", "explosion", "loop"};
        for(int i = 0; i<introAnimationSpellAnimations.size(); i++){

            mappedSpellAnimation.put(keyForAnimations3[i], introAnimationSpellAnimations.get(i));
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

            if(timeRange(introPassedTime, 0,46)) {


                batch.draw(introBackgroundTexture1, 0, 0);


                //
                // currentFrame = mappedWizardTalkAnimation.get("walkforward").getKeyFrame(stateTime,true);

                // Wizard starts to walk after 3 secons into the intro
                int currentSize = 0;
                drawWalkingWizard();
                drawIntroTexts();

                batch.draw(introForegroundTexture, 0, 0);
                if(timeRange(introPassedTime,45,46)) {
                    fadeInScreen();
                }



                //renderAnimationByIndex(mappedWizardTalkAnimation.get("walkforward").getKeyFrame(stateTime,true), 200,200,)




            }

            if(timeRange(introPassedTime, 46,200)) {
                introPassedTime = System.currentTimeMillis() - startTime -47000;
                System.out.println(introPassedTime);
                drawDemonTalking();
                drawSecondTalkingWizard();
                batch.draw(introBorderTexture, 0, 0);

            }
            batch.end();

    }

   public boolean timeRange(double time, double x, double y){
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

        if(timeRange(introPassedTime, 8,40)) {


            currentFrame = mappedWizardTalkAnimation.get("wandlight").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, newX, newY, newWidth, newHeight);

        }



        if(timeRange(introPassedTime, 40,43)) {

            currentFrame = mappedWizardTalkAnimation.get("walkforward").getKeyFrame(4, true);
            batch.draw(currentFrame, newX,newY, newWidth, newHeight);


        }


        if(timeRange(introPassedTime, 43,50)) {
           if(onlyDoOnceSequence[4]) {
               anim1StartTime = 0; onlyDoOnceSequence[4] = false;
            newXConstant = newX; newYConstant = newY;
               newHeightConstant = newHeight; newWidthConstant = newWidth;

           }


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


            if(timeRange(introPassedTime, 8,12)){

                TextureRegion textToRender = new TextureRegion(introTextTextures[0],(int)(50+anim2StartTime),1080);
                batch.draw(textToRender, 0,0);
            }

            if(timeRange(introPassedTime, 12,16)){
                if(onlyDoOnceSequence[0]){anim2StartTime = 0;onlyDoOnceSequence[0] = false;}
                TextureRegion textToRender = new TextureRegion(introTextTextures[1],(int)(50+anim2StartTime),1080);
                batch.draw(introTextTextures[0], 0,0);
                batch.draw(textToRender, 0,0);

            }

            if(timeRange(introPassedTime, 16,20)){
                if(onlyDoOnceSequence[1]){anim2StartTime = 0; onlyDoOnceSequence[1] = false;}
                TextureRegion textToRender = new TextureRegion(introTextTextures[2],(int)(50+anim2StartTime),1080);
                batch.draw(introTextTextures[0], 0,0);
                batch.draw(introTextTextures[1], 0,0);
                batch.draw(textToRender, 0,0);


            }


            if(timeRange(introPassedTime, 20,24)){
                if(onlyDoOnceSequence[2]){anim2StartTime = 0; onlyDoOnceSequence[2] = false;}
                TextureRegion textToRender = new TextureRegion(introTextTextures[3],(int)(50+anim2StartTime),1080);
                batch.draw(introTextTextures[0], 0,0);
                batch.draw(introTextTextures[1], 0,0);
                batch.draw(introTextTextures[2], 0,0);
                batch.draw(textToRender, 0,0);
            }

            if(timeRange(introPassedTime, 24,28)){
                if(onlyDoOnceSequence[3]){anim2StartTime = 0; onlyDoOnceSequence[3] = false;}
                TextureRegion textToRender = new TextureRegion(introTextTextures[4],(int)(50+anim2StartTime),1080);
                batch.draw(introTextTextures[0], 0,0);
                batch.draw(introTextTextures[1], 0,0);
                batch.draw(introTextTextures[2], 0,0);
                batch.draw(introTextTextures[3], 0,0);
                batch.draw(textToRender, 0,0);
            }
            if(timeRange(introPassedTime, 28,32)){
                if(onlyDoOnceSequence[8]){anim2StartTime = 0; onlyDoOnceSequence[8] = false;}
                TextureRegion textToRender = new TextureRegion(introTextTextures[5],(int)(50+anim2StartTime),1080);
                batch.draw(introTextTextures[0], 0,0);
                batch.draw(introTextTextures[1], 0,0);
                batch.draw(introTextTextures[2], 0,0);
                batch.draw(introTextTextures[3], 0,0);
                batch.draw(introTextTextures[4], 0,0);
                batch.draw(textToRender, 0,0);
            }
            if(timeRange(introPassedTime, 32,36)){
                if(onlyDoOnceSequence[9]){anim2StartTime = 0; onlyDoOnceSequence[9] = false;}
                TextureRegion textToRender = new TextureRegion(introTextTextures[6],(int)(50+anim2StartTime),1080);
                batch.draw(introTextTextures[0], 0,0);
                batch.draw(introTextTextures[1], 0,0);
                batch.draw(introTextTextures[2], 0,0);
                batch.draw(introTextTextures[3], 0,0);
                batch.draw(introTextTextures[4], 0,0);
                batch.draw(introTextTextures[5], 0,0);
                batch.draw(textToRender, 0,0);
            }

            if(timeRange(introPassedTime, 36,40)){
                if(onlyDoOnceSequence[10]){anim2StartTime = 0; onlyDoOnceSequence[10] = false;}
                TextureRegion textToRender = new TextureRegion(introTextTextures[7],(int)(50+anim2StartTime),1080);
                batch.draw(introTextTextures[0], 0,0);
                batch.draw(introTextTextures[1], 0,0);
                batch.draw(introTextTextures[2], 0,0);
                batch.draw(introTextTextures[3], 0,0);
                batch.draw(introTextTextures[4], 0,0);
                batch.draw(introTextTextures[5], 0,0);
                batch.draw(introTextTextures[6], 0,0);
                batch.draw(textToRender, 0,0);
            }

            if(timeRange(introPassedTime, 40,50)){

                batch.draw(introTextTextures[0], 0,0);
                batch.draw(introTextTextures[1], 0,0);
                batch.draw(introTextTextures[2], 0,0);
                batch.draw(introTextTextures[3], 0,0);
                batch.draw(introTextTextures[4], 0,0);
                batch.draw(introTextTextures[5], 0,0);
                batch.draw(introTextTextures[6], 0,0);
                batch.draw(introTextTextures[7], 0,0);
            }

        }

    }


    public void drawDemonTalking(){
        ///////////////////////////////////////////////////////
        // Second part of intro, this is long, with lots of talk!!
        ///////////////////////////////////////////////////////

        //  if(timeRange(introPassedTime,47,100)) {
        if(timeRange(introPassedTime,0,140)) {

            batch.draw(introBackgroundTexture2, 0, 0);



            anim3DeltaTime = Gdx.graphics.getDeltaTime();
            anim3StartTime += Gdx.graphics.getDeltaTime();
            currentFrame = mappedDemonTalkAnimation.get("demonwalk").getKeyFrame(stateTime, true);




            if(timeRange(introPassedTime,2,3) || timeRange(introPassedTime,4,6)) {
                if(currentFrame.isFlipX()){
                    currentFrame.flip(true,false);
                }
                offsetX +=   anim3DeltaTime*70;
                offsetY -=   anim3DeltaTime*50;
                newHeight2 += anim3DeltaTime*55;
                newWidth2 += anim3DeltaTime*55;

                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);


            }
            if(timeRange(introPassedTime,3,4) || timeRange(introPassedTime,6,9)) {
                if(!currentFrame.isFlipX()){
                    currentFrame.flip(true,false);
                }
                offsetX -= anim3DeltaTime*80;
                offsetY -= anim3DeltaTime*45;
                newHeight2 += anim3DeltaTime*55;
                newWidth2 += anim3DeltaTime*55;

                batch.draw(currentFrame, offsetX, offsetY,  newWidth2, newHeight2);
            }




            if(timeRange(introPassedTime, 9,10)){

                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);
            }

            if(timeRange(introPassedTime, 10,12)){
                currentFrame = mappedDemonTalkAnimation.get("demontalkleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);
                batch.draw(dialogueImages[0], 0, 0);

            }

            if(timeRange(introPassedTime, 12,14)){
                currentFrame = mappedDemonTalkAnimation.get("demonlaughleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);

            }

            if(timeRange(introPassedTime, 14,17)){
                currentFrame = mappedDemonTalkAnimation.get("demontalkleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);
                batch.draw(dialogueImages[1], 0, 0);

            }


            if(timeRange(introPassedTime, 17,33)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);


               flipAndRender(batch, currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }

            if(timeRange(introPassedTime, 33,35)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);
                batch.draw(dialogueImages[4], 0, 0);

            }

            if(timeRange(introPassedTime, 35,36)){


                currentFrame = mappedDemonTalkAnimation.get("demonbreathe").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);

            }

            if(timeRange(introPassedTime, 36,38)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);
                batch.draw(dialogueImages[5], 0, 0);

            }

            if(timeRange(introPassedTime, 38,41)){


                currentFrame = mappedDemonTalkAnimation.get("demonbreathe").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);


            }

            if(timeRange(introPassedTime, 41,47)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);


            }

            if(timeRange(introPassedTime, 47,49)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);
                batch.draw(dialogueImages[8], 0, 0);

            }


            if(timeRange(introPassedTime, 49,50)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                flipAndRender(batch, currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);


            }

            if(timeRange(introPassedTime, 50,52)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);
                batch.draw(dialogueImages[9], 0, 0);

            }

            if(timeRange(introPassedTime, 52,53)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);


            }

            if(timeRange(introPassedTime, 53,55)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);
                batch.draw(dialogueImages[10], 0, 0);

            }

            if(timeRange(introPassedTime, 55,56)){


                currentFrame = mappedDemonTalkAnimation.get("demonspellhit").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);


            }

            if(timeRange(introPassedTime, 56,57)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);


            }
            if(timeRange(introPassedTime, 57,59)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);
                batch.draw(dialogueImages[11], 0, 0);

            }

            if(timeRange(introPassedTime, 59,60)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                flipAndRender(batch, currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);


            }
            if(timeRange(introPassedTime, 60,61.5)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);
                batch.draw(dialogueImages[12], 0, 0);

            }
            if(timeRange(introPassedTime, 61.5,62)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }
            if(timeRange(introPassedTime, 62,64)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw(currentFrame, offsetX, offsetY, newWidth2, newHeight2);
                batch.draw(dialogueImages[13], 0, 0);


            }
            if(timeRange(introPassedTime, 64,65)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);
                batch.draw(dialogueImages[14], 0, 0);
            }

            if(timeRange(introPassedTime, 65,66.5)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }
            if(timeRange(introPassedTime, 66.5,69)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);
                batch.draw(dialogueImages[15], 0, 0);

            }
            if(timeRange(introPassedTime, 69,69.5)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }
            if(timeRange(introPassedTime, 69.5,72)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);
                batch.draw(dialogueImages[16], 0, 0);

            }
            if(timeRange(introPassedTime, 72,72.5)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }
            if(timeRange(introPassedTime, 72.5,75)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);
                batch.draw(dialogueImages[17], 0, 0);

            }
            if(timeRange(introPassedTime, 75,75.5)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }
            if(timeRange(introPassedTime, 75.5,77.5)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);
                batch.draw(dialogueImages[18], 0, 0);

            }
            if(timeRange(introPassedTime, 77.5,78)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }
            if(timeRange(introPassedTime, 78,80)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);
                batch.draw(dialogueImages[19], 0, 0);

            }
            if(timeRange(introPassedTime, 80,81)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }
            if(timeRange(introPassedTime, 81,83)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);
                batch.draw(dialogueImages[20], 0, 0);

            }
            if(timeRange(introPassedTime, 83,84)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }

            if(timeRange(introPassedTime, 84,86)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);
                batch.draw(dialogueImages[21], 0, 0);

            }
            if(timeRange(introPassedTime, 86,94)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }
            if(timeRange(introPassedTime, 94,95)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);
                batch.draw(dialogueImages[25], 0, 0);

            }
            if(timeRange(introPassedTime, 95,140)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                flipAndRender(batch, currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }
            if(timeRange(introPassedTime, 99.5,103)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                flipAndRender(batch, currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }
            if(timeRange(introPassedTime,103,111)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                flipAndRender(batch, currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);

            }
            if(timeRange(introPassedTime, 111,114)){


                currentFrame = mappedDemonTalkAnimation.get("demontalkright").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);
                batch.draw(dialogueImages[29], 0, 0);

            }
            if(timeRange(introPassedTime, 114,140)){


                currentFrame = mappedDemonTalkAnimation.get("demonsideleft").getKeyFrame(stateTime, true);
                batch.draw( currentFrame, offsetX, offsetY, (int) newWidth2, (int) newHeight2);


            }



            if(timeRange(introPassedTime,0,1)) {
                fadeOutScreen();
            }



        }




    }

    public void drawSecondTalkingWizard(){
        anim3DeltaTime = Gdx.graphics.getDeltaTime();
        anim1StartTime += Gdx.graphics.getDeltaTime();


        //Walking in
        if(timeRange(introPassedTime, 17,22)){

            offsetX2 +=  anim3DeltaTime*120;
                    offsetY2 += anim3DeltaTime *2;
            currentFrame = mappedDemonTalkAnimation.get("wizardwalk").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, offsetX2, offsetY2 , 420, 420);

        }

        //Taking his time
        if(timeRange(introPassedTime, 22,24)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);

            //flipAndRender(batch, currentFrame, offsetX2, offsetY2 , 420, 420);
            batch.draw(currentFrame, offsetX2, offsetY2 , 420, 420);
        }

        //Talking:Dialogu3
        if(timeRange(introPassedTime, 24,26)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardtalkright").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, offsetX2, offsetY2 , 420, 420);
            batch.draw(dialogueImages[2], 0,0);

        }
        //Talking:Pauses
        if (timeRange(introPassedTime, 26,28)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);

            //flipAndRender(batch, currentFrame, offsetX2, offsetY2 , 420, 420);
            batch.draw(currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);
        }
        //Talking:Dialogue4
        if(timeRange(introPassedTime, 28,32)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardtalkright").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, offsetX2, offsetY2, 420, 420);
            batch.draw(dialogueImages[3], 0, 0);

        }
        //Talking:Pause
        if(timeRange(introPassedTime, 32,39)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);


        }

        if (timeRange(introPassedTime, 39,43)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardtalkright").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);
            batch.draw(dialogueImages[6], 0, 0);

        }

        if(timeRange(introPassedTime, 43,44)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);


        }
        if (timeRange(introPassedTime, 44,46)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardtalkright").getKeyFrame(stateTime, true);
            flipAndRender(batch,currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);
            batch.draw(dialogueImages[7], 0, 0);

        }

        if(timeRange(introPassedTime, 46,51)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);


        }

        if (timeRange(introPassedTime, 51, 52)) {
            mappedDemonTalkAnimation.get("wizardshoot").setFrameDuration(1f);
            currentFrame = mappedDemonTalkAnimation.get("wizardshoot").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);

        }

        if(timeRange(introPassedTime, 51.5, 52)) {
            double timePassed = introPassedTime/1000-51.5;
            float interPolX = (float)(animPathInterpolatedX[(int)(timePassed*24)] );
            float interPolY  = (float)(animPathInterpolatedY[(int)(timePassed * 24)]);
            System.out.println(animPathInterpolatedX[(int) (timePassed * 13)]);
            currentFrame = mappedSpellAnimation.get("start").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, interPolX, interPolY, 100, 100);


        }
        if(timeRange(introPassedTime,52,54.5)) {
            double timePassed = introPassedTime/1000-51.5;
            float interPolX = (float) (animPathInterpolatedX[(int) (timePassed * 24)]);
            float interPolY = (float)(animPathInterpolatedY[(int)(timePassed*24)] );
            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);

            currentFrame = mappedSpellAnimation.get("loop").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, interPolX, interPolY, 100, 100);
        }

        if(timeRange(introPassedTime, 54.5,55)) {

            mappedDemonTalkAnimation.get("wizardstandleft").setFrameDuration(0.5f);
            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);
        }
        if(timeRange(introPassedTime, 55,86)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);


        }
        if (timeRange(introPassedTime, 86,88)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardtalkright").getKeyFrame(stateTime, true);
            flipAndRender(batch,currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);
            batch.draw(dialogueImages[22], 0, 0);

        }

        if(timeRange(introPassedTime, 88,89)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);


        }
        if (timeRange(introPassedTime, 89,91)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardtalkright").getKeyFrame(stateTime, true);
            flipAndRender(batch,currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);
            batch.draw(dialogueImages[23], 0, 0);

        }

        if(timeRange(introPassedTime, 91,92)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);


        }

        if (timeRange(introPassedTime, 92,94)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardtalkright").getKeyFrame(stateTime, true);
            flipAndRender(batch,currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);
            batch.draw(dialogueImages[24], 0, 0);

        }

        if(timeRange(introPassedTime, 94,96)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);


        }

        if (timeRange(introPassedTime, 96, 97)) {
            mappedDemonTalkAnimation.get("wizardshoot").setFrameDuration(1f);
            currentFrame = mappedDemonTalkAnimation.get("wizardshoot").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);

        }

        if(timeRange(introPassedTime, 96.5, 97)) {
            double timePassed = introPassedTime/1000-96.5;
            float interPolX = (float)(animPathInterpolatedX[(int)(timePassed*24)] );
            float interPolY  = (float)(animPathInterpolatedY[(int)(timePassed * 24)]);
            System.out.println(animPathInterpolatedX[(int) (timePassed * 13)]);
            currentFrame = mappedSpellAnimation.get("start").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, interPolX, interPolY, 100, 100);


        }
        if(timeRange(introPassedTime,97,99.5)) {
            double timePassed = introPassedTime/1000-96.5;
            float interPolX = (float) (animPathInterpolatedX[(int) (timePassed * 24)]);
            float interPolY = (float)(animPathInterpolatedY[(int)(timePassed*24)] );
            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);

            currentFrame = mappedSpellAnimation.get("loop").getKeyFrame(stateTime, true);
            batch.draw(currentFrame, interPolX, interPolY, 100, 100);
        }

        if(timeRange(introPassedTime, 99.5,103)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);


        }
        if(timeRange(introPassedTime, 103,104.5)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardtalkright").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);
            batch.draw(dialogueImages[26], 0, 0);


        }
        if(timeRange(introPassedTime, 104.5,106)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);


        }
        if(timeRange(introPassedTime, 106,108)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardtalkright").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);
            batch.draw(dialogueImages[27], 0, 0);


        }
        if(timeRange(introPassedTime, 108,109)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardstandleft").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);


        }
        if(timeRange(introPassedTime, 109,111)) {

            currentFrame = mappedDemonTalkAnimation.get("wizardtalkright").getKeyFrame(stateTime, true);
            flipAndRender(batch, currentFrame, offsetX2, offsetY2, (int) 420, (int) 420);
            batch.draw(dialogueImages[28], 0, 0);


        }
        if(timeRange(introPassedTime, 111,116)) {

            offsetX2 +=  anim3DeltaTime*-120;
            offsetY2 += anim3DeltaTime *-2;
            currentFrame = mappedDemonTalkAnimation.get("wizardwalk").getKeyFrame(stateTime, true);
            flipAndRender(batch,currentFrame, offsetX2, offsetY2 , 420, 420);


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
        }


    public void flipAndRender(SpriteBatch batch,TextureRegion texReg, float x, float y, int z, int v ){

            if(!currentFrame.isFlipX()) {
                currentFrame.flip(true, false);
            }
            batch.draw(currentFrame, x, y , z, v);
            if(currentFrame.isFlipX()){

                currentFrame.flip(true, false);
            }


    }




    public Button[] getButton(){
        return new Button[]{newGameButton, loadGameButton};
     }


}



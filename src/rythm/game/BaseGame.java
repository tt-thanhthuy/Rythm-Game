/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rythm.game;

import com.badlogic.gdx.Game;

/**
 *
 * @author ASUS
 */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class BaseGame extends Game{
    
    private static BaseGame game;
    
    public static LabelStyle labelStyle;
    public static TextButtonStyle textButtonStyle;
    
    public  BaseGame()
    {
        game = this;
    }
    public void create(){
        InputMultiplexer im = new InputMultiplexer();
        Gdx.input.setInputProcessor(im);
        
        FreeTypeFontGenerator fontGenerator = 
            new FreeTypeFontGenerator(Gdx.files.internal("assets/Kirsty.ttf"));
        FreeTypeFontParameter fontParameters = new FreeTypeFontParameter();
        fontParameters.size = 32;
        fontParameters.color = Color.WHITE;
        fontParameters.borderWidth = 2;
        fontParameters.borderColor = Color.BLACK;
        fontParameters.borderStraight = true;
        fontParameters.minFilter = TextureFilter.Linear;
        fontParameters.magFilter = TextureFilter.Linear;
        
        BitmapFont customFont = fontGenerator.generateFont(fontParameters);

        labelStyle = new LabelStyle();
        labelStyle.font = customFont;
        
        textButtonStyle = new TextButtonStyle();
        
        Texture   buttonTex   = new Texture( Gdx.files.internal("assets/button.png") );
        NinePatch buttonPatch = new NinePatch(buttonTex, 24,24,24,24);
        textButtonStyle.up    = new NinePatchDrawable( buttonPatch );
        textButtonStyle.font      = customFont;
        textButtonStyle.fontColor = Color.GRAY;
    }
    
    public static void setActiveScreen(BaseScreen s)
    {
        game.setScreen(s);
    }
}

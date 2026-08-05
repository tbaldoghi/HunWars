package com.elixir.hunwars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.elixir.hunwars.screens.MainMenuScreen;
import com.elixir.hunwars.utils.FontGenerator;

public class Main extends Game {
	public ScreenViewport viewport;
	private Stage stage;
	private MainMenuScreen mainMenuScreen;

    @Override
    public void create() {
    	viewport = new ScreenViewport();
    	stage = new Stage(viewport);
    	mainMenuScreen = new MainMenuScreen(this);
    	
    	// ---
    	
		LabelStyle labelStyle = new LabelStyle();
		FontGenerator fontGenerator = new FontGenerator();
		BitmapFont font;
		
		font = fontGenerator.getTextFont();
		
		labelStyle.font = font;
		
		fontGenerator.dispose();
		
		Styles.textLabelStyle = labelStyle;
		
		// ---
    	
    	setScreen(mainMenuScreen);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
	public void resize(int width, int height) {
    	stage.getViewport().update(width, height, true);
	}

	@Override
    public void dispose() {
		stage.dispose();
		mainMenuScreen.dispose();
    }
}

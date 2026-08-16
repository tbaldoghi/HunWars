package com.elixir.hunwars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.elixir.hunwars.screens.MainMenuScreen;

public class Main extends Game {
	public ScreenViewport viewport;
	private Stage stage;
	private MainMenuScreen mainMenuScreen;

    @Override
    public void create() {
    	viewport = new ScreenViewport();
    	stage = new Stage(viewport);
    	mainMenuScreen = new MainMenuScreen(this);

    	Styles.getInstance();
    	setScreen(mainMenuScreen);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
	public void resize(int width, int height) {
    	super.resize(width, height);
    	// stage.getViewport().update(width, height, true);
	}

	@Override
    public void dispose() {
		stage.dispose();
		mainMenuScreen.dispose();
    }
}

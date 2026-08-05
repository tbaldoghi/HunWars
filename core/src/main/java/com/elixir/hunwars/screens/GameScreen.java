package com.elixir.hunwars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.Main;
import com.elixir.hunwars.ui.GameViewTable;
import com.elixir.hunwars.ui.SideMenuTable;

public class GameScreen implements Screen {
	private final Main game;
	private GameState gameState;
	private Stage stage;
	private Table containerTable;
	private GameViewTable gameViewTable;
	private SideMenuTable sideMenuTable;
	
	public GameScreen(Main game) {
		this.game = game;
	}

	@Override
	public void show() {
		gameState = new GameState();
		stage = new Stage(game.viewport);
		containerTable = new Table();
		gameViewTable = new GameViewTable(gameState, stage);
		sideMenuTable = new SideMenuTable(gameState, gameViewTable);
		
		Gdx.input.setInputProcessor(stage);
		
		containerTable.setFillParent(true);
		containerTable.add(gameViewTable).expand().fill();
		containerTable.add(sideMenuTable).width(260).top();
		stage.addActor(containerTable);
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(new Color(0.89f, 0.78f, 0.61f, 1f));
		stage.act(delta);
		stage.draw();
		// stage.setDebugAll(true);
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		stage.dispose();
	}	
}

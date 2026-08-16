package com.elixir.hunwars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
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
	private SpriteBatch spriteBatch;
	private Table containerTable;
	private GameViewTable gameViewTable;
	private Table leftImageTable;
	private SideMenuTable sideMenuTable;
	private Texture leftSideImageTexture;
	private Texture backgroundTexture;
	private Texture menuBackgroundTexture;
	private int bgWidth = 1920;
	private int bgHeight = 1080;
	
	public GameScreen(Main game) {
		this.game = game;
	}

	@Override
	public void show() {
		gameState = new GameState();
		stage = new Stage(game.viewport);
		spriteBatch = new SpriteBatch();
		containerTable = new Table();
		gameViewTable = new GameViewTable(gameState, stage);
		leftImageTable = new Table();
		sideMenuTable = new SideMenuTable(gameState, gameViewTable);
		
		Gdx.input.setInputProcessor(stage);
		
		leftSideImageTexture = new Texture(Gdx.files.local("images/agriculture.png"));
		backgroundTexture = new Texture(Gdx.files.local("images/background.jpg"));
		menuBackgroundTexture = new Texture(Gdx.files.local("images/menu_background.png"));
		
		containerTable.setFillParent(true);
		// containerTable.add(leftImageTable).width(400);
		
		containerTable.add(gameViewTable).grow();
		containerTable.add(sideMenuTable).width(500).minWidth(500).top();

		stage.addActor(containerTable);
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(new Color(0.89f, 0.78f, 0.61f, 1f));
		spriteBatch.begin();
		spriteBatch.setProjectionMatrix(stage.getCamera().combined);
		//System.out.println(bgWidth);
		//System.out.println(bgHeight);
		spriteBatch.draw(backgroundTexture, 0, 0, 1920, bgHeight);
		
		spriteBatch.draw(menuBackgroundTexture, bgWidth - 506, 0, 506, bgHeight);
		//spriteBatch.draw(leftSideImageTexture, 0, 0, 506, 375);
		spriteBatch.end();

		stage.act(delta);
		stage.draw();
		// stage.setDebugAll(true);
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		bgWidth = Gdx.graphics.getWidth();
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

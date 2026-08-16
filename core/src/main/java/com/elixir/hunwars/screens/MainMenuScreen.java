package com.elixir.hunwars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.Hinting;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton.ImageTextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.elixir.hunwars.Main;
import com.elixir.hunwars.Styles;
import com.elixir.hunwars.ui.Button;
import com.elixir.hunwars.ui.Text;
import com.elixir.hunwars.utils.FontGenerator;

public class MainMenuScreen implements Screen {
	private final Main game;
	private Stage stage;
	private SpriteBatch spriteBatch;
	private GameScreen gameScreen;
	private FontGenerator fontGenerator;
	private Table containerTable;
	private Text titleText;
	private Label textLabel;
	private Button newGameButton;
	private Button quitButton;
	private Texture backgroundTexture;

	public MainMenuScreen(Main game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		stage = new Stage(game.viewport);
		spriteBatch = new SpriteBatch();
		gameScreen = new GameScreen(game);
		containerTable = new Table();

		Gdx.input.setInputProcessor(stage);
		
		titleText = new Text("Hun Wars", true);
		textLabel = new Text("long text here\nSome more text here.\nA I i II i l L");
		newGameButton = new Button("New Game");
		quitButton = new Button("Quit");
		
		newGameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(gameScreen);
			}
		});
		
		quitButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		
		containerTable.setFillParent(true);
		containerTable.add(titleText).expandX().fillX().pad(24);
		containerTable.row();
		containerTable.row();
		containerTable.add(newGameButton);
		containerTable.row();
		containerTable.add(quitButton);
		
		stage.addActor(containerTable);
		
		backgroundTexture = new Texture(Gdx.files.internal("images/paper_background.png"));
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(new Color(0.89f, 0.78f, 0.61f, 1f));
		spriteBatch.begin();
		spriteBatch.setProjectionMatrix(stage.getCamera().combined);
		//spriteBatch.draw(backgroundTexture, 250, 100);
		//spriteBatch.draw(backgroundTexture, 750, 100);
		spriteBatch.end();
		stage.act(delta);
		//stage.setDebugAll(true);
		stage.draw();
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
		stage.dispose();
	}

	@Override
	public void dispose() {
		// stage.dispose();
	}
}

package com.elixir.hunwars.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.GameState.GameView;

public class SideMenuTable extends Table {
	private GameState gameState;
	private GameViewTable gameViewTable;
	private final GameView[] gameViews = {
		GameView.Overview,
		GameView.Agriculture,
		GameView.Workers,
		GameView.Buildings,
		GameView.Armies,
		GameView.Trade,
		GameView.Map,
		GameView.Diplomacy,
		GameView.Religion,
		GameView.War
	};
	private Button[] buttons = new Button[gameViews.length];

	public SideMenuTable(GameState gameState, GameViewTable gameViewTable) {
		this.gameState = gameState;
		this.gameViewTable = gameViewTable;

		addTableElements();
	}
	
	private void addTableElements() {
		Text seasonText = new Text("Season: Spring");

		add(seasonText).colspan(2).pad(24);
		row();
		
		/*Button overviewButton = new Button(GameView.Overview.name(), true);
		Button agricultureButton = new Button(GameView.Agriculture.name(), true);
		Button workersButton = new Button(GameView.Workers.name(), true);
		Button armiesButton = new Button(GameView.Armies.name(), true);
		Button buildingsButton = new Button(GameView.Buildings.name(), true);
		Button tradeButton = new Button(GameView.Trade.name(), true);
		Button diplomacyButton = new Button(GameView.Diplomacy.name(), true);
		Button warButton = new Button(GameView.War.name(), true);
		
		add(overviewButton).colspan(2).pad(2);
		row();
		add(agricultureButton).colspan(2).pad(2);
		row();
		add(workersButton).pad(2);
		add(tradeButton).pad(2);
		row();
		add(armiesButton).pad(2);
		add(diplomacyButton).pad(2);
		row();
		add(buildingsButton).pad(2);
		add(warButton).pad(2);
		row();*/
		
		for (int i = 0; i < gameViews.length; i++) {
			GameView gameView = gameViews[i];
			buttons[i] = new Button(gameView.name(), true);

			buttons[i].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					gameState.setCurrentGameView(gameView);
					gameViewTable.updateGameView();
				}
			});
			
			Table rowTable = new Table();
			ImageButtonStyle buttonStyle = new ImageButtonStyle();
			
			Texture texture = new Texture(Gdx.files.internal("images/production_button.png"));
			Texture textureDown = new Texture(Gdx.files.internal("images/production_button.png"));
			Sprite sprite = new Sprite(texture);
			Sprite spriteDown = new Sprite(textureDown);
			buttonStyle.up = new SpriteDrawable(sprite);
			buttonStyle.down = new SpriteDrawable(spriteDown);
			ImageButton productionButton = new ImageButton(buttonStyle);
			
			ImageButtonStyle infoButtonStyle = new ImageButtonStyle();
			
			Texture infoTexture = new Texture(Gdx.files.internal("images/info_button.png"));
			Texture infoTtextureDown = new Texture(Gdx.files.internal("images/info_button.png"));
			Sprite infoSprite = new Sprite(infoTexture);
			Sprite infoSpriteDown = new Sprite(infoTtextureDown);
			infoButtonStyle.up = new SpriteDrawable(infoSprite);
			infoButtonStyle.down = new SpriteDrawable(infoSpriteDown);
			ImageButton infoButton = new ImageButton(infoButtonStyle);
			
			ImageButtonStyle storageButtonStyle = new ImageButtonStyle();
			
			Texture storageTexture = new Texture(Gdx.files.internal("images/storage_button.png"));
			Texture storageTextureDown = new Texture(Gdx.files.internal("images/storage_button.png"));
			Sprite storageSprite = new Sprite(storageTexture);
			Sprite storageSpriteDown = new Sprite(storageTextureDown);
			storageButtonStyle.up = new SpriteDrawable(storageSprite);
			storageButtonStyle.down = new SpriteDrawable(storageSpriteDown);
			ImageButton storageButton = new ImageButton(storageButtonStyle);
			
			ImageButtonStyle foodButtonStyle = new ImageButtonStyle();
			
			Texture foodTexture = new Texture(Gdx.files.internal("images/food_button.png"));
			Texture foodTextureDown = new Texture(Gdx.files.internal("images/food_button.png"));
			Sprite foodSprite = new Sprite(foodTexture);
			Sprite foodSpriteDown = new Sprite(foodTextureDown);
			foodButtonStyle.up = new SpriteDrawable(foodSprite);
			foodButtonStyle.down = new SpriteDrawable(foodSpriteDown);
			ImageButton foodButton = new ImageButton(foodButtonStyle);
			
			ImageButtonStyle researchButtonStyle = new ImageButtonStyle();
			
			Texture researchTexture = new Texture(Gdx.files.internal("images/research_button.png"));
			Texture researchTextureDown = new Texture(Gdx.files.internal("images/research_button.png"));
			Sprite researchSprite = new Sprite(researchTexture);
			Sprite researchSpriteDown = new Sprite(researchTextureDown);
			researchButtonStyle.up = new SpriteDrawable(researchSprite);
			researchButtonStyle.down = new SpriteDrawable(researchSpriteDown);
			ImageButton researchButton = new ImageButton(researchButtonStyle);
			
			ImageButtonStyle raidButtonStyle = new ImageButtonStyle();
			
			Texture raidTexture = new Texture(Gdx.files.internal("images/raid_button.png"));
			Texture raidTextureDown = new Texture(Gdx.files.internal("images/raid_button.png"));
			Sprite raidSprite = new Sprite(raidTexture);
			Sprite raidSpriteDown = new Sprite(raidTextureDown);
			raidButtonStyle.up = new SpriteDrawable(raidSprite);
			raidButtonStyle.down = new SpriteDrawable(raidSpriteDown);
			ImageButton raidButton = new ImageButton(raidButtonStyle);

			rowTable.add(buttons[i]).pad(2);

			if (i == 8) {
				rowTable.add(researchButton).padRight(4);;
			}
			
			if (i == 0 || i == 3 || i == 4 || i == 8) {
				rowTable.add(productionButton).padRight(6);
			}
			
			if (i == 1) {
				rowTable.add(foodButton).padRight(4);
			}
			
			if (i == 5) {
				rowTable.add(storageButton).padRight(6);
			}
			
			if (i == 9) {
				rowTable.add(raidButton).padRight(4);
			}

			rowTable.add(infoButton).padRight(4);
			
			add(rowTable);
			row();
			/*if (i % 2 != 0) {
				row();
			}*/
			
		}
		
		Button nextTurnButton = new Button("Next Turn", true);
		
		add(nextTurnButton).colspan(2).padTop(32);
	}
}

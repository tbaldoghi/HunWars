package com.elixir.hunwars.ui.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.utils.Align;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.entities.BuildingData;
import com.elixir.hunwars.entities.LandType;
import com.elixir.hunwars.ui.Button;
import com.elixir.hunwars.ui.Text;
import com.elixir.hunwars.utils.FontGenerator;

public class BuildingsViewTable extends Table {
	private GameState gameState;
	private Stage stage;
	
	public BuildingsViewTable(GameState gameState, Stage stage) {
		super();
		
		this.gameState = gameState;
		this.stage = stage;

		addTableElements();
	}

	private void addTableElements() {
		Text nameText = new Text("Name");
		Text haveText = new Text("Have");
		Text percentageText = new Text("%");
		Text inProgressText = new Text("In progress");
		FontGenerator fontGenerator = new FontGenerator();
		TextFieldStyle textFieldStyle = new TextFieldStyle();
		BitmapFont font = fontGenerator.getTextFont();
		WindowStyle dialogStyle =  new WindowStyle();
		dialogStyle.titleFont = font;
		
		textFieldStyle.font = font;
		textFieldStyle.fontColor = Color.WHITE;

		add(nameText);
		add(haveText);
		add(percentageText);
		add(inProgressText);
		row();

		Text emptyLandsText = new Text("Empty lands");
		Text emptyLandsValueText = new Text(Integer.toString(gameState.getPlayerGameData().getLand().getLandCount(LandType.FIELD)));
		int emptyLandsPercentage = Math.round(gameState.getPlayerGameData().getLand().getLandCount(LandType.FIELD) / (float)gameState.getPlayerGameData().getLand().getTotalLandCount() * 100);
		Text emptyLandsPercentageText = new Text(emptyLandsPercentage + "%");
		emptyLandsText.setAlignment(Align.left);
		add(emptyLandsText).padLeft(60).expandX().fillX();
		add(emptyLandsValueText);
		add(emptyLandsPercentageText);
		row();

		for (BuildingData building : gameState.getPlayerGameData().getBuilding().getBuildings()) {
			Button buildingNameText = new Button(building.getName());
			Text qText = new Text(Integer.toString(building.getHave()));
			Text pText = new Text("4%");
			Text ipText = new Text("2");

			buildingNameText.left();

			add(buildingNameText).padLeft(60).expandX().fillX();
			add(qText);
			add(pText);
			add(ipText);
			row();
		}
	}
}

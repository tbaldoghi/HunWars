package com.elixir.hunwars.ui.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.utils.Align;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.entities.Building;
import com.elixir.hunwars.entities.BuildingData;
import com.elixir.hunwars.entities.BuildingType;
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
		Text nameHeaderText = new Text("Name");
		Text haveHeaderText = new Text("Have");
		Text percentageHeaderText = new Text("%");
		Text inProgressHeaderText = new Text("In progress");
		FontGenerator fontGenerator = new FontGenerator();
		TextFieldStyle textFieldStyle = new TextFieldStyle();
		BitmapFont font = fontGenerator.getTextFont();
		WindowStyle dialogStyle =  new WindowStyle();
		dialogStyle.titleFont = font;
		
		textFieldStyle.font = font;
		textFieldStyle.fontColor = Color.WHITE;

		add(nameHeaderText);
		add(haveHeaderText);
		add(percentageHeaderText);
		add(inProgressHeaderText);
		row();

		Text emptyLandsText = new Text("Field");
		Text emptyLandsValueText = new Text(gameState.getPlayerGameData().getLand().getLandCount(LandType.FIELD));
		int emptyLandsPercentage = Math.round(gameState.getPlayerGameData().getLand().getLandCount(LandType.FIELD) / (float)gameState.getPlayerGameData().getLand().getTotalLandCount() * 100);
		Text emptyLandsPercentageText = new Text(emptyLandsPercentage + "%");

		add(emptyLandsText).padLeft(60).expandX().fillX();
		add(emptyLandsValueText);
		add(emptyLandsPercentageText);
		row();

		Building building = gameState.getPlayerGameData().getBuilding();
		int totalLAndCount = gameState.getPlayerGameData().getLand().getTotalLandCount();

		for (BuildingData buildingData : building.getBuildings()) {
			BuildingType buildingType = buildingData.getType();
			Button buildingNameText = new Button(buildingData.getName());
			Text haveText = new Text(buildingData.getHave());
			Text percentageText = new Text(building.getPercentage(buildingType, totalLAndCount) + "%");
			Text inProgressText = new Text(building.getTotalInProgressCount(buildingType));

			buildingNameText.left();

			add(buildingNameText).padLeft(60).expandX().fillX();
			add(haveText);
			add(percentageText);
			add(inProgressText);
			row();
		}
	}
}

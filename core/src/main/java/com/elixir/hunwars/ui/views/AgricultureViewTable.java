package com.elixir.hunwars.ui.views;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.entities.Herd;
import com.elixir.hunwars.entities.HerdData;
import com.elixir.hunwars.entities.Land;
import com.elixir.hunwars.entities.LandType;
import com.elixir.hunwars.ui.Button;
import com.elixir.hunwars.ui.Text;

public class AgricultureViewTable extends Table {
	private GameState gameState;
	
	public AgricultureViewTable(GameState gameState) {
		super();
		
		this.gameState = gameState;

		addTableElements();
	}

	private void addTableElements() {
		Land land = gameState.getPlayerGameData().getLand();
		Herd herd = gameState.getPlayerGameData().getHerd();
		
		SliderStyle sliderStyle = new SliderStyle();
		Skin defaultSkin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		Text landsText = new Text("Lands", true);
		Text forestText = new Text("Forests");
		Text forestValueText = new Text(Integer.toString(land.getLandCount(LandType.FOREST)));
		Button forestClearButton = new Button("Clear");
		Text wildernessText = new Text("Wilderness");
		Text wildernessValueText = new Text(Integer.toString(land.getLandCount(LandType.WILDERNESS)));
		Button clearButton = new Button("Clear");
		Text emptyLandText = new Text("Fields");
		Text emptyLandValueText = new Text(Integer.toString(land.getLandCount(LandType.FIELD)));
		Text marshText = new Text("Marshes");
		Text marshValueText = new Text(Integer.toString(land.getLandCount(LandType.MARSH)));
		Text riverText = new Text("Rivers");
		Text riverValueText = new Text(Integer.toString(land.getLandCount(LandType.RIVER)));
		Text husbandryText = new Text("Husbandry", true);
		Text husbandryValueText = new Text("80");
		Text pastureText = new Text("Pasture");
		Text pastureValueText = new Text("60");
		Slider pastureSlider = new Slider(0, 100, 1, false, defaultSkin);
		Text arableLandText = new Text("Arable land");
		Text arableLandValueText = new Text("20");
		Slider arableLandSlider = new Slider(0, 100, 1, false, defaultSkin);
		Table husbandryTable = new Table();
		Text herdsText = new Text("Herds", true);
		
		pastureText.setAlignment(Align.left);
		
		add(landsText);
		row();
		add(forestText);
		add(forestValueText);
		add(forestClearButton);
		row();
		add(wildernessText);
		add(wildernessValueText).padLeft(24).padRight(24);
		add(clearButton);
		row();
		add(emptyLandText);
		add(emptyLandValueText);
		row();
		add(marshText);
		add(marshValueText);
		row();
		add(riverText);
		add(riverValueText);
		row();
		add(husbandryText);
		add(husbandryValueText);
		row();
		husbandryTable.add(pastureText).padRight(12);
		husbandryTable.add(pastureValueText).padRight(12);
		husbandryTable.add(pastureSlider);
		husbandryTable.add(arableLandValueText).padLeft(12);
		husbandryTable.add(arableLandText).padLeft(12);
		add(husbandryTable);
		row();
		add(herdsText);
		row();

		for (HerdData herdData : herd.getHerds()) {
			Text herdText = new Text(herdData.getName());
			Text herdValueText = new Text(Integer.toString(herdData.getHave()));
			
			add(herdText);
			add(herdValueText);
			row();
		}
	}
}

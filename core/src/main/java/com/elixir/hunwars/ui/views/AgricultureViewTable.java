package com.elixir.hunwars.ui.views;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.entities.Building;
import com.elixir.hunwars.entities.BuildingType;
import com.elixir.hunwars.entities.Herd;
import com.elixir.hunwars.entities.HerdData;
import com.elixir.hunwars.entities.Land;
import com.elixir.hunwars.entities.LandType;
import com.elixir.hunwars.ui.Button;
import com.elixir.hunwars.ui.Modal;
import com.elixir.hunwars.ui.Text;

public class AgricultureViewTable extends Table {
	private GameState gameState;
	private Stage stage;
	
	public AgricultureViewTable(GameState gameState, Stage stage) {
		super();
		
		this.gameState = gameState;
		this.stage = stage;

		addTableElements();
	}

	private void addTableElements() {
		Land land = gameState.getPlayerGameData().getLand();
		Herd herd = gameState.getPlayerGameData().getHerd();
		Building building = gameState.getPlayerGameData().getBuilding();
		int husbandry = building.getBuilding(BuildingType.HUSBANDRY).getHave();
		int pasture = building.getHusbandry().getPasture();
		int arableLand = building.getHusbandry().getArableLand();
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
		Text husbandryValueText = new Text(husbandry);
		Text pastureText = new Text("Pasture");
		Text pastureValueText = new Text(pasture);
		Slider pastureSlider = new Slider(0, husbandry, 1, false, defaultSkin);

		pastureSlider.setValue(husbandry - pasture);
		pastureSlider.addListener(new ChangeListener() {	
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println(pastureSlider.getValue());
				
			}
		});

		Text arableLandText = new Text("Arable land");
		Text arableLandValueText = new Text(arableLand);
		Table husbandryTable = new Table();
		Text herdsText = new Text("Herds", true);
		
		pastureText.setAlignment(Align.left);
		
		Table landsTable = new Table();
		
		add(landsText);
		row();
		landsTable.add(forestText);
		landsTable.add(forestValueText);
		landsTable.add(forestClearButton);
		landsTable.row();
		landsTable.add(wildernessText);
		landsTable.add(wildernessValueText).padLeft(24).padRight(24);
		landsTable.add(clearButton);
		landsTable.row();
		landsTable.add(emptyLandText);
		landsTable.add(emptyLandValueText);
		landsTable.row();
		landsTable.add(marshText);
		landsTable.add(marshValueText);
		landsTable.row();
		landsTable.add(riverText);
		landsTable.add(riverValueText);
		landsTable.row();
		landsTable.add(husbandryText);
		landsTable.add(husbandryValueText);
		landsTable.row();
		
		add(landsTable);

		husbandryTable.add(pastureText).padRight(12);
		husbandryTable.add(pastureValueText).padRight(12);
		husbandryTable.add(pastureSlider);
		husbandryTable.add(arableLandValueText).padLeft(12);
		husbandryTable.add(arableLandText).padLeft(12);

		add(husbandryTable);
		row();
		
		Table herdsTable = new Table();
		
		add(herdsText);
		row();

		for (HerdData herdData : herd.getHerds()) {
			Text herdText = new Text(herdData.getName());
			Text herdValueText = new Text(Integer.toString(herdData.getHave()));
			
			herdsTable.add(herdText);
			herdsTable.add(herdValueText);
			herdsTable.row();
		}
		
		add(herdsTable);

		Modal clearModal = new Modal("Title here", defaultSkin);
		Button modalButton = new Button("Ok");
		Text modalText = new Text("Modal text text text");
		Text modalText2 = new Text("Modal text2");
		clearModal.getContentTable().add(modalText);
		clearModal.getContentTable().row();
		clearModal.getContentTable().add(modalText2);
		clearModal.getContentTable().row();
		clearModal.button(modalButton);

		clearModal.show(stage);
		clearModal.hide();
	}
}

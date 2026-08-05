package com.elixir.hunwars.ui.views;

import java.util.Arrays;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.utils.Align;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.enums.Buildings;
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
		String[] buildings = Arrays.stream(Buildings.values())
								.map((value) -> value.toString())
								.toArray(String[]::new);
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
		Text emptyLandsValueText = new Text("38");
		emptyLandsText.setAlignment(Align.left);
		add(emptyLandsText).padLeft(60).expandX().fillX();
		add(emptyLandsValueText);
		row();
		
		for (int i = 0; i < buildings.length; i++) {
			String building = buildings[i];
			Text buildingNameText = new Text(building);
			Text qText = new Text("5");
			Text pText = new Text("4%");
			Text ipText = new Text("2");

			buildingNameText.setAlignment(Align.left);
			
			add(buildingNameText).padLeft(60).expandX().fillX();
			add(qText);
			add(pText);
			add(ipText);
			row();
		}
	}
}

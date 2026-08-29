package com.elixir.hunwars.ui.views;

import java.util.Arrays;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.entities.PopulationType;
import com.elixir.hunwars.ui.Button;
import com.elixir.hunwars.ui.Text;

public class ArmiesViewTable extends Table {
	private GameState gameState;
	
	public ArmiesViewTable(GameState gameState) {
		super();
		
		this.gameState = gameState;
		
		addTableElements();
	}

	private void addTableElements() {
		Text nameHeaderText = new Text("Name");
		Text garrisonHeaderText = new Text("Empty Garrison");
		Text haveHeaderText = new Text("Have");
		Text inProgressHeaderText = new Text("In Progress");
		String[] armies = Arrays.stream(PopulationType.values())
				.map((value) -> value.getPopulationRuleSet().getName())
				.toArray(String[]::new);

		add(nameHeaderText).padLeft(8).padRight(8);
		add(garrisonHeaderText).padLeft(8).padRight(8);
		add(haveHeaderText).padLeft(8).padRight(8);
		add(inProgressHeaderText).padLeft(8).padRight(8);
		row();

		for (int i = 0; i < armies.length; i++) {
			Button nameText = new Button(armies[i]);
			Text garrisonText = new Text("550");
			Text haveText = new Text("0");
			Text inProgressText = new Text("0");
			
			add(nameText);
			add(garrisonText);
			add(haveText);
			add(inProgressText);
			row();
		}
	}
}
package com.elixir.hunwars.ui.views;

import java.util.Arrays;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.entities.BuildingData;
import com.elixir.hunwars.entities.BuildingType;
import com.elixir.hunwars.ui.Button;
import com.elixir.hunwars.ui.Text;

public class WorkersViewTable extends Table {
	private GameState gameState;
	
	public WorkersViewTable(GameState gameState) {
		super();
		
		this.gameState = gameState;
		
		addTableElements();
	}

	private void addTableElements() {		
		Text rowHeaderText = new Text("Priority");
		Text buildingNameHeaderText = new Text("Building");
		Text haveHeaderText = new Text("Have");
		Text percentageHeaderText = new Text("%");
		
		add(rowHeaderText);
		add(buildingNameHeaderText);
		add(haveHeaderText);
		add(percentageHeaderText);
		row();
		
		int i = 0;

		for (BuildingData building : gameState.getPlayerGameData().getBuilding().getPrioritizedBuildings()) {
			String rowNumber = Integer.toString(building.getPriority());
			Text rowText = new Text(rowNumber);
			Text buildingNameText = new Text(building.getName());
			Text haveText = new Text("5");
			Text percentageText = new Text("100%");
			Button upArrowButton = new Button("^");
			Button downArrowButton = new Button("v");
			
			add(rowText);
			add(buildingNameText);
			add(haveText);
			add(percentageText);
			
			if (i == 0) {
				add();
			} else {
				add(upArrowButton).padLeft(24);
			}

			if (i != gameState.getPlayerGameData().getBuilding().getPrioritizedBuildings().size() - 1) {
				add(downArrowButton).padLeft(8);
			}

			row();
			i++;
		}
	}
}

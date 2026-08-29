package com.elixir.hunwars.ui.views;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.entities.Building;
import com.elixir.hunwars.entities.BuildingData;
import com.elixir.hunwars.entities.BuildingType;
import com.elixir.hunwars.entities.Land;
import com.elixir.hunwars.ui.Text;

public class BuildingsInProgressViewTable  extends Table {
	private GameState gameState;
	
	public BuildingsInProgressViewTable(GameState gameState) {
		super();
		
		this.gameState = gameState;

		addTableElements();
	}

	private void addTableElements() {
		Building building = gameState.getPlayerGameData().getBuilding();
		Land land = gameState.getPlayerGameData().getLand();
		Text nameHeaderText = new Text("Name");
		Text haveHeaderText = new Text("Have");
		Text percentageHeaderText = new Text("%");
		
		add(nameHeaderText).padRight(12);
		add(haveHeaderText).padRight(12);
		add(percentageHeaderText).padRight(12);

		for (int i = 0; i < BuildingData.IN_PROGRESS_COLUMN; i++) {
			Text inProgressHeaderText = new Text(i + 1);

			add(inProgressHeaderText).padRight(18);
		}

		row();

		final int totalLandCount = land.getTotalLandCount();

		for (BuildingData buildingData : building.getBuildings()) {
			BuildingType buildingType = buildingData.getType();
			Text nameText = new Text(buildingData.getName());
			Text haveText = new Text(buildingData.getHave());
			Text percentageText = new Text(building.getPercentage(buildingType, totalLandCount) + "%");
			
			add(nameText).padRight(12);
			add(haveText).padRight(12);
			add(percentageText).padRight(12);
			
			for (int i = 0; i < BuildingData.IN_PROGRESS_COLUMN; i++) {
				Text inProgressText = new Text(building.getInProgress(buildingType, i));

				add(inProgressText).padRight(18);
			}

			row();
		}
	}
}

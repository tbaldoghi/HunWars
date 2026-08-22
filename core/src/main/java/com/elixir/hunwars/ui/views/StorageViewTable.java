package com.elixir.hunwars.ui.views;

import java.util.List;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.entities.Building;
import com.elixir.hunwars.entities.Resource;
import com.elixir.hunwars.entities.ResourceData;
import com.elixir.hunwars.ui.Text;

public class StorageViewTable extends Table {
	private GameState gameState;
	
	public StorageViewTable(GameState gameState) {
		super();

		this.gameState = gameState;

		addTableElements();
	}

	private void addTableElements() {
		Resource resource = gameState.getPlayerGameData().getResource();
		Building building = gameState.getPlayerGameData().getBuilding();
		List<ResourceData> resources = resource.getStorageResources();
		
		Text resourceHeaderText = new Text("Name");
		Text capacityHeaderText = new Text("Capacity");
		Text haveHeaderText = new Text("Have");
		Text freeHeaderText = new Text("Free");
		Text productionHeaderText = new Text("Production");
		
		add(resourceHeaderText);
		add(capacityHeaderText);
		add(haveHeaderText);
		add(freeHeaderText);
		add(productionHeaderText);
		row();
		
		for (ResourceData resourceData : resources) {
			Text nameText = new Text(resourceData.getName());
			int storageCapacity = building.storageCapcityForResource(resourceData.getType());
			Text capacityText = new Text(storageCapacity);
			int resourceHave = resourceData.getHave();
			Text haveText = new Text(resourceHave);
			Text freeText = new Text(storageCapacity - resourceHave);
			Text productionText = new Text("0");
			
			add(nameText);
			add(capacityText);
			add(haveText);
			add(freeText);
			add(productionText);
			row();
		}
	}
}

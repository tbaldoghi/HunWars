package com.elixir.hunwars.ui.views;

import java.util.List;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.entities.Building;
import com.elixir.hunwars.entities.Herd;
import com.elixir.hunwars.entities.Resource;
import com.elixir.hunwars.entities.ResourceData;
import com.elixir.hunwars.entities.ResourceType;
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
		Herd herd = gameState.getPlayerGameData().getHerd();
		Building building = gameState.getPlayerGameData().getBuilding();
		List<ResourceData> resources = resource.getStorageResources();

		Text resourceHeaderText = new Text("Name");
		Text capacityHeaderText = new Text("Capacity");
		Text haveHeaderText = new Text("Have");
		Text freeHeaderText = new Text("Free");
		Text productionHeaderText = new Text("Production");
		
		add(resourceHeaderText).padLeft(8).padRight(8);
		add(capacityHeaderText).padLeft(8).padRight(8);
		add(haveHeaderText).padLeft(8).padRight(8);
		add(freeHeaderText).padLeft(8).padRight(8);
		add(productionHeaderText).padLeft(8).padRight(8);
		row();
		
		for (ResourceData resourceData : resources) {
			ResourceType resourceType = resourceData.getType();
			Text nameText = new Text(resourceData.getName());
			int storageCapacity = building.storageCapcityForResource(resourceType);
			Text capacityText = new Text(storageCapacity);
			int resourceHave = resourceData.getHave();
			Text haveText = new Text(resourceHave);
			Text freeText = new Text(storageCapacity - resourceHave);
			Text productionText = new Text(resource.getResourceProduction(resourceType, herd, building));

			add(nameText);
			add(capacityText);
			add(haveText);
			add(freeText);
			add(productionText);
			row();
		}
	}
}

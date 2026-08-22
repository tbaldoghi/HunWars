package com.elixir.hunwars.ui.views;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.entities.Population;
import com.elixir.hunwars.entities.Resource;
import com.elixir.hunwars.entities.ResourceType;
import com.elixir.hunwars.ui.Text;

public class FoodViewTable extends Table {
	private GameState gameState;
	
	public FoodViewTable(GameState gameState) {
		super();
		
		this.gameState = gameState;

		addTableElements();
	}

	private void addTableElements() {
		Resource resource = gameState.getPlayerGameData().getResource();
		Population population = gameState.getPlayerGameData().getPopulation();

		Text haveText = new Text("Have in storage");
		int foodHave = resource.getResource(ResourceType.FOOD).getHave();
		Text haveValueText = new Text(foodHave);
		Text productionText = new Text("Production / turn");
		Text productionValueText = new Text("0");
		Text summaryText = new Text("Summary");
		int summary = foodHave + 0;
		Text summaryValueText = new Text(summary);
		Text consumptionText = new Text("Consumption / turn");
		int foodPerTurn = population.foodPerTurn();
		Text consumptionValueText = new Text(foodPerTurn);
		Text balanceText = new Text("Balance");
		Text balanceValueText = new Text(summary - foodPerTurn);

		add(haveText).left().padLeft(8).padRight(8);
		add(haveValueText).padLeft(8).padRight(8);
		row();
		add(productionText).left().padLeft(8).padRight(8);
		add(productionValueText).padLeft(8).padRight(8);
		row();
		add(summaryText).left().padLeft(8).padRight(8);
		add(summaryValueText).padLeft(8).padRight(8);
		row();
		add(consumptionText).left().padLeft(8).padRight(8);
		add(consumptionValueText).padLeft(8).padRight(8);
		row();
		add(balanceText).left().padLeft(8).padRight(8);
		add(balanceValueText).padLeft(8).padRight(8);
	}
}

package com.elixir.hunwars.ui.views;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.Side;
import com.elixir.hunwars.entities.Population;
import com.elixir.hunwars.entities.PopulationData;
import com.elixir.hunwars.entities.PopulationType;
import com.elixir.hunwars.entities.Resource;
import com.elixir.hunwars.entities.ResourceType;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.ui.Text;

public class OverviewViewTable extends Table {
	private final int CELL_PAD = 36;
	private GameState gameState;
	private Text landText;
	private Text landValueText;
	private Text populationText;
	private Text populationValueText;
	private Text silverText;
	private Text foodText;
	
	public OverviewViewTable(GameState gameState) {
		super();

		this.gameState = gameState;
		
		addTableElements();
	}
	
	private void addTableElements() {
		Side playerGameData = gameState.getPlayerGameData();
		Population population = gameState.getPlayerGameData().getPopulation();
		Resource resource = gameState.getPlayerGameData().getResource();
		
		landText = new Text("Lands:");
		landValueText = new Text(String.valueOf(playerGameData.getLand().getTotalLandCount()));
		populationText = new Text("Population:");
		populationValueText = new Text(Integer.toString(population.getTotalPopulationCount()));
		silverText = new Text("Silver:");
		Text silverValueText = new Text(Integer.toString(resource.getResource(ResourceType.SILVER).getHave()));
		foodText = new Text("Food:");
		Text foodValueText = new Text(Integer.toString(resource.getResource(ResourceType.FOOD).getHave()));
		
		Table leftContainerTable = new Table();
		
		leftContainerTable.add(landText).left().padRight(CELL_PAD);
		leftContainerTable.add(landValueText).right();
		leftContainerTable.row();
		leftContainerTable.add(silverText).left().padRight(CELL_PAD);
		leftContainerTable.add(silverValueText).right();
		leftContainerTable.row();
		leftContainerTable.add(foodText).left().padRight(CELL_PAD);
		leftContainerTable.add(foodValueText).right();

		Table rightContainerTable = new Table();

		rightContainerTable.add(populationText).left().padRight(CELL_PAD);
		rightContainerTable.add(populationValueText).right();
		rightContainerTable.row();
		
		for (PopulationData populationData : population.getPopulations()) {
			Text populationDataText = new Text(populationData.getName());
			Text populationDataValueText = new Text(Integer.toString(populationData.getHave()));
			
			rightContainerTable.add(populationDataText).left().padRight(CELL_PAD);
			rightContainerTable.add(populationDataValueText).right();
			rightContainerTable.row();
		}
		
		add(leftContainerTable).padRight(12).top();
		add(rightContainerTable).padLeft(12).top();
	}
}

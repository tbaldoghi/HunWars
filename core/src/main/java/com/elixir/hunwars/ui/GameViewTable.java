package com.elixir.hunwars.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.enums.GameViewType;
import com.elixir.hunwars.ui.views.AgricultureViewTable;
import com.elixir.hunwars.ui.views.ArmiesViewTable;
import com.elixir.hunwars.ui.views.BuildingsInProgressViewTable;
import com.elixir.hunwars.ui.views.BuildingsViewTable;
import com.elixir.hunwars.ui.views.FoodViewTable;
import com.elixir.hunwars.ui.views.OverviewViewTable;
import com.elixir.hunwars.ui.views.StorageViewTable;
import com.elixir.hunwars.ui.views.TradeViewTable;
import com.elixir.hunwars.ui.views.WorkersViewTable;

public class GameViewTable extends Table {
	private GameState gameState;
	private Stage stage;
	private OverviewViewTable overviewViewTable;
	private AgricultureViewTable agricultureViewTable;
	private WorkersViewTable workersViewTable;
	private BuildingsViewTable buildingsViewTable;
	private BuildingsInProgressViewTable buildingsInProgressViewTable;
	private ArmiesViewTable armiesViewTable;
	private StorageViewTable storageViewTable;
	private FoodViewTable foodViewTable;
	private TradeViewTable tradeViewTable;
	
	public GameViewTable(GameState gameState, Stage stage) {
		this.gameState = gameState;
		this.stage = stage;
		
		addTableElements();
	}
	
	public void updateGameView() {
		GameViewType currentGameView = gameState.getCurrentGameView();
		
		clearChildren();

		switch (currentGameView) {
		case OVERVIEW:
			add(overviewViewTable);
			break;
		case AGRICULTURE:
			add(agricultureViewTable);
			break;
		case WORKERS:
			add(workersViewTable);
			break;
		case BUILDINGS:
			add(buildingsViewTable);
			break;
		case BUILDINGS_PRODUCTION:
			add(buildingsInProgressViewTable);
			break;
		case ARMIES:
			add(armiesViewTable);
			break;
		case STORAGE:
			add(storageViewTable);
			break;
		case FOOD:
			add(foodViewTable);
			break;
		case TRADE:
			add(tradeViewTable);
			break;
		default:
			add(overviewViewTable);
			break;
		}
	}
	
	private void addTableElements() {
		overviewViewTable = new OverviewViewTable(gameState);
		agricultureViewTable = new AgricultureViewTable(gameState, stage);
		workersViewTable = new WorkersViewTable(gameState);
		buildingsViewTable = new BuildingsViewTable(gameState, stage);
		buildingsInProgressViewTable = new BuildingsInProgressViewTable(gameState);
		armiesViewTable = new ArmiesViewTable(gameState);
		storageViewTable = new StorageViewTable(gameState);
		foodViewTable = new FoodViewTable(gameState);
		tradeViewTable = new TradeViewTable(gameState);

		updateGameView();
	}
}

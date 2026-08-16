package com.elixir.hunwars.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.GameState.GameView;
import com.elixir.hunwars.ui.views.AgricultureViewTable;
import com.elixir.hunwars.ui.views.ArmiesViewTable;
import com.elixir.hunwars.ui.views.BuildingsViewTable;
import com.elixir.hunwars.ui.views.OverviewViewTable;
import com.elixir.hunwars.ui.views.WorkersViewTable;

public class GameViewTable extends Table {
	private GameState gameState;
	private Stage stage;
	private OverviewViewTable overviewViewTable;
	private AgricultureViewTable animalHusbandryViewTable;
	private WorkersViewTable workersViewTable;
	private BuildingsViewTable buildingsViewTable;
	private ArmiesViewTable armiesViewTable;
	
	public GameViewTable(GameState gameState, Stage stage) {
		this.gameState = gameState;
		this.stage = stage;
		
		addTableElements();
	}
	
	public void updateGameView() {
		GameView currentGameView = gameState.getCurrentGameView();
		
		clearChildren();

		switch (currentGameView) {
		case Overview:
			add(overviewViewTable);
			break;
		case Agriculture:
			add(animalHusbandryViewTable);
			break;
		case Workers:
			add(workersViewTable);
			break;
		case Buildings:
			add(buildingsViewTable);
			break;
		case Armies:
			add(armiesViewTable);
			break;
		default:
			add(overviewViewTable);
			break;
		}
	}
	
	private void addTableElements() {
		overviewViewTable = new OverviewViewTable(gameState);
		animalHusbandryViewTable = new AgricultureViewTable(gameState);
		workersViewTable = new WorkersViewTable(gameState);
		buildingsViewTable = new BuildingsViewTable(gameState, stage);
		armiesViewTable = new ArmiesViewTable(gameState);
		
		updateGameView();
	}
}

package com.elixir.hunwars.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.GameState.GameView;
import com.elixir.hunwars.ui.views.BuildingsViewTable;
import com.elixir.hunwars.ui.views.OverviewViewTable;

public class GameViewTable extends Table {
	private GameState gameState;
	private Stage stage;
	private OverviewViewTable overviewViewTable;
	private BuildingsViewTable buildingsViewTable;
	
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
		case Buildings:
			add(buildingsViewTable).expand().fill();
			break;
		default:
			add(overviewViewTable);
			break;
		}
	}
	
	private void addTableElements() {
		overviewViewTable = new OverviewViewTable(gameState);
		buildingsViewTable = new BuildingsViewTable(gameState, stage);
		
		updateGameView();
	}
}

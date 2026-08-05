package com.elixir.hunwars.ui;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.GameState.GameView;

public class SideMenuTable extends Table {
	private GameState gameState;
	private GameViewTable gameViewTable;
	private final GameView[] gameViews = {
		GameView.Overview,
		GameView.AnimalHusbandry,
		GameView.Armies,
		GameView.Buildings,
		GameView.Trade,
		GameView.Diplomacy,
		GameView.War
	};
	private Button[] buttons = new Button[gameViews.length];

	public SideMenuTable(GameState gameState, GameViewTable gameViewTable) {
		this.gameState = gameState;
		this.gameViewTable = gameViewTable;

		addTableElements();
	}
	
	private void addTableElements() {
		for (int i = 0; i < gameViews.length; i++) {
			GameView gameView = gameViews[i];

			if (gameView.name() == GameView.AnimalHusbandry.name()) {
				buttons[i] = new Button("Animal Husbandry");
			} else {
				buttons[i] = new Button(gameView.name());
			}

			buttons[i].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					gameState.setCurrentGameView(gameView);
					gameViewTable.updateGameView();
				}
			});
			
			add(buttons[i]);
			row();
		}
	}
}

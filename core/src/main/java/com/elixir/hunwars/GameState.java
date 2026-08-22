package com.elixir.hunwars;

import com.elixir.hunwars.enums.GameViewType;

public class GameState {
	private GameViewType currentGameView;
	private Side playerGameData;
	
	public GameState() {
		resetGameState();
	}
	
	public void setCurrentGameView(GameViewType currentGameView) {
		this.currentGameView = currentGameView;
	}

	public GameViewType getCurrentGameView() {
		return currentGameView;
	}

	public Side getPlayerGameData() {
		return playerGameData;
	}

	public void resetGameState() {
		currentGameView = GameViewType.OVERVIEW;
		playerGameData = new Side();
	}
}

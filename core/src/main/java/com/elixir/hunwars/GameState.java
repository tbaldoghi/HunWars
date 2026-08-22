package com.elixir.hunwars;

public class GameState {
	public enum GameView {
		OVERVIEW,
		RELIGION,
		MAP,
		AGRICULTURE,
		BUILDINGS,
		WORKERS,
		ARMIES,
		TRADE,
		DIPLOMACY,
		WAR,
		STORAGE
	}

	private GameView currentGameView;
	private Side playerGameData;
	
	public GameState() {
		resetGameState();
	}
	
	public void setCurrentGameView(GameView currentGameView) {
		this.currentGameView = currentGameView;
	}

	public GameView getCurrentGameView() {
		return currentGameView;
	}

	public Side getPlayerGameData() {
		return playerGameData;
	}

	public void resetGameState() {
		currentGameView = GameView.OVERVIEW;
		playerGameData = new Side();
	}
}

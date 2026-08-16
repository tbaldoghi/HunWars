package com.elixir.hunwars;

public class GameState {
	public enum GameView {
		Overview,
		Religion,
		Map,
		Agriculture,
		Buildings,
		Workers,
		Armies,
		Trade,
		Diplomacy,
		War
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
		currentGameView = GameView.Overview;
		playerGameData = new Side();
	}
}

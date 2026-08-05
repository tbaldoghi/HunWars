package com.elixir.hunwars;

public class GameState {
	public enum GameView {
		Overview,
		AnimalHusbandry,
		Buildings,
		Armies,
		Trade,
		Diplomacy,
		War
	}

	private GameView currentGameView;
	private GameData playerGameData;
	
	public GameState() {
		resetGameState();
	}
	
	public void setCurrentGameView(GameView currentGameView) {
		this.currentGameView = currentGameView;
	}

	public GameView getCurrentGameView() {
		return currentGameView;
	}

	public GameData getPlayerGameData() {
		return playerGameData;
	}

	public void resetGameState() {
		currentGameView = GameView.Overview;
		playerGameData = new GameData();
	}
}

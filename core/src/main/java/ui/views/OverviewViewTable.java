package ui.views;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.GameData;
import com.elixir.hunwars.GameState;

import ui.Text;

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
		GameData playerGameData = gameState.getPlayerGameData(); 
		landText = new Text("Lands:");
		landValueText = new Text(String.valueOf(playerGameData.getLand()));
		populationText = new Text("Population:");
		populationValueText = new Text(String.valueOf(playerGameData.getPopulation()));
		silverText = new Text("Silver:");
		foodText = new Text("Food:");
		
		add(landText).left().padRight(CELL_PAD);
		add(landValueText).right();
		row();
		add(populationText).left().padRight(CELL_PAD);
		add(populationValueText).right();
		row();
		add(silverText).left().padRight(CELL_PAD);
		row();
		add(foodText).left().padRight(CELL_PAD);
	}
}

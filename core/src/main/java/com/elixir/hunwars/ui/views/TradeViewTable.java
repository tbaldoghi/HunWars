package com.elixir.hunwars.ui.views;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elixir.hunwars.GameState;
import com.elixir.hunwars.entities.Resource;
import com.elixir.hunwars.entities.ResourceData;
import com.elixir.hunwars.enums.TradeViewType;
import com.elixir.hunwars.ui.Button;
import com.elixir.hunwars.ui.Text;

public class TradeViewTable  extends Table {
	private GameState gameState;
	private TradeViewType currentTradeViewType;

	public TradeViewTable(GameState gameState) {
		super();

		this.gameState = gameState;
		this.currentTradeViewType = TradeViewType.OVERVIEW;

		addTableElements();
	}
	
	public void updateTradeView() {
		clearChildren();
		
		switch (currentTradeViewType) {
		case OVERVIEW:
			addOverviewElements();
			break;
		case TRADE:
			break;
		case IMPORTS:
			break;
		case EXPORTS:
			break;
		default:
			addOverviewElements();
			break;
		}
	}

	private void addTableElements() {
		Button overviewButton = new Button("Overview");
		Button tradeButton = new Button("Trade");
		Button importButton = new Button("Import");
		Button exportButton = new Button("Export");
		
		add(overviewButton);
		add(tradeButton);
		add(importButton);
		add(exportButton);
		
		updateTradeView();
	}
	
	private void addOverviewElements() {
		Resource resource = gameState.getPlayerGameData().getResource();
		
		Text nameHeaderText = new Text("Name");
		Text offersHeaderText = new Text("Offers");
		Text requestsHeaderText = new Text("Requests");
		Text topProducersHeaderText = new Text("Top producers");

		add(nameHeaderText);
		add(offersHeaderText);
		add(requestsHeaderText);
		add(topProducersHeaderText);
		row();

		for (ResourceData resourceData : resource.getStorageResources()) {
			Text nameText = new Text(resourceData.getName());
		
			add(nameText);
			row();
		}
	}
}

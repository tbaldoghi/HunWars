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
		addTableTabs();
		
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
		updateTradeView();
	}
	
	private void addTableTabs() {
		Button overviewButton = new Button("Overview");
		Button tradeButton = new Button("Trade");
		Button importButton = new Button("Import");
		Button exportButton = new Button("Export");
		
		add(overviewButton);
		add(tradeButton);
		add(importButton);
		add(exportButton);
		row();
	}

	private void addOverviewElements() {
		Resource resource = gameState.getPlayerGameData().getResource();

		Table overviewTable = new Table();
		Text nameHeaderText = new Text("Name");
		Text offersHeaderText = new Text("Offers");
		Text requestsHeaderText = new Text("Requests");
		Text topProducersHeaderText = new Text("Top producers");

		overviewTable.add(nameHeaderText);
		overviewTable.add(offersHeaderText);
		overviewTable.add(requestsHeaderText);
		overviewTable.add(topProducersHeaderText);
		overviewTable.row();

		for (ResourceData resourceData : resource.getStorageResources()) {
			Text nameText = new Text(resourceData.getName());
		
			overviewTable.add(nameText);
			overviewTable.row();
		}

		add(overviewTable).colspan(4).padTop(24);
	}
}

package com.elixir.hunwars.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Herd {
	private LinkedHashMap<HerdType, HerdData> herds = new LinkedHashMap<>();

	public Herd() {
		populateHerds();
		resetHerdData();
	}
	
	public HerdData getHerd(HerdType herdType) {
		return herds.get(herdType);
	}

	public List<HerdData> getHerds() {
		return new ArrayList<HerdData>(herds.values());
	}

	private void populateHerds() {
		for (HerdType herdType : HerdType.values()) {
			HerdData herd = new HerdData(herdType);

			herds.put(herdType, herd);
		}
	}

	private void resetHerdData() {
		herds.get(HerdType.CATTLE).setHave(20);
		herds.get(HerdType.SHEEP).setHave(50);
		herds.get(HerdType.HORSE).setHave(10);
	}
}

package com.elixir.hunwars.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.elixir.hunwars.Styles;

public class Text extends Label {
	public Text(String text) {
		super(text, Styles.getInstance().textLabelStyle);
		
		setWrap(false);
		setAlignment(Align.center);
	}
	
	public Text(int text) {
		super(Integer.toString(text), Styles.getInstance().textLabelStyle);
		
		setWrap(false);
		setAlignment(Align.center);
	}

	public Text(String text, boolean isTitle) {
		super(text, textStyle(isTitle));
		
		setWrap(false);
		setAlignment(Align.center);
	}

	private static LabelStyle textStyle(boolean isTitle) {
		if (isTitle) {
			return Styles.getInstance().textTitleLabelStyle;
		}
		
		return Styles.getInstance().textLabelStyle;
	}
}

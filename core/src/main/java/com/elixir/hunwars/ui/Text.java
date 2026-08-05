package com.elixir.hunwars.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.elixir.hunwars.utils.FontGenerator;

public class Text extends Label {
	public Text(String text) {
		super(text, getLabelStyle(false));
		
		setWrap(false);
		setAlignment(Align.center);
	}
	
	public Text(String text, boolean isTitle) {
		super(text, getLabelStyle(isTitle));
		
		setWrap(false);
		setAlignment(Align.center);
	}
	
	private static LabelStyle getLabelStyle(boolean isTitle) {
		LabelStyle labelStyle = new LabelStyle();
		FontGenerator fontGenerator = new FontGenerator();
		BitmapFont font;
		
		if (isTitle) {
			font = fontGenerator.getTitleFont();
		} else {
			font = fontGenerator.getTextFont();
		}
		
		labelStyle.font = font;
		
		fontGenerator.dispose();
		
		return labelStyle;
	}
}

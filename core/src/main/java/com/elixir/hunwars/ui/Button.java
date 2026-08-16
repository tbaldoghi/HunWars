package com.elixir.hunwars.ui;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.elixir.hunwars.Styles;

public class Button extends TextButton {
	public Button(String text) {
		super(text, Styles.getInstance().textButtonStyle);
	}
	
	public Button(String text, boolean isMenuButton) {
		super(text, buttonStyle(isMenuButton));
		
		padRight(24);
		padLeft(24);
		padTop(2);
		padBottom(2);
	}
	
	private static TextButtonStyle buttonStyle(boolean isMenuButton) {
		if (isMenuButton) {
			return Styles.getInstance().menuButtonStyle;
		}
		
		return Styles.getInstance().textButtonStyle;
	}
}

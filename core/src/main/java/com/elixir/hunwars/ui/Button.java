package com.elixir.hunwars.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.elixir.hunwars.utils.FontGenerator;

public class Button extends TextButton {
	public Button(String text) {
		super(text, getTextButtonStlye());
	}

	private static TextButtonStyle getTextButtonStlye() {
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		FontGenerator fontGenerator = new FontGenerator();
		BitmapFont font = fontGenerator.getTextFont();
		
		textButtonStyle.font = font;
		
		fontGenerator.dispose();
		
		return textButtonStyle;
	}
}

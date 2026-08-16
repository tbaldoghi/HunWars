package com.elixir.hunwars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.elixir.hunwars.utils.FontGenerator;

public class Styles {
	private static Styles instance = null;
	public BitmapFont textFont;
	public BitmapFont menuButtonFont;
	public BitmapFont titleFont;
	public LabelStyle textLabelStyle;
	public LabelStyle textTitleLabelStyle;
	public TextButtonStyle textButtonStyle;
	public TextButtonStyle menuButtonStyle;

	private Styles() {
		generateFonts();
		
		textLabelStyle = getTextLabelStyle();
		textButtonStyle = getTextButtonStyle();
		menuButtonStyle = getMenuButtonStyle();
		textTitleLabelStyle = getTextTitleLabelStyle();
	}

	public static Styles getInstance() {
		if (instance == null) {
			instance = new Styles();
		}

		return instance;
	}

	private void generateFonts() {
		FontGenerator fontGenerator = new FontGenerator();
		
		textFont = fontGenerator.getTextFont();
		menuButtonFont = fontGenerator.getMenuButtonFont();
		titleFont = fontGenerator.getTitleFont();

		fontGenerator.dispose();
	}
	
	private LabelStyle getTextLabelStyle() {
		LabelStyle labelStyle = new LabelStyle();

		labelStyle.font = textFont;
		
		return labelStyle;
	}
	
	private LabelStyle getTextTitleLabelStyle() {
		LabelStyle labelStyle = new LabelStyle();

		labelStyle.font = titleFont;
		
		return labelStyle;
	}
	
	private TextButtonStyle getTextButtonStyle() {
		TextButtonStyle buttonStyle = new TextButtonStyle();
		
		buttonStyle.font = textFont;
		Texture texture = new Texture(Gdx.files.internal("images/button.png"));
		Texture textureDown = new Texture(Gdx.files.internal("images/button_down.png"));
		Sprite sprite = new Sprite(texture);
		Sprite spriteDown = new Sprite(textureDown);
		buttonStyle.up = new SpriteDrawable(sprite);
		buttonStyle.down = new SpriteDrawable(spriteDown);
		buttonStyle.pressedOffsetY = -2;
		buttonStyle.pressedOffsetX = 1;
		
		return buttonStyle;
	}
	
	private TextButtonStyle getMenuButtonStyle() {
		TextButtonStyle buttonStyle = new TextButtonStyle();
		
		buttonStyle.font = menuButtonFont;
		Texture texture = new Texture(Gdx.files.internal("images/button.png"));
		Texture textureDown = new Texture(Gdx.files.internal("images/button_down.png"));
		Sprite sprite = new Sprite(texture);
		Sprite spriteDown = new Sprite(textureDown);
		buttonStyle.up = new SpriteDrawable(sprite);
		buttonStyle.down = new SpriteDrawable(spriteDown);
		buttonStyle.pressedOffsetY = -2;
		buttonStyle.pressedOffsetX = 1;
		
		return buttonStyle;
	}
}

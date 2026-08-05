package utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.Disposable;

public class FontGenerator implements Disposable {
	private final String FONT_PATH = "fonts/Yrsa.ttf"; 
	private FreeTypeFontParameter fontParameter;
	private FreeTypeFontGenerator fontGenerator;
	private BitmapFont titleFont;
	private BitmapFont textFont;
	
	public FontGenerator() {
		fontParameter = new FreeTypeFontParameter();
		fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
		
		fontParameter.mono = false;
		fontParameter.shadowColor = Color.GRAY;
		fontParameter.shadowOffsetX = 1;
		fontParameter.shadowOffsetY = 1;
		
		generateTitleFont();
		generateTextFont();
	}
	
	public BitmapFont getTitleFont() {
		return titleFont;
	}

	public BitmapFont getTextFont() {
		return textFont;
	}

	@Override
	public void dispose() {
		fontGenerator.dispose();
	}
	
	private void generateTitleFont() {
		fontParameter.size = 64;
		fontParameter.color = new Color(0.3f, 0.15f, 0.15f, 1f);

		titleFont = fontGenerator.generateFont(fontParameter);
		
		titleFont.setUseIntegerPositions(true);
	}
	
	private void generateTextFont() {
		fontParameter.size = 32;
		fontParameter.color = new Color(0.3f, 0.2f, 0.15f, 1f);
		
		textFont = fontGenerator.generateFont(fontParameter);
		
		textFont.setUseIntegerPositions(true);
	}
}

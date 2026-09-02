package com.elixir.hunwars.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Modal extends Dialog {
	public Modal(Skin skin) {
		super("", skin);
	}

	@Override
	public Dialog show(Stage stage) {
		show(stage, null);
		setPosition(Math.round((stage.getWidth() - getWidth()) / 2), Math.round((stage.getHeight() - getHeight()) / 2));

		return this;
	}

	@Override
	public void hide() {
		hide(null);
	}
}

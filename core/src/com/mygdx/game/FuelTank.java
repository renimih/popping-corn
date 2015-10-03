package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class FuelTank {
	
	static final float SIZE = 1f;

	Vector2 	position = new Vector2();
	Rectangle 	bounds = new Rectangle();

	public FuelTank(Vector2 pos) {
		this.position = pos;
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
	}

}

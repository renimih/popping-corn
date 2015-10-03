package com.mygdx.game;


import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class FuelTank {
	
	static final float SIZE = 1f;
	static final ArrayList<Sprite> pics = new ArrayList<Sprite>();

	Vector2 	position = new Vector2();
	Rectangle 	bounds = new Rectangle();

	public void init() {
		pics.add(new Sprite(new  Texture(Gdx.files.internal("1.jpg"))));
		pics.add(new Sprite(new  Texture(Gdx.files.internal("2.jpg"))));
		pics.add(new Sprite(new  Texture(Gdx.files.internal("3.jpg"))));
		pics.add(new Sprite(new  Texture(Gdx.files.internal("4.jpg"))));
		pics.add(new Sprite(new  Texture(Gdx.files.internal("5.jpg"))));
		pics.add(new Sprite(new  Texture(Gdx.files.internal("6.jpg"))));
	}

	public FuelTank(Vector2 pos) {
		this.position = pos;
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
	}
	
	

}

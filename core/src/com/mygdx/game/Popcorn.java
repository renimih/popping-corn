package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Popcorn {

	float size = 1f;

	Vector2 	position = new Vector2();
	Rectangle 	bounds = new Rectangle();

	public Popcorn(Vector2 pos, float size) {
		this.position = pos;
		this.bounds.width = size;
		this.bounds.height = size;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public void split() {
		Popcorn p1 = new Popcorn(this.position, size/2);
		Popcorn p2 = new Popcorn(this.position, size/2);
	}
	
	
}

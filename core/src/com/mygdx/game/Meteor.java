package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Meteor {

	float size;
	private Sprite mSprite;
	float velocity;

	Vector2 position = new Vector2();
	Circle	bounds = new Circle();

	public Meteor(Vector2 pos, float size,float velocity) {
		this.position = pos;
		this.bounds.setRadius(size/2);
		this.size = size;
		this.velocity = velocity;
		mSprite  = new Sprite(new  Texture(Gdx.files.internal("8bitplane.png")));
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

	public void setBounds(Circle bounds) {
		this.bounds = bounds;
	}
	
	public void draw(SpriteBatch batch){
		
		mSprite.draw(batch);
	}
	
	
	
}

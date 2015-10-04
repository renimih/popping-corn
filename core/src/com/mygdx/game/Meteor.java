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
	float vX,vY;

	Vector2 position = new Vector2();
	Circle	bounds = new Circle();

	public Meteor(Vector2 pos, float size,float vX, float vY) {
		this.position = pos;
		this.bounds.setRadius(size/2);
		this.bounds.setPosition(position);
		this.size = size;
		this.vX = vX;
		this.vY = vY;
	     
		mSprite  = new Sprite(new  Texture(Gdx.files.internal("asteroid-cookie.png")));
		mSprite.setSize(size, size);
		mSprite.setOrigin(size/2, size/2);
		mSprite.scale(0.35f);
		
		//mSprite.setOrigin(bounds.radius, bounds.radius);
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
		this.position.x += this.vX;
		this.position.y += this.vY;
		mSprite.setPosition(position.x-size/2, position.y-size/2);
		this.bounds.setPosition(position);
		mSprite.draw(batch);
		
		
		//mSprite.rotate(5);
		//Gdx.app.log("meteor", this.position.x +"");
		//batch.draw(mSprite, position.x, position.y, bounds.radius, bounds.radius);
		
	}
	
	
	
}

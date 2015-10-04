package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Spaceship {

	public enum State {
		IDLE, FLYING, OTHER, DYING
	}

	static float SPEED = 2f; // unit per second
	static final float SIZE = 35f; // half a unit
	private float vx = 0, vy = 0;
	Vector2 position = new Vector2();
	Vector2 acceleration = new Vector2();
	Vector2 velocity = new Vector2();
	Rectangle bounds = new Rectangle();
	Sprite spaceSprite;

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public void draw(SpriteBatch batch) {
		// render blocks
		vx *= 0.99;
		vy *= 0.99;

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			spaceSprite.rotate(4.0f);
			// System.out.println(spaceSprite.getRotation());

			if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
				spaceSprite.translateX(-1f);

			}
			// else {
			// spaceSprite.translateX(-1.0f);
			// }
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			spaceSprite.rotate(-4.0f);

			if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
				spaceSprite.translateX(1f);
			}

			// else
			// spaceSprite.translateX(10.0f);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {

			vx += (float) Math.sin(Math.toRadians(spaceSprite.getRotation())) * 0.3;
			vy += (float) Math.cos(Math.toRadians(spaceSprite.getRotation())) * 0.3;
		}
		if (spaceSprite.getY() >= Gdx.graphics.getHeight()) {
			this.position.x = spaceSprite.getX();
			this.position.y = -spaceSprite.getHeight();
			this.bounds.setPosition(position);
			spaceSprite.setPosition(this.position.x,
					this.position.y);
		} else if (spaceSprite.getY() <= -spaceSprite.getHeight()) {
			this.position.x = spaceSprite.getX();
			this.position.y = Gdx.graphics.getHeight();
			this.bounds.setPosition(position);
			spaceSprite.setPosition(this.position.x,
					this.position.y);
		}
		if (spaceSprite.getX() <= -spaceSprite.getWidth()) {
			this.position.x = Gdx.graphics.getWidth();
			this.position.y = spaceSprite.getY();
			this.bounds.setPosition(position);
			spaceSprite
					.setPosition(this.position.x, this.position.y);
		} else if (spaceSprite.getX() >= Gdx.graphics.getWidth()) {
			this.position.x = -spaceSprite.getWidth();
			this.position.y = spaceSprite.getY();
			this.bounds.setPosition(position);
			spaceSprite
					.setPosition(this.position.x, this.position.y);
		}
		
		this.position.x += -vx;
		this.position.y += vy;
		//spaceSprite.translateX(-vx);
		//spaceSprite.translateY(vy);
		spaceSprite.setPosition(this.position.x, this.position.y);
		this.bounds.setPosition(position);
		spaceSprite.draw(batch);
	}

	public Vector2 getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	State state = State.IDLE;

	public Spaceship(Vector2 position) {
		this.position = position;
		
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
		this.spaceSprite = new Sprite(new Texture(
				Gdx.files.internal("8bitplane.png")));
		spaceSprite.setOrigin(bounds.height/2, bounds.width/2);
		spaceSprite.setSize(bounds.height, bounds.width);
		spaceSprite.scale(0.2f);
		spaceSprite.setPosition(position.x, position.y);
	}
}

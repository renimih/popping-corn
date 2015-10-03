package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {
	
	/** The blocks making up the world **/
	Array<Meteor> popcorns = new Array<Meteor>();
	/** Our player controlled hero **/
	Spaceship spaceship;

	// Getters -----------
	public Array<Meteor> getPopcorns() {
		return popcorns;
	}
	public Spaceship getSpaceship() {
		return spaceship;
	}
	// --------------------

	public World() {
		createDemoWorld();
	}

	private void createDemoWorld() {
		spaceship = new Spaceship(new Vector2(7, 2));

		
	}

}

package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {
	
	/** The blocks making up the world **/
	Array<Popcorn> popcorns = new Array<Popcorn>();
	/** Our player controlled hero **/
	Spaceship spaceship;

	// Getters -----------
	public Array<Popcorn> getPopcorns() {
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

package com.mygdx.game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	private OrthographicCamera cam;

	/** for debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();

	/** Textures **/

	private Texture spaceTexture;
	private Texture popcornTexture;
	private SpriteBatch spriteBatch;
	private SpriteBatch ftBatch;
	private boolean debug = false;
	private int width;
	private int height;
	private float ppuX; // pixels per unit on the X axis
	private float ppuY; // pixels per unit on the Y axis
	private float accX;
	private int spaceVelx;
	private int spaceVely;
	private Spaceship spaceShip = new Spaceship(new Vector2(7, 2));
	private ArrayList<Meteor> meteors = new ArrayList<Meteor>();
	private ArrayList<FuelTank> tanks = new ArrayList<FuelTank>();

	public void setSize(int w, int h) {
		this.width = w;
		this.height = h;
		ppuX = (float) width / CAMERA_WIDTH;
		ppuY = (float) height / CAMERA_HEIGHT;
	}

	public WorldRenderer(boolean debug) {
		
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.debug = debug;
		spriteBatch = new SpriteBatch();
		ftBatch = new SpriteBatch();

		this.spaceVelx = 0;
		this.spaceVely = 0;

		// spriteBatch.setProjectionMatrix(cam.combined);
		// this.cam.update();
		meteors.add(new Meteor(new Vector2(100, 100), 100, 0, 0));
		loadTextures();
		
		class RemindTask extends TimerTask {
		
		private Timer timer;

		RemindTask(Timer timer){
			this.timer = timer;
		}
	    public void run() {
			for (FuelTank ft : tanks) {
				ft.countdown();
				if (ft.time == 0) {
					tanks.remove(ft);
				}
			}
//	      timer.cancel();
//	      System.exit(0); //Stops the AWT thread (and everything else)
	    }
	  }
	
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new RemindTask(timer), 2000, 10000);
		}

	private void loadTextures() {

		// blockTexture = new Texture(Gdx.files.internal("images/block.png"));
	}

	public void render() {

		checkCollision();
		spriteBatch.begin();
		spaceShip.draw(spriteBatch);
		drawMeteors();	
		drawFt();
		spriteBatch.end();
		
//		drawFt(fuelTank, ftBatch);
		if (debug)
			drawDebug();

	}
	
	private void drawFt(){
	
		for (FuelTank ft : tanks) {
			ft.draw(spriteBatch);
		}
	
	}
	

	private void drawMeteors() {
		for (Meteor m : meteors) {
			m.draw(spriteBatch);
		}
	}
	
	private void checkCollision(){
		for(Meteor m: meteors){
			collision(m); 
		}
	}
	private void collision(Meteor m){
		if (Intersector.overlaps(m.bounds, spaceShip.bounds))
	         Gdx.app.log("overlaps", "yes");
	}
	// private void drawSpace() {
	// // Gdx.app.log("bob", spaceship.getPosition().x + "");
	// // spriteBatch.draw(spaceTexture, spaceship.getPosition().x * ppuX,
	// spaceship.getPosition().y * ppuY, Spaceship.SIZE * ppuX, Spaceship.SIZE *
	// ppuY);
	// spaceSprite.draw(spriteBatch);
	// }
	// input handledesu

	// render spaceship
	private void drawDebug() {
		// debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Line);
		// Spaceship spaceShip = world.getSpaceship();
		Rectangle rect = spaceShip.getBounds();
		//float x1 = spaceShip.getPosition().x + rect.x;
		//float y1 = spaceShip.getPosition().y + rect.y;
		debugRenderer.setColor(new Color(0, 1, 0, 1));
		//debugRenderer.rect(x1, y1, rect.width, rect.height);
		debugRenderer.rect(rect.x,rect.y,rect.width,rect.height);
		debugRenderer.setColor(Color.RED);
		for (Meteor m : meteors) {
			debugRenderer.circle(m.position.x, m.position.y, m.bounds.radius);
		}

		debugRenderer.end();
	}

}
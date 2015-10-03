package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class WorldRenderer {
	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	private World world;
	private OrthographicCamera cam;

	/** for debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();

	
	/** Textures **/
	private Texture spaceTexture;
	private Texture popcornTexture;
	private Sprite spaceSprite;
	private SpriteBatch spriteBatch;
	private boolean debug = false;
	private int width;
	private int height;
	private float ppuX;	// pixels per unit on the X axis
	private float ppuY;	// pixels per unit on the Y axis
	private float accX;
	private int spaceVelx;
	private int spaceVely;
	private float vx=0, vy=0;
	
	public void setSize (int w, int h) {
		this.width = w;
		this.height = h;
		ppuX = (float)width / CAMERA_WIDTH;
		ppuY = (float)height / CAMERA_HEIGHT;
	}
	
	public WorldRenderer(World world, boolean debug) {
		this.world = world;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.debug = debug;
		spriteBatch = new SpriteBatch();
		
		this.spaceVelx = 0;
		this.spaceVely = 0;
		
//		spriteBatch.setProjectionMatrix(cam.combined);	
//		this.cam.update();	
		
		loadTextures();
	}

	private void loadTextures() {
		spaceSprite  = new Sprite(new  Texture(Gdx.files.internal("8bitplane.png")));
		//blockTexture = new Texture(Gdx.files.internal("images/block.png"));
	}

	public void render() {
		// render blocks
		vx*=0.99;
		vy*=0.99;
		
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			spaceSprite.rotate(4.0f);
//			System.out.println(spaceSprite.getRotation());
			
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)){
            	spaceSprite.translateX(-1f);
            	
            }
//            else {
//            	spaceSprite.translateX(-1.0f);
//            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
        	spaceSprite.rotate(-4.0f);
        	
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
            	spaceSprite.translateX(1f);
            }
            	
//            else
//            	spaceSprite.translateX(10.0f);
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
        	
        	
            vx += (float) Math.sin(Math.toRadians(spaceSprite.getRotation()))*0.3;
            vy += (float) Math.cos(Math.toRadians(spaceSprite.getRotation()))*0.3;
        }
        if (spaceSprite.getY() >= Gdx.graphics.getHeight()) {
    		spaceSprite.setPosition(spaceSprite.getX(), -spaceSprite.getHeight());
    	}
    	else if (spaceSprite.getY() <= -spaceSprite.getHeight()) {
    		spaceSprite.setPosition(spaceSprite.getX(), Gdx.graphics.getHeight());
    	}
    	if (spaceSprite.getX() <= -spaceSprite.getWidth()) {
    		spaceSprite.setPosition(Gdx.graphics.getWidth(), spaceSprite.getY());
    	}
    	else if (spaceSprite.getX() >= Gdx.graphics.getWidth()) {
    		spaceSprite.setPosition(-spaceSprite.getWidth(), spaceSprite.getY());
    	}
        
       	spaceSprite.translateX(-vx);
        spaceSprite.translateY(vy);
        
        
		spriteBatch.begin();
		drawSpace();
		
		spriteBatch.end();
		if (debug)
			drawDebug();
		
	}
	
	private void drawSpace() {
//		Gdx.app.log("bob", spaceship.getPosition().x + "");
//		spriteBatch.draw(spaceTexture, spaceship.getPosition().x * ppuX, spaceship.getPosition().y * ppuY, Spaceship.SIZE * ppuX, Spaceship.SIZE * ppuY);
		spaceSprite.draw(spriteBatch);
	}	
		//input handledesu
	
		
		
		// render spaceship
	private void drawDebug(){
//		debugRenderer.setProjectionMatrix(cam.combined);
//		debugRenderer.begin(ShapeType.Line);
		Spaceship spaceShip = world.getSpaceship();
		Rectangle rect = spaceShip.getBounds();
		float x1 = spaceShip.getPosition().x + rect.x;
		float y1 = spaceShip.getPosition().y + rect.y;
		debugRenderer.setColor(new Color(0, 1, 0, 1));
		debugRenderer.rect(x1, y1, rect.width, rect.height);
		debugRenderer.end();
	}
	
}
package com.mygdx.game;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class FuelTank {
	
	static final float SIZE = 1f;
	static final ArrayList<Sprite> pics = new ArrayList<Sprite>();
	public int time;

//	Vector2 	position = new Vector2();
	Rectangle 	bounds = new Rectangle();
//	private SpriteBatch spriteBatch = new SpriteBatch();
	private Sprite ftSprite = new Sprite();

	public void init() {
		pics.add(new Sprite(new  Texture(Gdx.files.internal("1.jpg"))));
		pics.add(new Sprite(new  Texture(Gdx.files.internal("2.jpg"))));
		pics.add(new Sprite(new  Texture(Gdx.files.internal("3.jpg"))));
		pics.add(new Sprite(new  Texture(Gdx.files.internal("4.jpg"))));
		pics.add(new Sprite(new  Texture(Gdx.files.internal("5.jpg"))));
		pics.add(new Sprite(new  Texture(Gdx.files.internal("6.jpg"))));
		ftSprite = pics.get(5);
	}

	public FuelTank() {
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
//		updatePic(5);
		time = 5;
		init();
	}
	
	
	
//	public void draw(SpriteBatch batch) {
//		int x = (int)Math.random()*800;
//		int y = (int) Math.random()*600;
//		
//		countDown(batch, 5, x, y);
//	}
	
//	public SpriteBatch getSpriteBatch() {
//		return spriteBatch;
//	}


	public void draw(int count, int x, int y, SpriteBatch batch) {
		ftSprite.setPosition(x, y);
		this.bounds.setPosition(new Vector2(x,y));
		ftSprite.draw(batch);
		      
	}
	
//	class RemindTask extends TimerTask {
//		
//		private Timer timer;
//		private int count;
//
//		RemindTask(Timer timer, int count){
//			this.timer = timer;
//			this.count = count;
//		}
//	    public void run() {
//			ftSprite = pics.get(count);
////	      timer.cancel();
////	      System.exit(0); //Stops the AWT thread (and everything else)
//	    }
//	  }
//	
//	public void updatePic(int count) {
//		while (count > 0) {	
//			Timer timer = new Timer();
//			timer.scheduleAtFixedRate(new RemindTask(timer, count), 2000, 10000);
//			count--;
//		}
//	}
//	
	public void countdown(){
		time--;
		ftSprite = pics.get(time);
	}
	
//	public void draw(SpriteBatch batch, int count, int x, int y) {
//		pics.get(count).setPosition(x, y);
//		this.bounds.setPosition(new Vector2(x,y));
//		pics.get(count).draw(batch);
//		
//	}
//	
	

}

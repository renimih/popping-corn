package com.mygdx.game;

import com.mygdx.game.World;
import com.mygdx.game.WorldRenderer;

import org.lwjgl.opengl.GL11;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {

	private World world;
	private WorldRenderer renderer;
	
	@Override
	public void show() {
		world = new World();
		renderer = new WorldRenderer(world, false);
	}

	@Override
	public void render(float delta) {
//		Gdx.gl.glClearColor(1.0f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}

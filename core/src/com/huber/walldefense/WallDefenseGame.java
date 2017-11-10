package com.huber.walldefense;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.huber.walldefense.sprites.Enemy;
import com.huber.walldefense.state.GameStateManager;
import com.huber.walldefense.state.PlayState;

public class WallDefenseGame extends ApplicationAdapter {


GameStateManager gameStateManager;
	SpriteBatch batch;

	@Override
	public void create () {
	    gameStateManager = new GameStateManager();
		batch = new SpriteBatch();
		gameStateManager.push(new PlayState(gameStateManager));
        Gdx.gl.glClearColor(1, 0, 0, 1);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

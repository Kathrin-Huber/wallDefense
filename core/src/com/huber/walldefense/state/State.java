package com.huber.walldefense.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Familie on 10.11.2017.
 */

public abstract class State {
    protected GameStateManager gameStateManager;

    public State(GameStateManager gameStateManager){
        this.gameStateManager = gameStateManager;
    }

    public abstract void handleInput();
    public abstract void update(float delta);
    public abstract void render(SpriteBatch sb);

}

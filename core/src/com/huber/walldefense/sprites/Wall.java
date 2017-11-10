package com.huber.walldefense.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Familie on 10.11.2017.
 */

public class Wall {
    private Vector2 position;

    private Rectangle bounds;

    private Texture wall;

    public Wall(int x, int y){
        position = new Vector2(x,y);
        wall = new Texture("wall.png");

        bounds = new Rectangle(x, y,wall.getWidth(),wall.getHeight());

    }

    public Vector2 getPosition(){
        return position;
    }

    public Texture getWall() {
        return wall;
    }

    public Rectangle getBounds(){
        return bounds;
    }
}

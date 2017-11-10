package com.huber.walldefense.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.List;


/**
 * Created by Familie on 10.11.2017.
 */

public class Enemy {
    private static final int speed = -5;
    private Vector2 position;

    private Rectangle bounds;

    private Texture enemy;

    boolean won;

    public Enemy(int x, int y){
        position = new Vector2(x,y);
        enemy = new Texture("enemy.png");

        bounds = new Rectangle(x, y,enemy.getWidth(),enemy.getHeight());

    }

    public void update(float dt){
        position.add(0,speed);
        bounds.setPosition(position.x,position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getEnemy() {
        return enemy;
    }

    public boolean collides(List<Wall> theWall) {
        for(Wall wall : theWall){
            if (wall.getBounds().overlaps(bounds)){

                return true;
            }
        }
        return false;
    }

    public boolean wins() {
        if(!won) {
            if (position.y <= 5) {
                won = true;
               return true;
            }
        }
        return false;

    }
}

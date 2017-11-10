package com.huber.walldefense.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.huber.walldefense.sprites.Enemy;
import com.huber.walldefense.sprites.Wall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Familie on 10.11.2017.
 */

public class PlayState extends State{

    List<Enemy> enemies = new ArrayList<Enemy>();
    List<Wall> theWall = new ArrayList<Wall>();
    Texture[] lifes = new Texture[]{new Texture("1.png"),new Texture("2.png"),new Texture("3.png")};
    int life = 2;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        Enemy firstEnemy = new Enemy(50,1000);
        enemies.add(firstEnemy);
        Wall leftWall = new Wall(50,100);
        Wall middleWall = new Wall ( 300, 100);
        Wall rightWall = new Wall(1000, 100);
        theWall.add(leftWall);
        theWall.add(middleWall);
        theWall.add(rightWall);
    }


    @Override
    public void handleInput() {
    if(Gdx.input.justTouched()){
        int rand = new Random().nextInt(1200);
        System.out.println(rand);
        Enemy newEnemy = new Enemy(rand,1000);
        enemies.add(newEnemy);
    }
    }

    @Override
    public void update(float delta) {
        handleInput();
        for(Enemy enemy : enemies) {
            if(enemy.collides(theWall)){

            }
            else if(enemy.wins()){
                life = life-1;
            }
            else {
                enemy.update(delta);
            }

        }


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        for(Enemy enemy : enemies) {
            sb.draw(enemy.getEnemy(), enemy.getPosition().x, enemy.getPosition().y);
        }
        for(Wall wall : theWall){
            sb.draw(wall.getWall(), wall.getPosition().x, wall.getPosition().y);
        }

        sb.draw(lifes[life], 0,0);
        sb.end();

    }
}

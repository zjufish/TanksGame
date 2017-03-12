package com.noskilljustfun.game.gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.noskilljustfun.game.logic.EnvironmentCollisionManager;

public class TankPlayer extends Image {

    private Vector2 position;
    private int velocity;


    public TankPlayer() {
        super(new Texture("tank.png"));
        velocity = 5;
        position = new Vector2(400, 400);
        this.setOrigin(50.0f, 50.0f);
        this.setSize(100.0f, 100.0f);
        this.setPosition(position.x, position.y);
    }


    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void moveUp() {
        this.setRotation(180);
        if ((int)(position.y + getImageHeight() + velocity) <= Gdx.graphics.getHeight()) {

            position.y += velocity;
        }
    }


    public void moveDown() {
        if ((position.y - velocity) >= 0) {
            position.y -= velocity;
        }
        this.setRotation(0);
    }


    public void moveLeft() {
        if ((position.x - velocity) >= 0) {
            position.x -= velocity;
        }
        setRotation(270);

    }

    public void moveRight() {
        if ((int)(position.x + getWidth() + velocity) <= Gdx.graphics.getWidth()) {
            position.x += velocity;
        }
        setRotation(90);

    }

    public void update() {
        this.setPosition(position.x, position.y);
    }

    Rectangle getPlayerTankRectangle(Vector2 nextPosition){

        return new Rectangle(nextPosition.x,nextPosition.y,getWidth(),getHeight());
    }

    boolean checkforWorldObjecCollision(int x, int y){
        return EnvironmentCollisionManager
                .getInstance()
                .checkForObjectCollision(
                        new Rectangle(x,y,getWidth(),getHeight()));
    }
}

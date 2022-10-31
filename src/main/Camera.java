package main;

import Entities.Entity;

public class Camera {

    private float x,y;

    public Camera(float x,float y)
    {
        this.x=x;
        this.y=y;

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void update(Entity player) {

       x=-player.getX()+100;  
    }




    
}

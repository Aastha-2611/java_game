package Entities;
import java.awt.Rectangle;
import java.util.LinkedList;

import java.awt.Graphics;


public abstract class Entity  {
    protected float x,y;
    protected Rectangle hitBox;
    protected int width;
    protected int height;
    public String id;
    protected float velX;
   

 
    public Entity(float x,float y,int width,int height,String id)
    {
       this.x=x;
       this.y=y;
       this.width=width;
       this.height=height;
       this.id=id;

       initHitBox();
    
    }
    public float getVelX() {
        return velX;
    }
    public void setVelX(float velX) {
        this.velX = velX;
    }
    protected float velY;
   
    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }


   public abstract void resetAll();
    public abstract Rectangle getBounds();
    public abstract void update(LinkedList<Entity> gameobject);
    public abstract void render(Graphics g);


    public void initHitBox(){
        this.hitBox=new Rectangle((int)x,(int)y,width,height);
        
    }

   
    public void updateHitBox()
    {
        hitBox.x=(int)x;
        hitBox.y=(int)y;

    }

    public float getX()
    {
        return x;
    }
    public float getY()
    {
        return y;
    }
    public Rectangle getHitBox()
    {
        return hitBox;
    }
    
}

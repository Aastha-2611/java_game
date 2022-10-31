package Entities;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import main.Game;
import main.Textures;

public class Level extends Entity{
    
    Textures texture =Game.getInstance();
    private int type;

    public Level(float x,float y,int width,int height,String id,int type)
    {  
        super(x,y,width,height,"block");
        this.type=type;
       
        
    }
    
   

    

    @Override
    public void render(Graphics g) {
        
        if(type==0)
        {   
             g.drawImage(texture.block_type[0],(int)x,(int)y,null);
        }
  
    }






    @Override
    public void update(LinkedList<Entity> gameobject) {
 
    }





    @Override
    public Rectangle getBounds() {
      
        return hitBox;
    }





    @Override
    public void resetAll() {
      
        
    }
   

    
}

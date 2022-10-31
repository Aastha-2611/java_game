package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.awt.Graphics2D;

import main.Game;
import main.Textures;

public class Flag extends Entity {

    Textures texture=Game.getInstance();

    public Flag(float x, float y, int width, int height, String id) {
        super(x, y, width, height, id);
      
    }

    @Override
    public void resetAll() {
      
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,50,150);
      
    }

    @Override
    public void update(LinkedList<Entity> gameobject) {
      
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(texture.flag, (int)x, (int)y, 100,150,null);
   
  
    }

    
    
}

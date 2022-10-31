package main;
import java.util.*;
import Entities.Entity;
import Entities.Player;
import java.awt.Graphics;

public class Handler {
    
    public LinkedList<Entity> gameObject =new LinkedList<Entity>();
    public LinkedList<Entity> levelBlock =new LinkedList<Entity>();
    private Entity tempObject;
    private Camera camera;
    public int start=0;

    public Handler(Camera camera)
    {
        this.camera=camera;
    }


    public void update()
    {
       for(int i=0;i<gameObject.size();i++)
       {
        tempObject=gameObject.get(i);
        tempObject.update(gameObject);
       }



    }

    public void render(Graphics g)
    { 
            Entity temp;
            for(int i=0;i<levelBlock.size();i++)
            {
                temp=levelBlock.get(i);
                temp.render(g);
            }
        
        for(int i=0;i<gameObject.size();i++)
        {
            tempObject=gameObject.get(i);
            tempObject.render(g);
        }
    }

    
    public void addObject(Entity entity)
    {
       this.gameObject.add(entity);
     
    }
    public void addLevel(Entity entity)
    {
        this.levelBlock.add(entity);
    }


    public void clearLevel()
    { 
       gameObject.clear();
       levelBlock.clear();
       camera.setX(0);
       camera.setY(0);
       System.out.println("in handler clear level");
    }
    


    
}

package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.util.LinkedList;
import utilz.Constants;
import utilz.LoadSave;
import utilz.Constants.EnemyConstants;

public abstract class Enemy extends Entity {

    public int aniTick=0,enemyState,enemyType;
    public int aniIndex=0,aniSpeed=30;
    public float walkSpeed=0.5f;
    public Player player;
    public  BufferedImage[][] crabbySprite;
    public main.Handler handler;
    public boolean left=false,right=true;
    public int tiley;
    public boolean active=true;
    public boolean attackChecked;

    public int maxHealth,currentHealth;

    public Enemy(float x, float y, int width, int height, String id,int enemyType,main.Handler handler,Player player) {
        super(x, y, width, height, id);
        this.enemyType=enemyType;
        this.handler=handler;
        this.player=player;
        initHitBox();
        loadCrabbySprite(); 
        maxHealth=Constants.getMaxHealth(0);
        currentHealth=maxHealth;
      
    }

    public void newState(int enemyState)
    {
        this.enemyState=enemyState;
        aniTick=0;
        aniTick=0;
    }
    
    @Override
    public Rectangle getBounds() {
        return hitBox;
  
    }

    public boolean isActive()
    {
        return active;
    }


    @Override
    public void update(LinkedList<Entity> gameobject) {    
    }

    @Override
    public void render(Graphics g) {    
    }

    public void changeHeath(int value)
    {
        if(currentHealth<=0)
         currentHealth=0;
        else if(currentHealth>maxHealth)
        currentHealth=maxHealth;
        
    }

   
    
    public  void loadCrabbySprite()
    {   
        BufferedImage temp=LoadSave.getSprites(LoadSave.crabby);
        crabbySprite=new BufferedImage[5][9];
        for(int j=0;j<5;j++)
        {
            for(int i=0;i<9;i++)
            {
                crabbySprite[j][i]=temp.getSubimage(i*Constants.EnemyConstants.CRABBY_WIDTH_DEFAULT, j*Constants.EnemyConstants.CRABBY_HEIGHT_DEFAULT, Constants.EnemyConstants.CRABBY_WIDTH_DEFAULT, Constants.EnemyConstants.CRABBY_HEIGHT_DEFAULT);
               
            }
        }
    }

  
        
    }




    


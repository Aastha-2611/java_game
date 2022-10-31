package Entities;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import GameStates.LevelClear;
import GameStates.Playing;
import utilz.LoadSave;
import static utilz.Constants.PlayerAction.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Rectangle;
import GameState.GameScreen;
import GameState.GameScreen.State;

public class Player extends Entity {
    
    private BufferedImage[][] player;
    private BufferedImage[] healthBar;
    private int aniTick,aniIndex,aniSpeed=10,player_Action=idle;
    private boolean moving=false;
    private Boolean attacking=false;
    private boolean left,right,up,down;
    private boolean jumping =false;
    private boolean falling =true; 
    private float gravity = 0.05f;
    main.Handler handler;
    private int MAX_SPEED;
    private int healthIndex;
    public Playing playing;
    public Rectangle attackBox;
    private int flipX=0;
    private int flipW=1;
    private boolean attackChecked;
   
     public Player(float x,float y, int width, int height,main.Handler handler,String id,Playing playing) {
        super(x, y,width,height,"player");
        this.handler=handler;
        this.playing=playing;
        loadAnimation();
        initAttackBox();
        setVelY(1f);
        setVelX(2f);
        MAX_SPEED=10;
        
    }



    private void initAttackBox() {
        attackBox=new Rectangle((int)x,(int)y+20,20,20);
    }



    @Override
    public void update(LinkedList<Entity> gameobject) {
        if(healthIndex>5)
        {
        GameScreen.State.state=State.GAME_OVER;
        return;
        }
        updateHealthBar();
        updateAttackBox();
        updatePos();
        if(attacking)
        checkAttack();
        
        updateHitBox();
       
        Tick();
        setAnimation();
        

    } 

    private void checkAttack() {
        if(attackChecked||aniIndex!=1)
            return;
            attackChecked=true;
            playing.checkEnemyHit();
        
    }



    private void updateHealthBar() {
    }

    private void updateAttackBox() {
        
        if(right)
        {
         attackBox.x=(int)this.x+100;
        }
          
       else if(left)
        { 
            attackBox.x=(int)this.x+5;
        }

        attackBox.y=(int)this.y+40;
         
       
           
        
    }

    public boolean leftCollision(LinkedList<Entity> levelObject)
    {
        for(int i=0;i<handler.levelBlock.size();i++)
       {
        Entity tempObject =handler.levelBlock.get(i);
        if(tempObject.id=="block")
        {
            if(getLeftBounds().intersects(tempObject.getBounds()))
            {
                 return true;
            }
        }
       }
       return false;
    }

    public boolean topCollision(LinkedList<Entity> levelObject)
    {  
       for(int i=0;i<handler.levelBlock.size();i++)
       {
        Entity tempObject =handler.levelBlock.get(i);
        if(tempObject.id=="block")
        {
            if(getTopBounds().intersects(tempObject.getBounds()))
            {
                 return true;
            }
        }
       }
       return false;
    }

    
    public boolean RightCollision(LinkedList<Entity> levelObject)
    {  
       for(int i=0;i<handler.levelBlock.size();i++)
       {
        Entity tempObject =handler.levelBlock.get(i);
        if(tempObject.id=="block")
        {
            if(getRightBounds().intersects(tempObject.getBounds()))
            {
                 return true;
            }
        }
       }
       return false;
    }

    
    public boolean DownCollision(LinkedList<Entity> levelObject)
    {  
       for(int i=0;i<handler.levelBlock.size();i++)
       {
        Entity tempObject =handler.levelBlock.get(i);
        if(tempObject.id=="block")
        {
            if(getDownBounds().intersects(tempObject.getBounds()))
            {
                 return true;
            }
        }
       }
       return false;
    }

    public boolean LevelComplete(LinkedList<Entity> levelObject)
    {  
       for(int i=0;i<handler.levelBlock.size();i++)
       {
        Entity tempObject =handler.levelBlock.get(i);
        if(tempObject.id=="flag")
        {
            if(getRightBounds().intersects(tempObject.getBounds()))
            {
                 return true;
            }
        }
       }
       return false;
    }



    public void updatePos()
    {   moving=false;
        if(topCollision(handler.levelBlock))
        {
            velY=0;
        }
        if(falling || jumping)
         { 
            velY+=gravity;
            this.y+=velY;
            if(DownCollision(handler.levelBlock))
            {
                this.y-=3;
            }
            
            if(velY>MAX_SPEED)
            velY=MAX_SPEED;
         }

        if(DownCollision(handler.levelBlock))
        {   
             velY=0;
           falling=false;
           jumping=false;
        }
        else
        falling=true;
         
        if(left && !right)
         { if(!leftCollision(handler.levelBlock))
           {
            this.x+=-velX; 
            moving=true;
            flipX=width;
            flipW=-1;
           }
       }
        else if(!left && right)
        { if(!RightCollision(handler.levelBlock)) 
            {
                this.x+=velX;
                moving=true;
                flipX=0;
                flipW=1;
            }
        
        }

        if(LevelComplete(handler.levelBlock))
        { 
            LevelClear.lastTime=System.currentTimeMillis();
            GameScreen.State.state=GameScreen.State.LEVEL_CLEAR; 
            resetAllLevel();
            handler.clearLevel();
            handler.gameObject.add(this);
            
            playing.changeLevel();
        }

        if(y>640)
        {     
            GameScreen.State.state=GameScreen.State.GAME_OVER;
            

        }

    


        
    }

    private void setAnimation()
    {   int startAni=player_Action;
        if(moving)
        player_Action=running;
        else
        player_Action=idle;
        if(attacking){
        player_Action=attack;
        if(startAni!=attack)
        {
            aniIndex=1;
            aniTick=0;
            return;
        }
        }
       
        if(startAni!=player_Action)
        resetTick();

    }

    
    private void resetTick() {
        aniTick=0;
        aniIndex=0;
    }



    public void render(Graphics g)
    {   Graphics2D g2d = (Graphics2D) g;
        g.drawImage(player[player_Action][aniIndex], (int)x+flipX, (int)y, 128*flipW, 80, null);
       // drawHitbox(g);
       // g2d.draw(getLeftBounds());
        //g2d.draw(getRightBounds());
        //g2d.draw(getTopBounds());
        //g2d.draw(getDownBounds());
        //g2d.draw(getBounds());
    // g2d.draw(getAttackBox());

      //  g.drawImage(healthBar[0],100,100, 180, 50, null);
       

    }

    public void changeHealth()
    {
        healthIndex++;
        if(healthIndex>healthBar.length)
         { healthIndex=6;
            //gameover
         }
       else if(healthIndex<=0)
       {
        healthIndex=0;
       }
    }
  

   //LOAD ANIMATION 
    private void loadAnimation()
    {   
        BufferedImage image=LoadSave.getSprites(LoadSave.Player);
        player=new BufferedImage[9][6];
        for(int j=0;j<7;j++)
        {
            for(int i=0;i<player[j].length;i++)
            {
                player[j][i]=image.getSubimage(i*64, j*40,64,40);
            }
        }

        BufferedImage temp=LoadSave.getSprites(LoadSave.healthbar);
        healthBar=new BufferedImage[7];
        for(int j=0;j<healthBar.length;j++)
        { 
            healthBar[j]=temp.getSubimage(0, j*52,(int) temp.getWidth(),52);

        }
        
   
        
       
    }


    public boolean isLeft() {
        return left;
    }



    public void setLeft(boolean left) {
        this.left = left;
    }



    public boolean isRight() {
        return right;
    }



    public void setRight(boolean right) {
        this.right = right;
    }



    public boolean isUp() {
        return up;
    }



    public void setUp(boolean up) {
        this.up = up;
    }



    public boolean isDown() {
        return down;
    }



    public void setDown(boolean down) {
        this.down = down;
    }



    public void setBool() {
        left=false;
        right=false;
        up= false;
        down= false;
        jumping=false;
        falling=true;
    }



    public void setAttacking(boolean attacking) {
        this.attacking=attacking;
    }

    public void Tick()
    {
        aniTick++;
        if(aniTick>=aniSpeed)
        {
            aniIndex++;
            aniTick=0;
            if(aniIndex>=playerSprites(player_Action))
            {
             aniIndex=0;
             attacking=false;
             attackChecked=false;
 
            }
 
        }
   
    }
    public Rectangle getLeftBounds()
    {
        return new Rectangle((int)(x+38),(int)(y+8),(int)5,(int)(height-28));
    }
    public Rectangle getRightBounds()
    {
        return new Rectangle((int)(x+90),(int)(y+8),(int)5,(int)(height-28));
    }
    public Rectangle getTopBounds()
   {   
        return new Rectangle((int)(x+44),(int)(y+2),(int)(width-82),(int)5);
    }
    public Rectangle getDownBounds()
    {
        return new Rectangle((int)(x+44),(int)(y+60),(int)(width-82),(int)5);
    }


    public float getX()
    {
        return x;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
    
        this.jumping = jumping;
    }

    @Override
    public Rectangle getBounds() {
        
       return new Rectangle((int)(x+45),(int)(y+4),(int)(width-82),(int)(height-18));
      
    }

    public Rectangle getAttackBox() {
       return attackBox;
    }

 
    @Override
    public void resetAll() {
      setBool();
      attacking=false;
      moving=false;
      resetTick();
      healthIndex=0;
      player_Action=idle;
      jumping=false;
      falling=true;
      x=64;
      y=64;
    
    }
    public void resetAllLevel() {
      setBool();
      attacking=false;
      moving=false;
      resetTick();
      player_Action=idle;
      jumping=false;
      falling=true;
      x=64;
      y=64;
      

    }
     

    public BufferedImage[] getHealthBar() {
        return healthBar;
    }

    public int gethealthIndex() {
     return healthIndex;
    }

}


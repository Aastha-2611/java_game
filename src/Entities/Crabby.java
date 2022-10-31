package Entities;
import utilz.Constants;
import utilz.Constants.EnemyConstants;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
public class Crabby extends Enemy {

  public int walkDir=Constants.Directions.left;
  public int attackDistance=38;
  public Rectangle attackBox;
  public Crabby(int x,int y,main.Handler handler,Player player)
   {
     super(x, y,EnemyConstants.CRABBY_WIDTH_DEFAULT,EnemyConstants.CRABBY_HEIGHT_DEFAULT,"crabby",0 ,handler,player);
    
    
   }


private  Rectangle getAttackBox() {

  attackBox=new Rectangle((int)(x+3),(int)(y+10),(int)68,(int)10);
  return attackBox;
  }


public void render(Graphics g)
{ 
    
    if(this.isActive()){
    g.drawImage(crabbySprite[enemyState][aniIndex], (int)x+flipX(), (int)y, EnemyConstants.CRABBY_WIDTH_DEFAULT*flipY(), EnemyConstants.CRABBY_HEIGHT_DEFAULT, null);   
   
    }
} 


public Boolean blockInFront(int xspeed) {

  Rectangle temp=getDirBound(xspeed);

    for(int i=0;i<handler.levelBlock.size();i++)
    {
     Entity tempObject = handler.levelBlock.get(i);
    
     if(tempObject.id=="block")
     {   
         if(temp.intersects(tempObject.getBounds()))
          {  
            
             return true;
                                             
          }
      }

     }
    return false;
}

public Rectangle getBounds() {

   return new Rectangle((int)(x+25),(int)(y+7),(int)20,(int)22);
}


public void update(LinkedList<Entity> gameobject) {
  if(this.isActive())
  {
        updatePos();
        updateAnimationTick();
  }
}


public void updatePos() {

  switch(enemyState)
  {
    case EnemyConstants.IDLE:
       enemyState=EnemyConstants.RUNNING;
       break;

    case EnemyConstants.RUNNING:
      if(canSeePlayer())
        turnTowardsPlayer();   

      if(isPlayerCloseForAttack())
        newState(EnemyConstants.ATTACK);
        move();
         break;

    case EnemyConstants.HIT:
    break;

    case EnemyConstants.ATTACK:
    { if(aniIndex==0)
      attackChecked=false;
      if(aniIndex==3 && !attackChecked)
          checkPlayerHit();
          break;
    }


  }
}

private void move()
{
  float xspeed=0;
  if(walkDir==Constants.Directions.left)
    xspeed=-walkSpeed;
    else 
    xspeed=+walkSpeed;

   if(blockInFront((int)xspeed))
     { 
    if(!wallCollision((int)xspeed))
   { this.x+=xspeed; 
    return;
   }
      }
   changeWalkDir();
}

private boolean wallCollision(int xspeed) {
 
  Rectangle temp=getSideBound(xspeed);

  for(int i=0;i<handler.levelBlock.size();i++)
  {
   Entity tempObject = handler.levelBlock.get(i);
  
   if(tempObject.id=="block")
   {   
       if(temp.intersects(tempObject.getBounds()))
        {  
          
           return true;
                                           
        }
    }

   }
  return false;


}


private void changeWalkDir() {
  if(walkDir==Constants.Directions.left)
  {
    walkDir=Constants.Directions.right;
  }
  else
  walkDir=Constants.Directions.left;
}


private void updateAnimationTick()
{
    aniTick++;
    if(aniTick>=aniSpeed){
        aniTick=0;
        aniIndex++;
        if(aniIndex>=Constants.EnemyConstants.GetSpriteAmount(enemyType,enemyState))
            {          aniIndex=0;
                       if(enemyState==EnemyConstants.ATTACK)
                        newState(EnemyConstants.IDLE);
                        else if(enemyState==EnemyConstants.HIT)
                        newState(EnemyConstants.IDLE);
                        else if(enemyState==EnemyConstants.DEAD)
                        active=false;


            }
    }

}

public Rectangle getDirBound(float xspeed)
{
   if(walkDir==Constants.Directions.left)
   {
    return new Rectangle((int)(x+25+xspeed),(int)(y+24),(int)4,(int)12);
   }
   else
   return new Rectangle((int)(x+45+xspeed),(int)(y+24),(int)4,(int)12);
}

public Rectangle getSideBound(float xspeed)
{
  if(walkDir==Constants.Directions.left)
  {
   return new Rectangle((int)(x+15+xspeed),(int)(y+7),(int)3,(int)18);
  }
  else
  return new Rectangle((int)(x+53+xspeed),(int)(y+7),(int)3,(int)18);
}

public boolean canSeePlayer()
    {   int playerTileX=player.getBounds().x;
        int crabbyTileX=this.getBounds().x;  
       
        if(playerTileX>crabbyTileX){ 
          
               if(playerTileX-crabbyTileX<=attackDistance*3){
             
                   return true;      

               }
        
                  }
        if(playerTileX<crabbyTileX)
        {
          if(crabbyTileX-playerTileX<=attackDistance*3){
       
              return true;
           }
        }


        return false;
      }
    

public void turnTowardsPlayer()
{ 
  if(player.getBounds().x>this.getBounds().x)
  {
    walkDir=Constants.Directions.right;
  }
  else 
  walkDir=Constants.Directions.left;
}


public boolean isPlayerCloseForAttack()
{  int distance;
  int playerTileX=player.getBounds().x+player.getBounds().width/2;
  int crabbyTileX=this.getBounds().x+this.getBounds().width/2;  
  if(playerTileX>=crabbyTileX)
  { 
    distance=(int)(playerTileX-crabbyTileX);

    if(distance<=attackDistance)
    return true;
    else 
    return 
    false;
  }

  else
  { 
     distance=(int)(crabbyTileX-playerTileX);

     if(distance<attackDistance)
       return true;
       else
       return false;
  }
 
}

public void checkEnemyHit()
{   if(this.isActive()){
     if(player.getAttackBox().intersects(this.getBounds()))
    { this.hurt(5);
     return;}
    }
}
private void hurt(int amount) {

  currentHealth-=amount;
  if(currentHealth<=0)
  newState(EnemyConstants.DEAD);
  else
  newState(EnemyConstants.HIT);
}

public void checkPlayerHit()
{
  if(getAttackBox().intersects(player.getBounds()))
  player.changeHealth();
    attackChecked=true;
  
}


public int flipX()
{
  if(walkDir==Constants.Directions.right)
  return width;
  else 
   return -0;
}

public int flipY()
{
  if(walkDir==Constants.Directions.right)
  return -1;
  else 
  return 1;
}

public Crabby getenemy()
{
  return this;
}
@Override
public void resetAll() {
   
  currentHealth=maxHealth;
    
    newState(EnemyConstants.IDLE);
    active=true;
    aniTick=0;
    aniIndex=0;
    walkDir=Constants.Directions.left;
    

}
}















     








 

  

   

    


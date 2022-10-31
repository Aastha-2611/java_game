package GameStates;
import Entities.Crabby;
import Entities.EnemyManager;
import Entities.LevelManager;
import Entities.Player;
import GameState.GameScreen;
import main.Camera;
import main.Game;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
public class Playing extends GameStates.State  implements stateMethods{

    private Player player;
    private main.Handler handler;
    private Game game;
    private LevelManager levelManager;
    public static int LEVEL=1;
    private EnemyManager enemyManager; 
    
    public Playing(main.Handler handler, Game game) {
        super(game);

        this.handler=handler;
        this.game=game;
        initClass();
    }


    public void initClass()
    {   
        player=new Player(64, 64,(int)(64*2.0f),(int)(40*2f),handler,"player",this);
        handler.addObject(player);

        levelManager=new LevelManager(handler,game,LEVEL);
        enemyManager=new EnemyManager(handler, game,player,LEVEL);
      


    }


    public void update()
    {  
        handler.update();
    }
    
    public void render(Graphics g)
    {
        handler.render(g);
        
    }
    public Player getplayer()
    {
        return player;
    }

    public void windowLostFocus() {
        player.setBool();
    }

    public void checkEnemyHit()
    {   Crabby crabby;
        for(int i=0;i<enemyManager.list.size();i++)
        {
           crabby= enemyManager.list.get(i);
           crabby.checkEnemyHit();
        }
    
        
    }


   
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
        GameScreen.State.state=GameScreen.State.MENU;

        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            GameScreen.State.state=GameScreen.State.PAUSE;
            

        }
      
        
        if(e.getKeyChar()=='a')
         { 
           player.setLeft(true);
         }
        // if(e.getKeyChar()=='W')
         {
            player.setUp(true);
         }
         if(e.getKeyChar()=='d')
         {
        player.setRight(true);
         }
         //if(e.getKeyChar()=='S')
         {
        player.setDown(true);
         }
         if(e.getKeyChar()=='1')
         {
         player.setAttacking(true);
         }
         if(e.getKeyChar()==' '&& !player.isJumping())
         {  
            player.setJumping(true);
            player.setVelY(-4);
            
         }
        
        
    }


    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()=='a')
       player.setLeft(false);
    // if(e.getKeyChar()=='W')
    player.setUp(false);
     if(e.getKeyChar()=='d')
     player.setRight(false);
   //  if(e.getKeyChar()=='S')
    player.setDown(false);
    
    }

    public main.Handler getHandler()
    {
        return handler;
    }


    @Override
    public void mousePressed(MouseEvent e) {
    
        
    }


    @Override
    public void mouseReleased(MouseEvent e) {

        
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
  
   public EnemyManager getenemyManager()
   {
    return enemyManager;
   }



public void changeLevel() {
   LEVEL++;
   System.out.println("in playing change level");
   if(LEVEL<6)
   {   
    System.out.println("in if of playing change level");
      levelManager.levelSelect(LEVEL);
      enemyManager.getEnemy(LEVEL);
   
   }
   else
   {
    GameScreen.State.state=GameScreen.State.GAME_FINISH;
   }
   

 
}
    
public  void newGame()
{
    LEVEL=1;
  

    handler.clearLevel();
    player.resetAll();
    handler.addObject(player);
   enemyManager.getEnemy(LEVEL);
   levelManager.levelSelect(LEVEL);

}


   

 
    
}

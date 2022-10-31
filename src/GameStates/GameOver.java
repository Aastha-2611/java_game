package GameStates;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import Entities.Entity;
import java.awt.event.MouseEvent;
import GameState.GameScreen;
import main.Game;
import utilz.LoadSave;

public class GameOver extends GameStates.State implements stateMethods{

    BufferedImage temp;
    main.Handler handler;

    public GameOver(Game game,main.Handler handler) {
        super(game);
        temp=LoadSave.getSprites(LoadSave.gameover);
        this.handler=handler;
       
    }

    @Override
    public void update() {
       
        
    }

    @Override
    public void render(Graphics g) {
     g.drawImage(temp, 370, 270,200,100,null);
      
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
       if(e.getKeyCode()==KeyEvent.VK_ENTER)
       {
       GameScreen.State.state=GameScreen.State.MENU;
       for(int i=0;i<handler.gameObject.size();i++)
       {
        Entity tempEntity=handler.gameObject.get(i);
        tempEntity.resetAll();
       }
       }   
          
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
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


    
}

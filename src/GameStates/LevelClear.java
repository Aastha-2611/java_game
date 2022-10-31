package GameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import GameState.GameScreen;
import GameState.GameScreen.State;
import main.Game;
import utilz.LoadSave;
import java.awt.image.BufferedImage;

public class LevelClear extends GameStates.State implements stateMethods{

    public static double lastTime;
    BufferedImage img;



    public LevelClear(Game game) {
        super(game);
      
        img=LoadSave.getSprites(LoadSave.levelComplete);
       
    }

    public void update() {
     
           
    }

    @Override
    public void render(Graphics g) {
        System.out.println("in render level clear ");
        
       if(System.currentTimeMillis()-lastTime<=5000)
       {  System.out.println("in level clear render if"); 
          g.drawImage(img, 275, 200,400,250, null);
            
       }
       else
       { 
          GameScreen.State.state=State.PLAYING;
       }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
      
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

package inputs;

import java.awt.event.*;

import GameState.GameScreen;


import main.GamePanel;

public class Mouse implements MouseListener,MouseMotionListener{
    public GamePanel gamePanel; 
    public Mouse(GamePanel gamePanel)
    {
        this.gamePanel=gamePanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
       
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        switch(GameScreen.State.state)
        {
            case MENU :
            gamePanel.getGame().getMenu().mousePressed(e);
            break;
            case  PLAYING:
            gamePanel.getGame().getPlaying().mousePressed(e);
            break;
            default :
            break;

        }
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        switch(GameScreen.State.state)
        {
            case MENU :
            gamePanel.getGame().getMenu().mouseReleased(e);
            break;

            case  PLAYING:
            gamePanel.getGame().getPlaying().mouseReleased(e);
            break;

            default :
            break;

        }
          
    }
    @Override
    public void mouseDragged(MouseEvent e) {
       
        
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        switch(GameScreen.State.state)
        {
            case MENU :
            gamePanel.getGame().getMenu().mouseMoved(e);
            break;

            case  PLAYING:
            gamePanel.getGame().getPlaying().mouseMoved(e);
            break;

            default :
            break;

        }
        
    }
 
   
   
  
}

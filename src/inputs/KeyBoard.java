package inputs;
import java.awt.event.*;

import GameState.GameScreen;
import main.GamePanel;

public class KeyBoard implements KeyListener{
    GamePanel gamePanel;


    public KeyBoard(GamePanel gamePanel){

        this.gamePanel = gamePanel;
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch(GameScreen.State.state)
        {
            case MENU :
            gamePanel.getGame().getMenu().keyTyped(e);
            break;

            case  PLAYING:
            gamePanel.getGame().getPlaying().keyTyped(e);
            break;

            case PAUSE:
            gamePanel.getGame().getPause().keyTyped(e);
            break;

            case GAME_OVER:
            gamePanel.getGame().getGameOver().keyTyped(e);
            break;

            default :
            break;

        }
        


    } 

    @Override
    public void keyReleased(KeyEvent e){
        switch(GameScreen.State.state)
        {
            case MENU:
            gamePanel.getGame().getMenu().keyReleased(e);
            break;

            case PLAYING:
            gamePanel.getGame().getPlaying().keyReleased(e);
            break;

            case PAUSE:
            gamePanel.getGame().getPause().keyReleased(e);
            break;
            
            case GAME_OVER:
            gamePanel.getGame().getPause().keyReleased(e);
            break;


            default :
            break;

        }
       
    }    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

}

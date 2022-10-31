package main;
import java.awt.Graphics;
import javax.swing.JPanel;
import GameState.GameScreen;
import GameStates.LevelClear;
import inputs.KeyBoard;
import inputs.Mouse;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel {
    private Game game;
    public GamePanel(Game game)
    {    this.game=game;
        addKeyListener(new KeyBoard(this));
        addMouseListener(new Mouse(this));
        addMouseMotionListener(new Mouse(this));
        setSize();  
        setBackground(new Color(0,0,0));
       
      
    }
   
public void paintComponent(Graphics g) {
    
    super.paintComponent(g);

    switch(GameScreen.State.state)
    {
        case MENU:
        getGame().getMenu().render(g);
        break;

        case PLAYING:
        {
          game.render(g);
        break;
        }
        
        case PAUSE:
        {   game.render(g);
            getGame().getPause().render(g);
        }
        break;
       
        case GAME_OVER:
        {game.render(g);
        getGame().getGameOver().render(g);
         break;
        }
        case LEVEL_CLEAR:
        { 
        getGame().getLevelClear().render(g);
        break;
        }
        case GAME_FINISH:
       { getGame().getgameFinish().render(g);
        break;
       }

    
        default :
        break;
        

    }

}
    
 public void setSize()
 {  Dimension size = new Dimension(960,640);
    setPreferredSize(size);
 }
  
 public Game getGame()
 {
    return game;
 }
 

}

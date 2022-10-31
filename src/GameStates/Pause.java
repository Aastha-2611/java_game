package GameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import GameState.GameScreen;
import java.awt.image.BufferedImage;
import utilz.LoadSave;

public class Pause extends State implements stateMethods{
    BufferedImage img;
    private main.Handler handler;
    public Pause(main.Game game,main.Handler handler)
    {
        super(game);
        this.handler=handler;
        img=LoadSave.getSprites(LoadSave.pause);
    
    }

    @Override
    public void update() {
    
        
    }

    @Override
    public void render(Graphics g) {
        BufferedImage temp=img.getSubimage(80, 5, 150, 40);
        g.drawImage(temp, 300, 250,200,100,null);
     
    }

    @Override
    public void keyTyped(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {     game.getPlaying().getplayer().setBool();
            GameScreen.State.state=GameScreen.State.PLAYING;
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

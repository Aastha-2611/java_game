package GameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class GameFinish extends State implements stateMethods{

    BufferedImage img;

    public GameFinish(Game game) {
        super(game);
       img=LoadSave.getSprites(LoadSave.gameFinish);
       
    }

    @Override
    public void update() {
        
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, 150,150,500,500, null);
       

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}

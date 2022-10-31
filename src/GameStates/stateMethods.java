package GameStates;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;



public interface stateMethods {
    public void update();
    public void render(Graphics g);
    public void keyTyped(KeyEvent e);
    public void keyReleased(KeyEvent e);
    public void mousePressed(MouseEvent e);
    public void mouseReleased(MouseEvent e);
    
    public void mouseMoved(MouseEvent e);
    


   

}

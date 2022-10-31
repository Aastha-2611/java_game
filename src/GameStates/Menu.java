package GameStates;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import GameState.GameScreen.State;
import UI.MenuButtons;
import main.Game;
import utilz.LoadSave;
import java.awt.image.BufferedImage;


public class Menu extends GameStates.State implements stateMethods {

    public main.Handler handler;
    public MenuButtons[] buttons=new MenuButtons[2];
    public BufferedImage backBoxSprite;
    public BufferedImage backBox;
    public Playing playing;
    public BufferedImage backGround;
    public Menu(main.Handler handler,Game game,Playing playing) {
        super(game);
        
        this.handler=handler;
        this.playing=playing;
        initMenu();
    }
     public void initMenu()
     {
        buttons[0]=new MenuButtons(395,260 ,State.PLAYING,0,playing,0);
        buttons[1]=new MenuButtons(395, 320,State.EXIT,1,playing,1);
      
        backBoxSprite=LoadSave.getSprites(LoadSave.menuBack);
        backBox=backBoxSprite.getSubimage(10, 20, 160, 130);
        backGround=LoadSave.getSprites(LoadSave.background_menu);

     }

    @Override
    public void update() {
        for(MenuButtons mb : buttons)
        { mb.update();
        }
                
    }

 
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
        State.state=State.PLAYING;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }

    @Override
    public void render(Graphics g) {
        playing.getHandler().render(g);
        g.drawImage(backBox, 370,240,200,150,null);

         for(MenuButtons mb:buttons)
        { mb.render(g);
        }
            
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        for(MenuButtons mb:buttons)
        {
                if(isIn(e, mb))
                mb.setMousePressed(true);
                   
        }
       
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        for(MenuButtons mb:buttons)
        {
            if(isIn(e, mb))
            if(mb.isMousePressed()){ 
             if(mb.id==0)
             playing.newGame();
                 mb.applyGamestate();
            break;}
        }

        resetButtons();
        
    }
    private void resetButtons() {
        for(MenuButtons mb:buttons)
        { mb.resetBool();
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        for(MenuButtons mb:buttons)
        { 
            mb.setMouseOver(false);
        }
        for(MenuButtons mb:buttons)
        {   if(isIn(e, mb)){
             mb.setMouseOver(true);
            break;}
        }


        
    }

    


}

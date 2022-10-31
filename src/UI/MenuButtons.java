package UI;
import GameState.GameScreen.State;
import GameStates.Playing;

import java.awt.Rectangle;
import utilz.LoadSave;
import java.awt.image.BufferedImage;

import java.awt.Graphics;

public class MenuButtons {

    private int x;
    private int y;
    private int index=0;
    public State state;
    public int id;
    private boolean mouseOver=false;
    private boolean mousePressed;
   
    private Rectangle bounds;
    private BufferedImage[] img;
    private int rowIndex; 
    private Playing playing;


    public MenuButtons(int x,int y,State state,int rowIndex,Playing playing,int id)
    {
        this.x=x;
        this.y=y;
        this.id=id;
         this.state=state;
         this.playing=playing;
        this.rowIndex=rowIndex;
        loadImage();
        init();
        

    }
    public void  init()
    {
    
        bounds=new Rectangle(x,y,150,55);
    }
    public Rectangle getBounds()
    {
       return bounds;
    }

    public void loadImage()
    {  
        img=new BufferedImage[2]; 

        BufferedImage temp= LoadSave.getSprites(LoadSave.menu);
      

        for(int i=0;i<img.length;i++)
        {
            img[i]=temp.getSubimage(30+(i*150),(rowIndex*55)+95, 150, 55);
            
        }
        
    }

    public void render(Graphics g)
    {  
                g.drawImage(img[index], x, y, 150, 55, null);


    }

    public void update()
    {
        index=0;
        if(mouseOver||mousePressed)
        index=1;
    }
    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public void applyGamestate()
    {   
        State.state=state;
    }
    public void resetBool()
    {
        mouseOver=false;
        mousePressed=false;
    }
    public boolean isMousePressed() {
        return mousePressed;
    }
    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

}

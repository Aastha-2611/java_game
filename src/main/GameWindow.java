package main;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
  private JFrame frame;


  public GameWindow(GamePanel gamePanel)
  {
    frame= new JFrame();
    frame.add(gamePanel);
    frame.setResizable(false);

    frame.setTitle("frame1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.pack();
    frame.setVisible(true);
 
    }

   

  }
    


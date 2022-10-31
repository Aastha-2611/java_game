package Entities;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import utilz.LoadSave;

public class EnemyManager {

     main.Handler handler;
     main.Game game;
     public Player player;
     public Crabby  crabby;
     BufferedImage level1;
     BufferedImage level2;
     BufferedImage level3;
     BufferedImage level4;
     BufferedImage level5;
     private int LEVEL;

    public LinkedList<Crabby> list;

     public EnemyManager(main.Handler handler,main.Game game ,Player player,int LEVEL)
     {  this.player=player;
        this.handler=handler;
        this.game=game;
        this.LEVEL=LEVEL;
        level1=LoadSave.getSprites(LoadSave.Level1);
        level2=LoadSave.getSprites(LoadSave.Level2);
        level3=LoadSave.getSprites(LoadSave.Level3);
        level4=LoadSave.getSprites(LoadSave.Level4);
        level5=LoadSave.getSprites(LoadSave.Level5);
        list=new LinkedList<Crabby>();
        getEnemy(LEVEL);
        
      
     }

     public void getEnemy(int LEVEL)
     {  System.out.println("in get enemy:"+LEVEL);
        list.clear();
        System.out.println("list element is:"+list.size());
        switch(LEVEL)
        {
            case 1:
            loadCrabby(level1);
            break;
            case 2:
            System.out.println("in case 2 if get enemy");
           loadCrabby(level2);
            break;
            case 3:
            System.out.println("in case 3 if get enemy");
           loadCrabby(level3);
            break;
            case 4:
            System.out.println("in case 4 if get enemy");
           loadCrabby(level4);
            break;
            case 5:
            System.out.println("in case 5 if get enemy");
           loadCrabby(level5);
            break;
          
            default:
            System.exit(1);
        }
     }



     

     
     public void loadCrabby(BufferedImage level)
     {  
          System.out.println("in load crabby  :");
         
        
         int h= level.getHeight();
         int w=level.getWidth();
         for(int i=0;i<w;i++)
         {   
             for(int j=0;j<h;j++)
             {
                 int pixel=level.getRGB(i, j);
                 int red=(pixel>>16) & 0xff;
                 int green =(pixel>>8) & 0xff;
                 int blue=(pixel) & 0xff;
 
                 if(red==0 && blue==255&& green==0)
                 { 
                 crabby=new Crabby(i*32,j*32,handler,player);
                 handler.addObject(crabby);   
                  list.add(crabby);
                 }     
             }
         }
     }
    
    
    

}

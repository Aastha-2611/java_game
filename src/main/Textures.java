package main;
import java.awt.image.BufferedImage;

import utilz.LoadSave;

public class Textures {

   private  BufferedImage  blockImage;
   public BufferedImage clouds;
   public BufferedImage[] block_type =new BufferedImage[2];

   public BufferedImage flag;


   public Textures(){
     blockImage= LoadSave.getSprites(LoadSave.Platform_blocks);
    flag=LoadSave.getSprites(LoadSave.flag);
    clouds =LoadSave.getSprites(LoadSave.clouds);
    
     getTextures();
   }

   public void getTextures()
   {
       block_type[0]=blockImage.getSubimage(260, 418, 32, 32);
   

      
      
   }


    
}

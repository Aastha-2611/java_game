package utilz;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class LoadSave {

    public static String Player="/res/player_sprites.png";
       public static String Block="/res/block.png";
       public static String Level_One ="/res/Level_One.png";
       public static String Platform_blocks="/res/Platform_blocks.jpg";
       public static String clouds ="/res/clouds.png";
       public static String menu ="/res/menu.jpg";
       public static String pause="/res/continueSprite.png";
       public static String menuBack="/res/menuback.jpg";
       public static String crabby ="/res/crabby_sprite.png";
       public static String healthbar ="/res/healthbar.jpg";
       public static String gameover ="/res/gameover.png";
       public static String flag="/res/flag.png";
       public static String levelComplete="/res/levelcomplete.png";
       public static String background_menu="/res/background_menu.png";
       public static String gameFinish="/res/gameFinish.png";
       public static String cloudsDay="/res/clouds_day.png";
       public static String Level1="/res/level1.png";
       public static String Level2="/res/level2.png";
       public static String Level3 ="/res/level3.png";
       public static String Level4 ="/res/level3.png";
       public static String Level5 ="/res/level3.png";
       

    public static BufferedImage getSprites(String string){
        BufferedImage image =null;
         InputStream is= LoadSave.class.getResourceAsStream(string);
         try { 
           
           image=ImageIO.read(is);
         
        }  catch (IOException e) {
         
            e.printStackTrace();
        } 
        finally{
           try {
                is.close();
            } catch (IOException e){
             e.printStackTrace();
            }
        }
        
         return image;

    

    }

  
    
}

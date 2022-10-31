package Entities;

import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class LevelManager {

    private main.Handler handler;
    BufferedImage Level1;
    BufferedImage Level2;
    BufferedImage Level3;
    BufferedImage Level4;
    BufferedImage Level5;
    public int LEVEL;

    public LevelManager(main.Handler handler, Game game, int LEVEL) {
        this.handler = handler;
        this.LEVEL = LEVEL;
        Level1 = LoadSave.getSprites(LoadSave.Level1);
        Level2 = LoadSave.getSprites(LoadSave.Level2);
        Level3 = LoadSave.getSprites(LoadSave.Level3);
        Level4 = LoadSave.getSprites(LoadSave.Level4);
        Level5 = LoadSave.getSprites(LoadSave.Level5);

        levelSelect(LEVEL);

    }

    public void levelSelect(int LEVEL) {
        System.out.println("in leavel manager level select:   " + LEVEL);
        switch (LEVEL) {
            case 1:
                loadLevel(Level1);
                break;
            case 2:
                System.out.println("in case 2");
                loadLevel(Level2);
                break;
            case 3:
                System.out.println("in case 3");
                loadLevel(Level3);
                break;

            case 4:
                System.out.println("in case 4");
                loadLevel(Level4);
                break;
           
            case 5:
                System.out.println("in case 5");
                loadLevel(Level5);
                break;

            default:
                System.exit(1);
        }

    }

    public void loadLevel(BufferedImage level) {
        System.out.println("in load level :"+LEVEL);

        int h = level.getHeight();
        int w = level.getWidth();
        System.out.println("width" + w + "height" + h);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {System.out.println("i" + i + "  j" + j);
                int pixel = level.getRGB(i,j);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if (red == 255 && blue == 255 && green == 255)
                    handler.addLevel(new Level(i * 32, j * 32, 32, 32, "block", 0));
                if (red == 0 && blue == 0 && green == 255)
                    handler.addLevel(new Flag(i * 32, j * 32, 100, 150, "flag"));

            }
        }
    }

}

package main;

import Entities.Level;
import Entities.LevelManager;
import GameState.GameScreen;
import GameStates.GameFinish;
import GameStates.GameOver;
import GameStates.LevelClear;
import GameStates.Menu;
import GameStates.Pause;
import GameStates.Playing;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
    public GameWindow gameWindow;
    public GamePanel gamePanel;
    private int frameSet = 120;
    private Thread thread;
    private int updateSet = 200;
    public static long last;
    public static long previousCheck;
    public LevelManager levelManager;
    public Handler handler;
    public GameFinish gameFinish;
    public Camera camera;
    public Level level;
    public static Textures tex;
    public Playing playing;
    public Menu menu;
    public Pause pause;
    public GameOver gameOver;
    public LevelClear levelClear;
    public BufferedImage[] healthBar;
    public int healthIndex;
    private final static int TILE_DSIZE = 32;
    private final static float SCALE = 2.0f;
    public final static int TILES_IN_WIDTH = 30;
    public final static int TILES_IN_HEIGHT = 20;
    public final static int TILE_SIZE = (int) (TILE_DSIZE * SCALE);
    public final static int GAME_WIDTH = TILE_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILE_SIZE * TILES_IN_HEIGHT;

    public Game() {
        initClass();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        startGameLoop();

    }

    private void initClass() {

        tex = new Textures();
        camera = new Camera(0, 0);
        handler = new Handler(camera);
        playing = new Playing(handler, this);
        menu = new Menu(handler, this, playing);
        pause = new Pause(this, handler);
        gameOver = new GameOver(this, handler);
        levelClear = new LevelClear(this);
        gameFinish = new GameFinish(this);

    }

    private void update() {
        switch (GameScreen.State.state) {
            case MENU:
                menu.update();
                break;

            case PLAYING: {
                playing.update();
                for (int i = 0; i < handler.gameObject.size(); i++) {
                    if (handler.gameObject.get(i).id == "player") {
                        camera.update(handler.gameObject.get(i));
                    }

                }

            }
                break;

            case PAUSE:
                pause.update();
                break;

            case GAME_OVER: {
                gameOver.update();
                break;
            }

            case LEVEL_CLEAR:
                levelClear.update();
                break;

            case GAME_FINISH:
                gameFinish.update();
                break;

            case EXIT:
            default:
                System.exit(0);
                break;
        }

    }

    public void render(Graphics g) {
        healthBar = getPlaying().getplayer().getHealthBar();
        healthIndex = getPlaying().getplayer().gethealthIndex();
        Graphics2D g2d = (Graphics2D) g;

        g2d.translate(camera.getX(), camera.getY());
        for (int x = 50; x < 500 * 10; x += 600)
            g.drawImage(tex.clouds, x, 20, 500, 400, null);
        g.drawImage(healthBar[healthIndex], -(int) camera.getX() + 40, (int) (camera.getY() + 38), 180, 50, null);
        playing.render(g);

        g2d.translate(-camera.getX(), -camera.getY());

    }

    private void startGameLoop() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        double updatesPerSecond = 1000000000 / updateSet;
        double timePerFrame = 1000000000 / frameSet;
        last = System.currentTimeMillis();
        previousCheck = System.nanoTime();

        double deltaU = 0;
        double deltaR = 0;

        int updates = 0;
        int frames = 0;

        while (true)

        {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousCheck) / updatesPerSecond;
            deltaR += (currentTime - previousCheck) / timePerFrame;
            previousCheck = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;

            }

            if (deltaR >= 1) {
                gamePanel.repaint();

                frames++;
                deltaR--;
            }

            if (System.currentTimeMillis() - last >= 1000) {
                System.out.println("fps is: " + frames);

                last = System.currentTimeMillis();
                frames = 0;
                updates = 0;

            }

        }
    }

    public Camera getCamera() {
        return camera;
    }

    public static Textures getInstance() {
        return tex;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Handler gethHandler() {
        return handler;
    }

    public Menu getMenu() {
        return menu;
    }

    public Pause getPause() {
        return pause;
    }

    public GameOver getGameOver() {
        return gameOver;
    }

    public LevelClear getLevelClear() {
        return levelClear;
    }

    public GameFinish getgameFinish() {
        return gameFinish;
    }

}

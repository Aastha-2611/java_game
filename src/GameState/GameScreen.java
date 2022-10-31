package GameState;

public class GameScreen {

    public enum State{
        GAME_OVER,
        PLAYING,
        EXIT,
        PAUSE,
        MENU,
        LEVEL_CLEAR,
        GAME_FINISH;
         public static State state = MENU;
    }


    
}

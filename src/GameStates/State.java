package GameStates;
import java.awt.event.MouseEvent;

import UI.MenuButtons;
import main.Game;

public class State {

    protected Game game;

    public State(Game game)
    {
        this.game=game;
    }

    public boolean isIn(MouseEvent e, MenuButtons mb)
    {
        return mb.getBounds().contains(e.getX(),e.getY());
    }
    
}

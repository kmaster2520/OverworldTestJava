package gamestate;

import java.util.Stack;

/**
 * Created by Sathvik on 12/4/17.
 * Handles game states
 */
public class GameStateManager {

    private Stack<GameState> gsm;

    public GameStateManager() {
        gsm = new Stack<>();
    }

    public void push(GameState gs) {
        gsm.push(gs);
    }

    public void pop() {
        gsm.pop();
    }

    public void set(GameState gs) {
        pop();
        push(gs);
    }

    public GameState get() {
        return gsm.peek();
    }

    public boolean isEmpty() {
        return gsm.isEmpty();
    }
}

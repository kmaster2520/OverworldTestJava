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

    /**
     * adds new gamestate to stack
     * @param gs new gamestate
     */
    public void push(GameState gs) {
        gsm.push(gs);
    }

    /**
     * removes top gamestate
     */
    public void pop() {
        gsm.pop();
    }

    /**
     * replaces top gamestate
     * @param gs the new gamestate
     */
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

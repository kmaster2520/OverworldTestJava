package gamestate;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Sathvik on 12/4/17.
 */
public interface GameState {

    /**
     * Called every frame
     * @param now the current timestamp in nanoseconds
     */
    public void tick(long now);

    /**
     * Draws objects to screen
     * @param g the Graphics object
     */
    public void render(Graphics g);

    // handles events
    default void handleKeyPress(KeyEvent e) { }
    default void handleKeyRelease(KeyEvent e) { }
    default void handleKeyType(KeyEvent e) { }

}

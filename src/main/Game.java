package main;

import gamestate.GameStateManager;
import gamestate.MainState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Sathvik on 12/5/17.
 */
public class Game extends JPanel {



    public static final int WIDTH = 800;
    public static final int HEIGHT = 640;

    private GameStateManager gsm;

    public Game() {

        gsm = new GameStateManager();
        gsm.push(new MainState());

        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                gsm.get().handleKeyType(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                gsm.get().handleKeyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gsm.get().handleKeyRelease(e);
            }
        };

        addKeyListener(listener);
        setFocusable(true);


    }

    public void tick(long now) {
        gsm.get().tick(now);
    }


    public void paint(Graphics g) {
        super.paint(g);
        gsm.get().render(g);
    }

}

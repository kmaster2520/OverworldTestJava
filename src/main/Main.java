package main;

import assets.Assets;

import javax.sql.rowset.spi.SyncFactory;
import javax.swing.*;

/**
 * Created by Sathvik on 12/5/17.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Assets.init();
        Game game = new Game();

        JFrame frame = new JFrame("Overworld Test Java");
        frame.add(game);
        frame.setSize(Game.WIDTH, Game.HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game.setFocusable(true);
        game.requestFocusInWindow();


        long lastTime = 0;
        int fps = 60;
        long tpf = 1000000000 / fps;
        long now;

        while (true) {
            now = System.nanoTime();
            if (now - lastTime >= tpf) {
                game.tick(now);
                game.repaint();
                lastTime = now;
            }
            //Thread.sleep(10);
        }
    }
}

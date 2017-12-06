package gamestate;

import assets.Assets;
import main.Game;
import map.TileMap;
import util.Camera;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Sathvik on 12/4/17.
 */
public class MainState implements GameState {

    private Camera cam;

    private int bx, by, bspd;
    private TileMap tileMap;

    private boolean playerUp, playerDown, playerLeft, playerRight;

    public MainState() {
        cam = new Camera(0, 0);
        bx = 32;
        by = 32;
        bspd = 4;

        tileMap = Assets.tileMap("map3");
    }

    @Override
    public void tick(long now) {
        if (playerUp) {
            by -= bspd;
            cam.shiftY(bspd);
        }
        if (playerDown) {
            by += bspd;
            cam.shiftY(-bspd);
        }
        if (playerRight) {
            bx += bspd;
            cam.shiftX(-bspd);
        }
        if (playerLeft) {
            bx -= bspd;
            cam.shiftX(bspd);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g.translate((int) cam.getX(), (int) cam.getY());

        tileMap.drawTiles(g);

        g.translate((int) -cam.getX(), (int) -cam.getY());

        g.setColor(Color.red);
        g.fillRect(384, 320, 32, 32);
    }

    @Override
    public void handleKeyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                playerUp = true;
                playerDown = false;
                break;
            case KeyEvent.VK_A:
                playerLeft = true;
                playerRight = false;
                break;
            case KeyEvent.VK_S:
                playerUp = false;
                playerDown = true;
                break;
            case KeyEvent.VK_D:
                playerLeft = false;
                playerRight = true;
                break;
            default:
                break;
        }
    }

    @Override
    public void handleKeyRelease(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                playerUp = false;
                break;
            case KeyEvent.VK_A:
                playerLeft = false;
                break;
            case KeyEvent.VK_S:
                playerDown = false;
                break;
            case KeyEvent.VK_D:
                playerRight = false;
                break;
            default:
                break;
        }
    }
}

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

    private int bspd;
    private TileMap tileMap;

    private boolean playerUp, playerDown, playerLeft, playerRight;
    private int playerx, playery, playerw;

    public MainState() {
        cam = new Camera(0, 0);
        bspd = 4;

        playerx = 384;
        playery = 320;
        playerw = 32;

        tileMap = Assets.tileMap("map3");
    }

    @Override
    public void tick(long now) {
        int ax = (int) (playerx + cam.getX());
        int ay = (int) (playery + cam.getY());
        if (playerUp) {
            if (!tileMap.doesOverlapSolid(ax, ay - bspd, playerw, playerw))
            cam.shiftY(-bspd);
        }
        if (playerDown) {
            if (!tileMap.doesOverlapSolid(ax, ay + bspd, playerw, playerw))
            cam.shiftY(bspd);
        }
        if (playerRight) {
            if (!tileMap.doesOverlapSolid(ax + bspd, ay, playerw, playerw))
            cam.shiftX(bspd);
        }
        if (playerLeft) {
            if (!tileMap.doesOverlapSolid(ax - bspd, ay, playerw, playerw))
            cam.shiftX(-bspd);
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g.translate((int) -cam.getX(), (int) -cam.getY());

        tileMap.drawTiles(g, (int) cam.getX(), (int) cam.getY(), Game.WIDTH, Game.HEIGHT);

        g.translate((int) cam.getX(), (int) cam.getY());

        g.setColor(Color.red);
        g.fillRect(playerx, playery, playerw, playerw);
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

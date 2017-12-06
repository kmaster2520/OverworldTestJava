package map;

import java.awt.image.BufferedImage;

/**
 * Created by Sathvik on 11/27/17.
 */
public class Tile {

    private BufferedImage image;
    private int w;
    private int h;
    private int x;
    private int y;
    private boolean isSolid;

    public Tile(BufferedImage image, int x, int y, int w, int h, boolean isSolid) {
        this.image = image;
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.isSolid = isSolid;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSolid() {
        return isSolid;
    }
}

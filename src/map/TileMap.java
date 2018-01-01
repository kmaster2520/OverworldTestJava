package map;

import assets.Assets;
import javafx.scene.image.ImageView;
import main.Game;
import util.ImageLoader;
import util.PathJoiner;
import util.TextFileReader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sathvik on 11/27/17.
 */
public class TileMap {

    private String name; // name used to find map file
    private String title; // title of map
    private SpriteSheet spriteSheet; // sprite sheet id

    private Map<Point, Tile> tiles;

    public TileMap(String name, String... options) {
        this.name = name;

        File file = PathJoiner.getFile("res", "maps", name + ".txt");
        //System.out.println(file.toString());
        try {
            TextFileReader fr = new TextFileReader(file);
            this.title = fr.readLine();
            //
            this.spriteSheet = Assets.spriteSheet(fr.readLine()); // find spritesheet
            int tileSizeW = spriteSheet.getTileSizeW();
            int tileSizeH = spriteSheet.getTileSizeH();

            this.tiles = new HashMap<>();
            // read tiles
            int x = -1;
            int y = 0;
            char ch = (char) fr.read();
            while (ch > 0 && ch < 128) {
                //System.out.print(ch);
                x++;
                if (ch == '\n') {
                    y++;
                    x = -1;
                } else if (ch == ' ') {
                    ch = (char) fr.read();
                    continue; // ignore spaces
                }
                BufferedImage img = spriteSheet.getImageForChar(ch);
                if (img == null) {
                    ch = (char) fr.read();
                    continue; // continue if no image found for char
                }
                //
                tiles.put(new Point(x * tileSizeW, y * tileSizeH),
                        new Tile(img, x * tileSizeW, y * tileSizeH, tileSizeW, tileSizeH, false ));

                ch = (char) fr.read();
            }

            fr.close();
            //System.out.println();



        } catch (IOException e) {
            System.out.println("File not found: " + file.toString());
        }
    }

    public Map<Point, Tile> getTiles() {
        return tiles;
    }

    public void drawTiles(Graphics g) {
        for (Point p : tiles.keySet()) {
            g.drawImage(tiles.get(p).getImage(), p.x, p.y, null);
        }
    }

    public void drawTiles(Graphics g, int cx, int cy, int cw, int ch) {
        for (Point p : tiles.keySet()) {
            if (cx <= p.x + tiles.get(p).getWidth() && p.x < cx + cw && cy <= p.y + tiles.get(p).getHeight() && p.y <= cy + ch) {
                g.drawImage(tiles.get(p).getImage(), p.x, p.y, null);
            }
        }
    }


}

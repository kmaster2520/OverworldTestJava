package map;

import util.ImageLoader;
import util.PathJoiner;
import util.TextFileReader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.function.BooleanSupplier;

/**
 * Created by Sathvik on 11/27/17.
 *
 * Contains the set of tiles that are used for making maps.
 */
public class SpriteSheet {

    private int tileSizeW;
    private int tileSizeH;
    private String name;
    private BufferedImage image;

    private Map<Character, BufferedImage> charConversions;
    private Map<Character, Boolean> solidConversions;

    /**
     * Creates Spritesheet with name and tile size
     * @param name the unique id for this spritesheet
     * @param tileSizeW horizontal width of a tile
     * @param tileSizeH vertical height of a tile
     */
    public SpriteSheet(String name, int tileSizeW, int tileSizeH) {
        this.name = name;
        this.tileSizeW = tileSizeW;
        this.tileSizeH = tileSizeH;

        // read spritesheet
        File file = PathJoiner.getFile("res", "spritesheets", name + ".png");
        try {
            this.image = ImageLoader.loadImage(file);
        } catch (IOException e) {
            System.out.println("File not found: " + file.toString());
        }

        // get conversions from chars to tile images
        File convertFile = PathJoiner.getFile("res", "spritesheetconversions", name + ".txt");
        charConversions = new HashMap<>();
        solidConversions = new HashMap<>();
        try {
            TextFileReader fr = new TextFileReader(convertFile);
            char ch = (char) fr.read();
            fr.read(); // read empty space after char
            while (ch > 0 && ch < 128) {
                int r = fr.readInt();
                int c = fr.readInt();
                boolean isSolid = fr.readInt() == 1;
                BufferedImage tileImg = getTileAt(r, c);
                charConversions.put(ch, tileImg); // map char to tile image
                solidConversions.put(ch, isSolid); // map char to is solid
                //
                ch = (char) fr.read();
                fr.read();
            }
            System.out.println(charConversions);
            System.out.println(solidConversions);
            fr.close();
        } catch (IOException e) {
            System.out.println("File not found: " + convertFile.toString());
        }

    }

    /**
     * returns one tile from the larger spritesheet
     * @param r row
     * @param c column
     * @return tile image at a given row and column
     */
    public BufferedImage getTileAt(int r, int c) {

        return image.getSubimage(c * tileSizeW, r * tileSizeH, tileSizeW, tileSizeH);
    }

    /**
     * Returns tile image for text char
     * @param c the character to convert
     * @return image
     */
    public BufferedImage getImageForChar(char c) {
        return charConversions.get(c);
    }

    public boolean isSolidChar(char c) {
        return solidConversions.get(c);
    }

    public int getTileSizeW() {
        return tileSizeW;
    }

    public int getTileSizeH() {
        return tileSizeH;
    }
}
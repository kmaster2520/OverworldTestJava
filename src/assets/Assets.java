package assets;

import javafx.scene.image.Image;
import map.SpriteSheet;
import map.TileMap;
import util.ImageLoader;
import util.PathJoiner;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sathvik on 11/27/17.
 *
 * A list of Assets in one class for easy access.
 */
public class Assets {

    private static Map<String, SpriteSheet> spriteSheets;
    private static Map<String, TileMap> tileMaps;

    public static BufferedImage playerImage;

    /**
     * Initializes assets
     */
    public static void init() {
        spriteSheets = new HashMap<>();
        tileMaps = new HashMap<>();
        //
        System.out.println("initializing assets");
        initSpriteSheets();
        initTileMaps();

        try {
            playerImage = ImageLoader.loadImage(PathJoiner.getFile("res", "sprites", "player.png"));
        } catch (IOException e) {}

    }

    /**
     * Initialize Spritesheets
     */
    private static void initSpriteSheets() {
        System.out.println("initializing spritesheets");
        spriteSheets.put("fantasy", new SpriteSheet("fantasy", 32, 32));
    }

    /**
     * Initialize Tilemaps
     */
    private static void initTileMaps() {
        System.out.println("initializing tilemaps");
        tileMaps.put("map1", new TileMap("map1"));
        tileMaps.put("map2", new TileMap("map2"));
        tileMaps.put("map3", new TileMap("map3"));
    }

    /**
     *
     * @param name
     * @return spritesheet with name
     */
    public static SpriteSheet spriteSheet(String name) {
        return spriteSheets.get(name);
    }

    /**
     *
     * @param name
     * @return tilemap with name
     */
    public static TileMap tileMap(String name) {
        return tileMaps.get(name);
    }
}

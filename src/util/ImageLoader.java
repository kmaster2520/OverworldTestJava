package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sathvik on 11/27/17.
 *
 * The ImageLoader class handles the code for
 * loading image files.
 */
public class ImageLoader {

    /**
     * Loads image from a file location
     * @param file the image file
     * @return the image at the file location
     * @throws IOException if image cannot be loaded properly
     */
    public static BufferedImage loadImage(File file) throws IOException {
        return ImageIO.read(file);
    }
}

package util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Sathvik on 11/27/17.
 *
 * Different operating systems use different path separators
 * in their file paths e.g. Windows uses '\' while Mac uses '/'.
 * The PathJoiner class is used to automatically create the path
 * and make it work regardless of the OS.
 */
public class PathJoiner {

    /**
     * creates file path from components
     * @param first root resource directory
     * @param args file path components
     * @return file with given path
     */
    public static File getFile(String first, String... args) {
        return Paths.get(first, args).toFile();
    }

    /**
     * creates path from components
     * @param first root resource directory
     * @param args file path components
     * @return path
     */
    public static Path getPath(String first, String... args) {
        return Paths.get(first, args);
    }

}

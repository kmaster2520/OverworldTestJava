package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Sathvik on 11/27/17.
 *
 * Can read integers (BufferedReader alone can't)
 */
public class TextFileReader extends BufferedReader {

    public TextFileReader(File file) throws IOException {
        super(new FileReader(file));
    }

    /**
     * Reads an integer (character after int is also read and discarded)
     * @return int value
     * @throws IOException
     */
    public int readInt() throws IOException {
        int value = 0;
        char c = (char) read();
        while (c >= '0' && c <= '9') {
            value = value * 10 + (c - '0');
            c = (char) read();
        }
        return value;
    }

}

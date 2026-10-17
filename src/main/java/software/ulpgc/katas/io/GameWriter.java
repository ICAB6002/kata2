package software.ulpgc.katas.io;

import java.io.IOException;
import java.util.Map;

public interface GameWriter {
    void write(Map<String, Integer> data) throws IOException;
}
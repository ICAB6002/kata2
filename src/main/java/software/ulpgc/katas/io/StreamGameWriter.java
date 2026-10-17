package software.ulpgc.katas.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class StreamGameWriter implements GameWriter {
    private final OutputStream outputStream;

    public StreamGameWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(Map<String, Integer> data) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("=== Recuento de juegos por Plataforma ===\n");
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            builder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        outputStream.write(builder.toString().getBytes(StandardCharsets.UTF_8));
    }
}
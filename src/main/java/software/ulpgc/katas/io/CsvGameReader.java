package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Game;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvGameReader implements GameReader {
    private final InputStream inputStream;
    private final boolean isRemoteFormat;

    public CsvGameReader(InputStream inputStream, boolean isRemoteFormat) {
        this.inputStream = inputStream;
        this.isRemoteFormat = isRemoteFormat;
    }

    @Override
    public List<Game> read() {
        List<Game> games = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                try {
                    if (isRemoteFormat) {
                        games.add(parseUrlCsv(line));
                    } else {
                        games.add(parseLocalCsv(line));
                    }
                } catch (Exception e) {
                    System.err.println("Fila inválida ignorada: " + line);
                }
            }
        } catch (Exception e) {
            System.err.println("Error fatal al leer el flujo de datos: " + e.getMessage());
        }
        return games;
    }

    private Game parseLocalCsv(String line) {
        String[] fields = line.split(",");
        String name = fields[1];
        String platform = fields[2];
        int year = fields[3].equals("N/A") ? 0 : Integer.parseInt(fields[3]);
        String publisher = fields[5];
        double sales = Double.parseDouble(fields[10]);
        return new Game(name, platform, year, publisher, sales);
    }

    private Game parseUrlCsv(String line) {
        String[] fields = line.split(",");
        String name = fields[0];
        String platform = fields[1];
        int year = fields[2].equals("N/A") ? 0 : Integer.parseInt(fields[2]);
        String publisher = fields[4];
        double sales = Double.parseDouble(fields[9]);
        return new Game(name, platform, year, publisher, sales);
    }
}
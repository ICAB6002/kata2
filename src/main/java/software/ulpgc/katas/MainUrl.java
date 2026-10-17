package software.ulpgc.katas;

import software.ulpgc.katas.io.CsvGameReader;
import software.ulpgc.katas.io.StreamGameWriter;
import software.ulpgc.katas.logic.GameProcessor;
import software.ulpgc.katas.model.Game;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class MainUrl {
    public static void main(String[] args) {
        try {
            URL url = URI.create("https://gist.githubusercontent.com/starquell/f5dffe3b9d410773c7dc04f2d586c090/raw/c3a765b6d0288aeca50cfc82b93214f3570f80a0/video_games_sales.csv").toURL();

            try (InputStream in = url.openStream()) {
                // true => parseUrlCsv
                CsvGameReader reader = new CsvGameReader(in, true);
                List<Game> games = reader.read();

                GameProcessor processor = new GameProcessor();
                Map<String, Integer> stats = processor.countByPlatform(games);

                System.out.println("Ejecución URL: Resultados por consola\n");
                StreamGameWriter writer = new StreamGameWriter(System.out);
                writer.write(stats);
            }
        } catch (Exception e) {
            System.err.println("Error fatal en la ejecución remota: " + e.getMessage());
        }
    }
}
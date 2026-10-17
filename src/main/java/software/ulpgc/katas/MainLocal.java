package software.ulpgc.katas;

import software.ulpgc.katas.io.CsvGameReader;
import software.ulpgc.katas.io.StreamGameWriter;
import software.ulpgc.katas.logic.GameProcessor;
import software.ulpgc.katas.model.Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

public class MainLocal {
    public static void main(String[] args) {
        File inputFile = new File("gamesales.csv");
        if (!inputFile.exists()) {
            System.err.println("Error: El fichero " + inputFile.getAbsolutePath() + " no existe.");
            return;
        }

        try (FileInputStream in = new FileInputStream(inputFile);
             FileOutputStream out = new FileOutputStream("resultados.txt")) {

            // false => parseLocalCsv
            CsvGameReader reader = new CsvGameReader(in, false);
            List<Game> games = reader.read();

            GameProcessor processor = new GameProcessor();
            Map<String, Integer> stats = processor.countByPlatform(games);

            StreamGameWriter writer = new StreamGameWriter(out);
            writer.write(stats);

            System.out.println("Ejecución Local: Proceso finalizado. Resultados en resultados.txt");
        } catch (Exception e) {
            System.err.println("Error fatal en la ejecución local: " + e.getMessage());
        }
    }
}
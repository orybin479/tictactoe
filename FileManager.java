package src.src.games.utilities;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public static void writeToFile(String saveState, String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(saveState);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

        public static void writeToFileAsync (String saveState, String fileName){
            new Thread(() -> writeToFile(saveState,fileName)).start();
        }

}


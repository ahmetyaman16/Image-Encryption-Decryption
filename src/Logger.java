import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static final String DIRECTORY_PATH = "C:/Users/yaman/Desktop/";
    private static final String FILE_NAME = "logfile.txt";

    public static void log(String content) {
        try {
            File file = new File(DIRECTORY_PATH + "/" + FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(content);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package hw27.rwMethods;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWriteMethods {
    // список найденных текстовых файлов
    static private final List<File> fileList = new ArrayList<>();

    public static void searchFiles(File path) {
        if (path.isFile() && path.getPath().contains(".txt")) {
            fileList.add(path);
        } else if (path.isDirectory()) {
            for (File oneFile : path.listFiles()) {
                searchFiles(oneFile);
            }
        }
    }

    public static List<File> textFilesList(File path) {
        searchFiles(path);
        return fileList;
    }

    public static void findPattern(File file, String patternString) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("Файл не найден");
        }
        Pattern pattern = Pattern.compile(patternString);

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file.getPath()));
            String line = reader.readLine();
            int matches = 0;
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()){
                    matches++;
                }
//                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
            System.out.println("Найдено соответствий: "+matches);

            System.out.println();
        } catch (
                java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
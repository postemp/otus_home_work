package main.java.hw27_1.rwMethods;


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
        fileList.clear();
        searchFiles(path);
        return fileList;
    }

    public static int findPattern(File file, String patternString) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("Файл не найден");
        }
        Pattern pattern = Pattern.compile(patternString);

        int matches = 0;

//        BufferedReader reader;
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {

            String line = reader.readLine();

            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    matches++;
                }
//                System.out.println(line);
                line = reader.readLine();
            }
//            reader.close();
            return matches;


        } catch (
                java.io.IOException e) {
            e.printStackTrace();
        }
        return matches;
    }

}
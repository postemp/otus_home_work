package hw18.rwMethods;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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

    public static List<File> textFilesList(File path){
        searchFiles(path);
        return fileList;
    }

    public static void showFileContext(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("Файл не найден");
        }
        try (
             FileInputStream inF = new FileInputStream(file.getPath());
             BufferedInputStream inB = new BufferedInputStream(inF);
             InputStreamReader in = new InputStreamReader(inB)) {
            char[] buf = new char[100];
            int n = in.read(buf);
            while (n> 0) {
                for (int i = 0; i < n; i++) {
                    System.out.print(buf[i]);
                }
                n = in.read(buf);
            }
            System.out.println();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }


    public static boolean writeStringToFile(File fileToWrite, String whatToWrite) {
        whatToWrite = "\n" + whatToWrite;
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileToWrite, true))) {
            byte[] buffer = whatToWrite.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
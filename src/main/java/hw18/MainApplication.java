package hw18;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    // список найденных текстовых файлов
    static List<File> fileList = new ArrayList<>();
    public static void main(String[] args) {
        File file = new File("./src");
        // ищем текстовые файлы,что бы их показать
        textFilesList(file);
        System.out.println("Найдены файлы: "+fileList);
        System.out.println("Введите имя файла из этого списка, который вы хотите прочитать:"  );
        String fileToReadString = readFromConsole();
        System.out.println("Показываем содержимое файла " +fileToReadString+ " в консоли:");
        File fileToReadWrite = new File(fileToReadString);
        if (!showFileContext(fileToReadWrite)){
            System.out.println("Такой файл не найден");
            return;
        }
        System.out.println("Напечaтайте строку, которую вы хотите добавить в файл");
        String whatToWriteString = readFromConsole();
        if (writeStringToFile(fileToReadWrite, whatToWriteString)) {
            System.out.println("Файл успешно записан");
        } else {
            System.out.println("Произошла ошибка при записи файла");
        }
    }

    public static void textFilesList(File path) {
        if (path.isFile() && path.getPath().contains(".txt")) {
            fileList.add(path);
        } else if (path.isDirectory()) {
            for (File oneFile : path.listFiles()) {
                textFilesList(oneFile);
            }
        }
    }

    public static String readFromConsole(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("Введите называние файла, который вы хотите прочитать: ");
            return reader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean showFileContext(File file) {
        if (!file.exists()) {
            return false;
        }
        try (   FileInputStream inF = new FileInputStream(file.getPath());
                BufferedInputStream inB = new BufferedInputStream(inF);
                InputStreamReader in = new InputStreamReader(inB)) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean writeStringToFile(File fileToWrite, String whatToWrite) {
        whatToWrite = "\n"+whatToWrite;
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileToWrite, true))){
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

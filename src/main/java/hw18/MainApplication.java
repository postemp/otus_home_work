package hw18;

import hw18.rwMethods.ReadWriteMethods;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) throws IOException {

        // ищем текстовые файлы,что бы их показать
        File file = new File("./src");
        System.out.println("Найдены файлы: ");
        for (File fileName : ReadWriteMethods.textFilesList(file)) {
            System.out.println(fileName.getPath());
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя файла из этого списка, который вы хотите прочитать:");
        String fileToReadString = sc.nextLine();
        System.out.println("Показываем содержимое файла " + fileToReadString + " в консоли:");
        File fileToReadWrite = new File(fileToReadString);
        try {
            ReadWriteMethods.showFileContext(fileToReadWrite);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            sc.close();
            return;
        }

        System.out.println("Напечaтайте строку, которую вы хотите добавить в файл");
        String whatToWriteString = sc.nextLine();
        if (ReadWriteMethods.writeStringToFile(fileToReadWrite, whatToWriteString)) {
            System.out.println("Файл успешно записан");
        } else {
            System.out.println("Произошла ошибка при записи файла");
        }
        sc.close();
    }

}

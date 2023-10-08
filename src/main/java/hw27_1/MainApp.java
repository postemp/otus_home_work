package hw27;


import hw27.rwMethods.ReadWriteMethods;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {
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
//        String fileToReadString = "./src/main/java/hw27/textFiles/1.txt";
        System.out.println("Введите последовательность символов, которые вы хотите найти и подсчитать их количество (например \"журнал\")");
        String symbolsToFindAndCount = sc.nextLine();

        File fileToReadWrite = new File(fileToReadString);
        try {
            ReadWriteMethods.findPattern(fileToReadWrite, symbolsToFindAndCount);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            sc.close();
            return;
        }

    }


}

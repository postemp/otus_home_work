package hw20.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket;
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) throws IOException {
        socket = new Socket("localhost", 8088);
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner reader = new Scanner(System.in);
        System.out.println("connected: " + socket.isConnected());
        String answer;
        String request;
        while (true) {
            answer = in.readLine();
            if (answer == null || answer.trim().isEmpty()) {
                break;
            }
            System.out.println(answer);
            request = reader.nextLine();
            out.write(request + "\n");
            out.flush();
        }
        socket.close();
        in.close();
        out.close();
    }
}

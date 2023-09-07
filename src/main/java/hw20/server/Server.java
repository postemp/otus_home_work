package hw20.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            System.out.println(socket.isConnected());
            readRequest(socket);
        }
    }

    private static void readRequest(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        BufferedWriter writer = new BufferedWriter(new OutputStream(socket.getOutputStream()));
        while (true){
            String str = reader.readLine();
            System.out.println(str);
            if (str == null || str.trim().isEmpty()) {
                break;
            }
        }
    }
}

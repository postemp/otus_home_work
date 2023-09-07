package hw20.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        byte[] bytes = userInput.getBytes();

        try(Socket socket = new Socket("localhost", 8088)){
            PingClient pingClient = new PingClient(socket.getInputStream(), socket.getOutputStream());
            pingClient.ping(bytes);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}

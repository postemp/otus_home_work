package hw20.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static ServerSocket serverSocket; // серверсокет
    private static Socket socket; // сокет клиента
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) throws IOException {
        try {
            try {
                serverSocket = new ServerSocket(8088);
                System.out.println("Сервер запущен!");
                while (true) {
                    socket = serverSocket.accept();
                    System.out.println("Socket connected:" + socket.isConnected());
                    queryAndAnswer(socket);
                }
            } finally {
                System.out.println("Сервер закрыт!");
                serverSocket.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void queryAndAnswer(Socket socket) throws IOException {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write("Введите два числа, потом операцию, которую нужно выполнить над ними,");
            out.write(" возможные типы операций: + - * /  \n");
            out.flush();
            String first = in.readLine();
            System.out.println(first);
            out.write("Введите второе число\n");
            out.flush();
            String second = in.readLine();
            System.out.println(second);
            out.write("Введите тип операции\n");
            out.flush();
            int operType = in.read();
            System.out.println((char) operType);
            int result;
            try {
                switch ((char) operType) {
                    case '+':
                        result = Integer.parseInt(first) + Integer.parseInt(second);
                        break;
                    case '-':
                        result = Integer.parseInt(first) - Integer.parseInt(second);
                        break;
                    case '*':
                        result = Integer.parseInt(first) * Integer.parseInt(second);
                        break;
                    case '/':
                        result = Integer.parseInt(first) / Integer.parseInt(second);
                        break;
                    default:
                        result = 0;
                        throw new RuntimeException("Такой операции не найдено");
                }
            } catch (ArithmeticException e) {
                out.write("Ошибка, деление на ноль невозможно, нажмите Enter для завершнеия " + e);
                out.flush();
                socket.close();
                in.close();
                out.close();
                return;
            }  catch (RuntimeException e) {
                out.write("Ошибка  "+e+", нажмите Enter для завершнеия ");
                out.flush();
                socket.close();
                in.close();
                out.close();
                return;
            }
            System.out.println("result=" + result);
            out.write(" Результат = " + result + " нажмите Enter для завершнеия\n");
            out.flush();
            socket.close();
            in.close();
            out.close();
        } finally {
            socket.close();
            in.close();
            out.close();
        }
    }
}

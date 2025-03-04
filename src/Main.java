import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.Scanner;
import java.net.Socket;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        // создаем серверный сокет на порту 1234
        ServerSocket server = new ServerSocket(1234);
        while(true) {
            System.out.println("Waiting...");
            // ждем клиента из сети
            Socket socket = server.accept();
            System.out.println("Client connected!");
            // создаем клиента на своей стороне
            Client client = new Client(socket);
            // запускаем поток
            Thread thread = new Thread(client);
            thread.start();
        }
    }

}
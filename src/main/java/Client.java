import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String host = "netology.homework";
    private static final int port = 8080;

    public static void main(String[] args) {

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Client port : " + socket.getLocalPort() + " InetAddress : " + socket.getInetAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println(in.readLine());
                String scan = scanner.nextLine();
                out.println(scan);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}

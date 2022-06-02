import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 8080;

    public static void main(String[] args) {


        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connection accepted");
            out.println("Write your name : ");
            final String username = in.readLine();
            while (true) {
                out.println("Are you child? (yes/no)");
                String YN = in.readLine();
                if (YN.equalsIgnoreCase("Yes")) {
                    out.println(String.format("Welcome to the kids area, %s! Let's play!", username));
                    return;
                } else if (YN.equalsIgnoreCase("No")) {
                    out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", username));
                    return;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {

    public static void main(String[] args) throws IOException {

        int port = 9000;
        // Connect to the server using the loopback address and port 9000
        Socket clientSocket = new Socket(InetAddress.getLoopbackAddress(), port);

        // Create input and output streams for communication
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        Scanner sc = new Scanner(System.in);

        while (true) {
            String message = sc.nextLine(); // Get user input
            out.println(message); // Send message to the server
            System.out.println(in.readLine()); // Print server's response

            // Check if the user wants to quit
            if (message.equals("quit")) {
                clientSocket.close();
                return;
            }
        }
    }
}

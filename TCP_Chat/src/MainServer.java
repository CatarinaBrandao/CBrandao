import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {

    public static void main(String[] args) throws IOException {

        // Create a server socket on port 9000
        ServerSocket serverSocket = new ServerSocket(9000);

        // Wait for a client to connect
        Socket clientSocket = serverSocket.accept();

        // Create input and output streams for communication with the client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Continuously read messages from the client
        while (in.ready() == false) { // This condition is not effective, consider removing
            String line = in.readLine();
            System.out.println(line); // Print received message to the server console
            out.println(new Scanner(System.in).nextLine()); // Read and send input from server console

            // Check if the client wants to quit
            if (line.equals("quit")) {
                clientSocket.close();
                serverSocket.close();
                return;
            }
        }
    }
}


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MainClient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for server hostname and port
        System.out.print("Server Hostname? ");
        String hostname = sc.nextLine();
        System.out.print("Server Port? ");
        int port = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Prompt user for a message to send
        System.out.print("Enter message: ");
        String message = sc.nextLine();

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            // Convert the message to bytes
            byte[] messageBytes = message.getBytes();

            // Create a packet to send to the server
            DatagramPacket sendPacket = new DatagramPacket(
                    messageBytes,
                    messageBytes.length,
                    InetAddress.getByName(hostname),
                    port
            );

            // Send the packet to the server
            clientSocket.send(sendPacket);

            // Create a packet to receive the response
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            // Wait to receive the response from the server
            clientSocket.receive(receivePacket);

            // Convert the response to a string and print it
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received response: " + receivedMessage);
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}

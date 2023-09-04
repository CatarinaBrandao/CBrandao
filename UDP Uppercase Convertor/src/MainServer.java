import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MainServer {

    public static void main(String[] args) {
        final int serverPort = 9000;
        byte[] buffer = new byte[1024];

        try (DatagramSocket serverSocket = new DatagramSocket(serverPort)) {
            System.out.println("Server is listening on port " + serverPort);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

                // Wait to receive a packet from a client
                serverSocket.receive(receivePacket);

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received message: " + receivedMessage);

                // Convert the received message to uppercase
                String upperCaseMessage = receivedMessage.toUpperCase();
                byte[] responseBuffer = upperCaseMessage.getBytes();

                // Create a response packet with the converted message
                DatagramPacket responsePacket = new DatagramPacket(
                        responseBuffer,
                        responseBuffer.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                );

                // Send the uppercase message back to the client
                serverSocket.send(responsePacket);
                System.out.println("Sent response: " + upperCaseMessage);
            }
        } catch (SocketException e) {
            System.err.println("Error creating socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}

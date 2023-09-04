import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientWorker implements Runnable {

    private Socket clientSocket;
    private String message;
    private PrintWriter out;

    public ClientWorker (Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {

                message = in.readLine();
                System.out.println("Message from client " + Thread.currentThread().getName() + ":" + message);

                broadcastMessage(message);

                String quit = "quit";

                if (message.equals(quit)) {
                    break;
                }

            }

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message) throws IOException {
        for (ClientWorker clientWorker : Server.clientList) {
            if (clientWorker != this ){
                clientWorker.sendMessage(message);
            }

        }
    }

    public void sendMessage(String message) throws IOException {
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(message);
    }
}

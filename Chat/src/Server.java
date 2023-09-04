import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

        public static final int PORT = 8080;

        static Vector<ServerWorker> serverWorkers;

        public static void main(String[] args) throws IOException {

            Server server = new Server();
        }

        public Server() throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        serverWorkers = new Vector<>();

            ExecutorService cachedPool = Executors.newCachedThreadPool();

        while (true) {
            Socket clientSocket = serverSocket.accept();

            ServerWorker serverWorker = new ServerWorker(clientSocket);
            cachedPool.submit(serverWorker);

            serverWorkers.add(serverWorker);

        }

        }

     public class ServerWorker implements Runnable {

        private Socket serverSocket;
        private String message;
        private String nameUser;
        private BufferedReader in;
        private PrintWriter out;


        public ServerWorker(Socket serverSocket) {
            this.serverSocket = serverSocket;
        }

        @Override
        public void run() {
            try {

                in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
                out = new PrintWriter(serverSocket.getOutputStream(), true);

                out.println("User Name: ");
                nameUser = in.readLine();
                out.println(nameUser + " Welcome to the Chat! Start talk to other people :) ");

                while (true) {

                    message = in.readLine();
                    System.out.println("Message from client " + Thread.currentThread().getName() + ":" + message);

                    broadcastMessage(nameUser + ": " + message);

                    String quit = "quit";

                    if (message.equals(quit)) {
                        break;
                    }

                }
                serverWorkers.remove(this);
                serverSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void broadcastMessage(String message) throws IOException {
            for (ServerWorker serverWorker : Server.serverWorkers) {
                if (serverWorker != this ){
                    serverWorker.sendMessage(message);
                }

            }
        }

        public void sendMessage(String message) throws IOException {
            out.println(message);
        }
    }


}

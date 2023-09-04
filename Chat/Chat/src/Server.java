import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

        public static final int PORT = 8080;

        static Vector<ClientWorker> clientList;

        public static void main(String[] args) throws IOException {

            ServerSocket serverSocket = new ServerSocket(PORT);

            clientList = new Vector<>();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientWorker clientWorker = new ClientWorker(clientSocket);

                clientList.add(clientWorker);

                ExecutorService cachedPool = Executors.newCachedThreadPool();
                cachedPool.submit(clientWorker);

            }

        }

}

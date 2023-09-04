import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) throws IOException {

        Client client = new Client();

    }

    public Client() throws IOException {

        Socket socketClient = new Socket(InetAddress.getLoopbackAddress(), Server.PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);

        ExecutorService cachedPool = Executors.newCachedThreadPool();

        for (int i = 0; i<Server.serverWorkers.size(); i++){
            ClientRunnable clientRunnable = new ClientRunnable();
            cachedPool.submit(clientRunnable);

        }
}

    public class ClientRunnable implements Runnable{

        @Override
        public void run() {


        }
    }
}

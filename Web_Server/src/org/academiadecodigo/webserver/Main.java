package org.academiadecodigo.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        // Create a server socket listening on port 8081
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket clientSocket;
        File file = null;

        // Wait for client connections indefinitely
        while ((clientSocket = serverSocket.accept()) != null) {

            // Create readers and writers to interact with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            byte[] buffer = new byte[1024];
            int readSize;

            // Read the first line of the HTTP request sent by the client
            String line = in.readLine();
            System.out.println(line);

            // Split the request line into parts separated by space
            String[] receivedMessage = line.split(" ");
            System.out.println(receivedMessage[1]);

            // Split the message type part (file extension) from the URL
            String[] typeMessage = (receivedMessage[1]).split("\\.");
            System.out.println(typeMessage[1]);

            // Check if the request method is GET
            if (receivedMessage[0].equals("GET")) {

                // Construct the requested file path from the "www" directory
                file = new File("www" + receivedMessage[1]);

                // Check if the requested file does not exist
                if (!file.exists()) {

                    // If it doesn't exist, send a 404 error response with a custom HTML page
                    File notFoundFile = new File("www/404.html");
                    FileInputStream inputStream = new FileInputStream(notFoundFile);
                    out.writeBytes(ResponseHeaders.typeNotFound(notFoundFile.length() + 1));

                    // Send the content of the 404 error page
                    while ((readSize = inputStream.read(buffer)) != -1) {
                        out.write(buffer, 0, readSize);
                    }
                    continue;
                }

                // Check if the requested file is an HTML file
                if (typeMessage[1].equals("html")) {

                    FileInputStream inputStream = new FileInputStream(file);

                    // Send response headers with HTML content type
                    out.writeBytes(ResponseHeaders.typeText(file));

                    // Send the content of the HTML file
                    while ((readSize = inputStream.read(buffer)) != -1) {
                        out.write(buffer, 0, readSize);
                    }

                }

                // Check if the requested file is a PNG file
                if (typeMessage[1].equals("png")) {

                    FileInputStream inputStream = new FileInputStream(file);

                    // Send response headers with PNG content type
                    out.writeBytes(ResponseHeaders.typeImage(file, "png"));

                    // Send the content of the PNG file
                    while ((readSize = inputStream.read(buffer)) != -1) {
                        out.write(buffer, 0, readSize);
                    }

                }

                // Close the connection with the client after sending the response
                clientSocket.close();
            }
        }
    }
}


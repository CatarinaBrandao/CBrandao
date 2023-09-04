# UDP Uppercase Converter

## Description

This Java project demonstrates a simple UDP (User Datagram Protocol) client-server communication model. The primary functionality of this project is to transform a received message into uppercase and send it back to the client. It serves as an educational example of UDP communication in Java.

## How the Project Works

### Server (MainServer.java)

The server part of this project performs the following steps:

1. Creates a DatagramSocket bound to port 9000.
2. Creates a DatagramPacket to receive data from clients.
3. Receives a message from a client and prints it to the console.
4. Converts the received message to uppercase.
5. Sends the uppercase message back to the client.

### Client (MainClient.java)

The client part of this project performs the following steps:

1. Takes user input for the server's hostname (address), port number, and a message to send.
2. Creates a DatagramSocket for sending and receiving data.
3. Sends the user's message to the server using a DatagramPacket.
4. Waits to receive a response from the server and prints it to the console.

## Usage

1. Start the server by running `MainServer`:
   ```shell
   java MainServer
   ```

2. Start the client by running `MainClient` and follow the prompts to enter the server hostname, port, and message to send:
   ```shell
   java MainClient
   ```

4. The server will receive the message, convert it to uppercase, and send it back to the client.

## Note

In a real-world scenario, you would want to add error handling, robustness, and potentially multi-threading to handle multiple clients concurrently.



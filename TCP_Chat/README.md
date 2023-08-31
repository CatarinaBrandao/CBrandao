# TCP Client-Server Chat Application

This Java project demonstrates a simple client-server chat application using the TCP (Transmission Control Protocol) for communication. The project consists of two main classes: `MainServer` (the server-side code) and `MainClient` (the client-side code).

## Overview

The TCP Client-Server Chat Application showcases the basic interaction between a server and multiple clients over a network. The server waits for clients to connect and handles their messages. Clients can send messages to the server, which relays them to other connected clients.

## Features

- Establishes a TCP server socket to handle client connections.
- Clients can send messages to the server.
- Server relays the received messages to all connected clients.
- Clients can exit the chat by sending the "quit" command.

## Usage

1. Compile the code using `javac MainServer.java` and `javac MainClient.java`.
2. Open two terminal/command prompt windows.
3. In one window, run the server using `java MainServer`.
4. In another window, run the client using `java MainClient`.

## Instructions

1. When the client starts, it will prompt you to enter messages.
2. Type messages in the client window and press Enter to send them to the server.
3. The server will display the received messages in its console.
4. The server will relay the messages to all connected clients.
5. To quit the chat, type "quit" in the client's input and press Enter.

## Notes

- This project focuses on demonstrating basic TCP client-server communication and lacks advanced features or error handling.
- The communication is one-to-one between the server and each connected client.
- Remember to compile and run both the server and client in separate terminal windows.

Feel free to extend and modify the code to experiment with different functionalities or to create a more sophisticated chat application.

# Chat 

This Java project demonstrates a simple multi-client chat system using socket programming. It consists of a chat server that listens for incoming connections from clients and a chat client that can connect to the server to send and receive messages.

## Features

- **Server:** Accepts multiple client connections simultaneously.
- **Client:** Connects to the server to send and receive messages.
- **Real-time Chat:** Messages are sent and received in real-time.
- **Threaded Design:** Uses multithreading to handle multiple clients concurrently.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed.
- A basic understanding of socket programming in Java.

## Usage

To use this chat server and client, follow these steps:

### Server

1. Run the `Server` class to start the chat server.
2. The server will listen on port `8080` by default. You can change this port by modifying the `PORT` constant in the `Server` class.
3. The server will accept incoming connections from clients and handle multiple chat sessions simultaneously.

### Client

1. Run the `Client` class to start a chat client.
2. The client will attempt to connect to the server on `localhost` (loopback address) and port `8080`. You can change the server address and port in the `Client` class if needed.
3. Enter a username when prompted by the client.
4. Start typing messages, and they will be sent to the server and broadcasted to all connected clients.
5. To exit the client, type "quit" and press Enter.


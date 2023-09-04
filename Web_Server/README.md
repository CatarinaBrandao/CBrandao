# Web Server

This Java project is a basic implementation of a web server that serves static files in response to HTTP GET requests. It handles HTML and PNG files and gracefully returns a custom 404 error page when a requested file is not found.

## Getting Started

To run the web server, follow these steps:

1. Make sure you have Java installed on your system.

2. Clone or download this repository.

3. Navigate to the project directory.

4. Place your HTML and PNG files in the "www" directory. The server will serve files from this directory.

5. Compile the `Main.java` file.

   ```shell
   javac Main.java
   ```

6. Start the server.

   ```shell
   java Main
   ```

7. The server will start listening on port 8081.

## Usage

Access the server using a web browser or a tool like `curl`. Example:

```shell
curl http://localhost:8081/index.html
```

## Customization

- You can customize the server's port by changing the `ServerSocket` creation in the `Main.java` file.

- Customize the 404 error page by editing the contents of the `www/404.html` file.

- The server currently supports HTML and PNG files. You can extend it to support more file types by modifying the `typeImage` and `typeText` methods in the `ResponseHeaders.java` file.

## Important Notes

- This is a simple implementation for educational purposes. In a production environment, consider using established web server software.

- Error handling is limited to 404 errors. For production use, you should consider adding more robust error handling and security measures.


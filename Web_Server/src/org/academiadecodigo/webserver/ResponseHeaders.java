package org.academiadecodigo.webserver;

import java.io.File;

public class ResponseHeaders {

    public static String typeText(File file) {
        return "HTTP/1.0 200 Document Follows\r\n" +
                "Content-Type: text/html; charset=UTF-8\r\n" +
                "Content-Length: " + file.length() + "\r\n" +
                "\r\n";
    }

    public static String typeImage(File file, String imageFileExtension) {
        return "HTTP/1.0 200 Document Follows\r\n" +
                "Content-Type: image/" + imageFileExtension + "\r\n" +
                "Content-Length: " + file.length() + "\r\n" +
                "\r\n";
    }

    public static String typeNotFound(long fileByteSize) {
        return "HTTP/1.0 404 Not Found\r\n" +
                "Content-Type: text/html; charset=UTF-8\r\n" +
                "Content-Length: " + fileByteSize + "\r\n" +
                "\r\n";
    }

}

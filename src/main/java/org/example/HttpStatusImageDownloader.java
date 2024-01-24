package org.example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws IOException, URISyntaxException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String statusURL = httpStatusChecker.getStatusImage(code);

        try {
            URL url = new URL(statusURL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            InputStream inputStream = connection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream("cats_image.jpg");

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

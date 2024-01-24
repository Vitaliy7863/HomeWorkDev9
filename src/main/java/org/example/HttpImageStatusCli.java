package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        int statusCode = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter HTTP status code: ");

            statusCode = scanner.nextInt();

            HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
            downloader.downloadStatusImage(statusCode);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (IllegalArgumentException | IOException | URISyntaxException e) {
            System.out.println("Error while downloading image for HTTP status " + statusCode);
        }
    }
}

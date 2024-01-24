package org.example;

import java.io.IOException;
import java.net.*;

public class HttpStatusChecker  {
    public String getStatusImage(int code) throws IOException, URISyntaxException {
        URI uri = new URI("https", "http.cat", "/" + code, null);

        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == 404) {
            throw new IllegalArgumentException("Incorrectly transmitted code!");
        }

        return String.valueOf(connection.getURL());
    }
}

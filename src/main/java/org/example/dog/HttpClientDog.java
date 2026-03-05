package org.example.dog;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientDog {



    private final String urlDog = "https://dog.ceo/api/breed/hound/images";

    private final HttpClient client = HttpClient.newHttpClient();


    private final Gson gson = new Gson();


    public dogApiResponse getImagenes() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(urlDog))
                                    .GET()
                                    .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), dogApiResponse.class);
    }


}

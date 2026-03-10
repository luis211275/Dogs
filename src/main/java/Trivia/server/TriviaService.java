package Trivia.server;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TriviaService {
    public static JsonArray format(){

        JsonArray results = new JsonArray();
        for (JsonElement question : results) {
            JsonElement correct_answer = new JsonObject();
            question.getAsJsonObject().addProperty("correct_answer", correct_answer.getAsString());
            question.getAsJsonObject().addProperty("question", correct_answer.getAsString());
            question.getAsJsonObject().addProperty("answer", correct_answer.getAsString());
        }
        return results;
    }

    public static JsonArray easy(){
        JsonElement raiz = new JsonObject();
        JsonArray results = new JsonArray();

        JsonArray data = new JsonArray();
        for (JsonElement element : results) {
            JsonElement object = new  JsonObject();

        }
        return results;
    }

    public static  String llamada(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}

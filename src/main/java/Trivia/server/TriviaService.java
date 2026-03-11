package Trivia.server;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class TriviaService {
    public static JsonArray formatEasy() throws Exception {
        String url = "https://opentdb.com/api.php?amount=10&difficulty=easy";
        String json = llamada(url);
        System.out.println(json);

        JsonObject data = new JsonParser().parse(json).getAsJsonObject();
        JsonArray results = data.getAsJsonArray("results");
        JsonArray preguntas = new JsonArray();

        for (int i = 0; i < results.size(); i++) {
            JsonObject item = results.get(i).getAsJsonObject();

            JsonObject pregunta = new JsonObject();
            pregunta.addProperty("question", item.get("question").getAsString());
            pregunta.addProperty("correct_answer", item.get("correct_answer").getAsString());

            JsonArray answers = new JsonArray();
            answers.add(item.get("correct_answer").getAsString());

            JsonArray incorrecta = item.getAsJsonArray("incorrect_answers");

            for (int j = 0; j < incorrecta.size(); j++) {
                answers.add(incorrecta.get(j).getAsString());
            }
            pregunta.add("answers", answers);
            preguntas.add(pregunta);
        }

        return preguntas;

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
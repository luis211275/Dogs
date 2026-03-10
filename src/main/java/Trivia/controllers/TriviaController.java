package Trivia.controllers;

import Trivia.server.TriviaService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;



public class TriviaController {

    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();

        try {


            if (path.equals("/trivia/format")) {
                response(exchange, TriviaService.format());
            }
            if (path.equals("/trivia/easy")) {
                response(exchange, TriviaService.llamada("https://opentdb.com/api.php?amount=10&difficulty=easy"));
                //{
                //  {
                //  "results": [
                //    {
                //
                //      "question": "Who succeeded Joseph Stalin as General Secretary of the Communist Party of the Soviet Union?",JsonElemment
                //      "correct_answer": "Nikita Khrushchev",AddProperty
                //      "answers": [
                //        "Leonid Brezhnev",
                //        "Mikhail Gorbachev",
                //         "Nikita Khrushchev",
                //        "Boris Yeltsin"
                //      ]
                //    },
            }

            if (path.equals("/trivia/medium")) {
                response(exchange, TriviaService.llamada("https://opentdb.com/api.php?amount=10&difficulty=medium"));
            }

            if (path.equals("/trivia/hard")) {
                response(exchange, TriviaService.llamada("https://opentdb.com/api.php?amount=10&difficulty=hard"));
            }


            sendResponse(exchange, 404, "Endpoint trivia no válido");

        } catch (Exception e) {
            sendResponse(exchange, 500, "Error llamando a la API trivia");
        }
    }



    private void response (HttpExchange exchange, Object data) throws IOException {
        String respuesta;

        if (data instanceof String) {
            respuesta = (String) data;
        } else {
            respuesta = new Gson().toJson(data);
        }

        sendResponse(exchange, 200, respuesta);
    }

    private void sendResponse(HttpExchange exchange, int status, String body) throws IOException {

        exchange.getResponseHeaders().add("Content-Type", "application/json");

        byte[] bytes = body.getBytes();

        exchange.sendResponseHeaders(status, bytes.length);

        OutputStream os = exchange.getResponseBody();
        os.write(bytes);
        os.close();
    }
}

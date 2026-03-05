package org.example.http;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpClientPokemon {


    // URL de PokeAPI
    private final String urlPokemon = "https://pokeapi.co/api/v2/encounter-method/";

    // Cliente HTTP
    private final HttpClient client = HttpClient.newHttpClient();

    private final Gson gson = new Gson();

    // Metodo principal que hace la petición y devuelve los Pokémon
    public List<NamedAPIResource> getPokemons() throws IOException, InterruptedException {

        // Construcción de la petición GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlPokemon))
                .GET()
                .build();

        // Envío de la petición
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parseo del JSON
        PokemonListResponse data = gson.fromJson(response.body(), PokemonListResponse.class);

        return data.results;
    }


    public EncounterMethod getEncounterMethod(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();


        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), EncounterMethod.class);
    }


    public static class PokemonListResponse {

        List<NamedAPIResource> results;

    }


    public static class EncounterMethod {

        int id;
        String name;
        int order;
        List<EncounterName> names;
    }

    public static class EncounterName {

        String name;
        NamedAPIResource language;

    }

    public static class NamedAPIResource {
        String name;
        String url;
    }

}
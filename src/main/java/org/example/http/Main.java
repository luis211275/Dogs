package org.example.http;

public class Main {
    public static void main(String[] args) {
        final MyScanner sc = new MyScanner();

        int opcion = sc.pedirNumero("Que vas a querer hacer:\n" +
                "1.Encounter Method.\n" +
                "2.Salir.\n" +
                "Opcion: ");


        switch (opcion) {
            case 1:
                try {
                    org.example.http.HttpClientPokemon http = new org.example.http.HttpClientPokemon();

                    // Obtener los Pokémon (solo nombres)
                    for (HttpClientPokemon.NamedAPIResource p : http.getPokemons()) {
                        HttpClientPokemon.EncounterMethod detalles = http.getEncounterMethod(p.url);

                        System.out.println("ID: " + detalles.id);
                        System.out.println("NOMBRE: " + detalles.name);
                        System.out.println("ORDER: " + detalles.order);
                        System.out.println("NAMES: ");


                        for (HttpClientPokemon.EncounterName n : detalles.names) {
                            System.out.println("Nombre: " + n.name + "\n" +
                                    "Idioma: " + n.language.name +
                                    "\n Url: " + n.language.url);
                        }

                        System.out.println("---------------");


                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                System.out.println("Saliendo");
                break;
            default:
                System.out.println("dato mal introducido");
                break;

        }


    }
}


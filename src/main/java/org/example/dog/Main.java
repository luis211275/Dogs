package org.example.dog;

import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final MyScanner sc = new MyScanner();

        System.out.println("===API DE PERROS===");

        int opcion = sc.pedirNumero("Que vas a querer hacer:" +
                "\n1.Cargar imagenes de perros." +
                "\2.Salir del programa." +
                "Opción:");

        boolean exit = true;

        do {

            switch (opcion) {
                case 1:
                    try {
                        HttpClientDog http = new HttpClientDog();
                        dogApiResponse datos = http.getImagenes();

                        for (String urls : datos.getMessage()) {
                            System.out.println(urls);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;


                case 2:
                    System.out.println("Saliendo del programa...");
                    break;


                default:
                    exit = false;
                    System.out.println("opcion no valida");
            }

        } while (exit);

    }
}

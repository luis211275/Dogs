package dogs.Main;


import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.util.Scanner;

import dogs.router.RouterHandler;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
// Se crea el servior y desde qué puerto va estar escuchando
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
// cada vez que arranca y se pone (http://localhost:8080)
        server.createContext("/", new RouterHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Que url quieres iniciar" +
                "\n1. Lista entera" +
                "\n2. Perros con solo razas" +
                "\n3. Perros con solo subrazas" +
                "\n4. Imagenes random de perro" +
                "\n5. 5 imagenes random de perros seguidas" +
                "\n6. N imagenes random" +
                "\n7. Todas las imagenes" +
                "\n8. Todas las imagenes de un perro" +
                "\n9. Imagenes de dos razas de perro" +
                "\n10. Salir");
        String url = sc.nextLine();
        switch (url) {
            case "1":
                System.out.println("Servidor iniciado en http://localhost:8080");
                break;
            case "2":
                System.out.println("Servidor iniciado en http://localhost:8080/dogs/noBreeds");
                break;
            case "3":
                System.out.println("Servidor iniciado en http://localhost:8080/dogs/conBreeds");
                break;
            case "4":
                System.out.println("Servidor iniciado en http://localhost:8080/dogs/image/random");
                break;
            case "5":
                System.out.println("Servidor iniciado en http://localhost:8080/dogs/five/random");
                break;
            case "6":
                System.out.println("Servidor iniciado en http://localhost:8080/dogs/n/random/");
                break;
            case "7":
                System.out.println("Servidor iniciado en http://localhost:8080/dogs/all/images");
                break;
            case "8":
                System.out.println("Servidor iniciado en http://localhost:8080/dogs/one/breeds/");
                break;
            case "9":
                System.out.println("Servidor iniciado en http://localhost:8080/dogs/two/breeds/");
            case "10":
                System.out.println("Saliendo");
                break;
            default:
                System.out.println("Error, dato mal introducido");
                break;
        }
    }
}
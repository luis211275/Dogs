package org.example.Productos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        Map<Integer, Producto> productosMap = new HashMap<>();

        productosMap.put(1, new Producto("P-001", "Smartphone Galaxy S24", "Telefonia", "Samsung", 999.99, 15, 5, "15/03/2024", "Samsung Electronics", "8806092229876", 24));

        productosMap.put(2, new Producto("P-002", "Laptop ThinkPad X1 Carbon", "computadoras", "lenovo", 1499.99, 3,4,"10/03/2024", "lenovo Group", "0193331681234", 36));

        productosMap.put(3, new Producto("P-003", "Auriculares Noise Cancelling WH-1000XM5", "audio", "Sony", 349.99, 25, 10, "18/03/2024", "Sony Corporation", "4905524931248", 12));

        productosMap.put(4, new Producto("P-004", "Monitor Gaming 27 4K", "Monitores", "Asus", 599.99, 0, 3, "05/03/2024", "Asus Tek", "4712900751234", 24));

        productosMap.put(5, new Producto("P-005", "Tablet iPad Air 5th Gen", "Tablets", "Apple", 749.99, 8, 6, "20/03/2024", "Apple Inc", "1901993221234", 12));





        Gson gson = new GsonBuilder().create();


        String json = gson.toJson(productosMap);

        try (FileWriter writter = new FileWriter("Data/Productos.json")) {
            writter.write(json);
            System.out.println("json guardado exitosamente");
            System.out.println(json);
        }catch (IOException e){
            System.out.println("Error al escribir los datos");
        }


    }



}

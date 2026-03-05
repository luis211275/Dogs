package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;


public class Array_Gson {
    public  static void main(String[] args) {
        Object [][] personas = {
                {"Luis", 18, "Madrid", 1.83},
                {"Marco", 50, "Colombia", 1.88},
                {"Ruben", 5, "Rusia", 1.78},
                {"Julio", 30, "Peru", 1.75},
                {"Daniel", 60, "Bolivia", 1.66},
                {"Hugo", 33, "Francia", 1.60},
                {"Alejandro", 79, "Alemania", 1.87}
        };

            //De array a Json

                Gson gson = new GsonBuilder().create();

                String json = gson.toJson(personas);


            //Guardar en un archivo

            try (FileWriter writer = new FileWriter("Data/Array.json")){
                writer.write(json);
                System.out.println("json guardado");
            }catch(Exception e){
                System.out.println("Error guardando json" + e.getMessage());
            }

            //Leer json desde el archivo
            try (Reader reader = new FileReader("Data/Array.json")){
                JsonArray jsonArray = new JsonParser().parse(reader).getAsJsonArray();
                System.out.println("json leido desde el archivo");
                System.out.println(jsonArray);
            }catch (IOException e){
                System.out.println("Error guardando json"+e.getMessage());
            } catch(Exception e){
                System.out.println("Error guardando json"+e.getMessage());
            }




    }
}

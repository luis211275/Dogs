package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Leer {
    public static void main(String[] args) {
        try {
            //Hara que abra el archivo y lo lea, por eso lo de reader
            Reader reader = new FileReader("Data/Array.json");
            JsonArray jsonArray = new JsonParser().parseReader(reader).getAsJsonArray();
            System.out.println(jsonArray);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.javium.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileManager {
    
    final static String path = "src/main/java/com/javium/data/";

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
        
    public static ArrayList<String> ReadFile(String filename) {
        ArrayList<String> content = new ArrayList<String>();

        System.out.println("Reading file: " + filename);
    
        try {
            BufferedReader br = new BufferedReader(new FileReader(path + filename));
            String line = br.readLine();

            while (line != null) {
                content.add(line);
                line = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

        System.out.println("File " + filename + " read!");
        return content;
    }

    public static void WriteFile(String filename, String[] content) {
        System.out.println("Saving file: " + filename);

        try {
            FileWriter writer = new FileWriter(path + filename);

            for (String line : content) {
                writer.write(line + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

        System.out.println("File " + filename + " saved!");
    }
}

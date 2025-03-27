package com.javium.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileManager {
    
    private final static String PATH = "src/main/java/com/javium/data/";
    private final static String DEFAULT_SPLITTER = ":";

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
        
    public static ArrayList<String> ReadFile(String filename) {
        ArrayList<String> content = new ArrayList<String>();

        System.out.println("Reading file: " + filename);
    
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH + filename));
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

    public static void ReadFile(String filename, ArrayList<String> content) {
        System.out.println("Reading file: " + filename);
    
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH + filename));
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
    }

    public static String GetParameterFromFile(String filename, String parameter) {
        ArrayList<String> content = ReadFile(filename);
        
        for (String line : content) {
            if (line.contains(parameter)) {
                return line.split(DEFAULT_SPLITTER)[1];
            }
        }

        return null;
    }

    public static String GetParameterFromFile(ArrayList<String> content, String parameter) {
        for (String line : content) {
            if (line.contains(parameter)) {
                return line.split(DEFAULT_SPLITTER)[1];
            }
        }

        return null;
    }

    public static void WriteFile(String filename, String[] content) {
        System.out.println("Saving file: " + filename);

        try {
            FileWriter writer = new FileWriter(PATH + filename);

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

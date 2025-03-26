package com.javium.game;

import java.io.BufferedReader;

import com.javium.utils.FileManager;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String[] content = { "Hello", "World!" };
        FileManager.WriteFile("file.txt", content);
    }
}

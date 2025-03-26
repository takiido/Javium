package com.javium.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InputHandler {
    static Map<InputAction, String> inputMapping = new HashMap<InputAction, String>();
    
    public static void LoadInputMapping() {
        System.out.println("Loading input mapping...");

        ArrayList<String> content = FileManager.ReadFile("input_mapping.txt");
    
        if (content == null) {
            System.out.println("Failed to load input mapping!");
            LoadDefaultMapping();
        } else {    
            for (String line : content) {
                String[] parts = line.split(":");
                inputMapping.put(InputAction.valueOf(parts[0]), parts[1]);
            }
    
            System.out.println("Input mapping loaded!");
        }
    
    }
    
    public static void LoadDefaultMapping() {
        System.out.println("Loading default input mapping...");
    
        inputMapping.put(InputAction.MOVE_UP, "W");
        inputMapping.put(InputAction.MOVE_DOWN, "S");
        inputMapping.put(InputAction.MOVE_LEFT, "A");
        inputMapping.put(InputAction.MOVE_RIGHT, "D");

        System.out.println("Default input mapping loaded!");

        SaveInputMapping();
    }

    public static void SaveInputMapping() {
        System.out.println("Saving input mapping...");
    
        String[] content = new String[inputMapping.size()];
        int i = 0;

        for (Map.Entry<InputAction, String> entry : inputMapping.entrySet()) {
            content[i] = entry.getKey() + ":" + entry.getValue();
            System.out.println(content[i]);
            i++;
        }
    
        FileManager.WriteFile("input_mapping.txt", content);
    }
}

package com.javium.utils.nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    String name;
    Map<String, String> values = new HashMap<>();
    ArrayList<Node> children = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public void AddValue(String key, String value) {
        values.put(key, value);
    }

    public void AddChild(Node child) {
        children.add(child);
    }

    public Node GetChild(String name) {
        for (Node child : children) {
            if (child.name.equals(name)) {
                return child;
            }
        }
        return null;
    }

    public String GetValue(String key) {
        return values.get(key);
    }

    public String GetName() {
        return name;
    }

    public ArrayList<String> toLines() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(name);
        lines.add("[");

        for (Map.Entry<String, String> entry : values.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (IsNumeric(value)) {
                lines.add(key + ":" + value);
            } else {
                lines.add(key + ":\"" + value + "\"");
            }
        }

        for (Node child : children) {
            lines.addAll(child.toLines());
        }
        lines.add("]");
        return lines;
    }

    private boolean IsNumeric(String str) {
        return str != null && str.matches("\\d+");
    }

    public String FindInChildren(String key) {
        if (values.containsKey(key)) {
            return values.get(key);
        }
        
        for (Node child : children) {
            String result = child.FindInChildren(key);
            if (result != null) {
                return result;
            }
        }
        
        return null;
    }
}

package com.javium.utils.nodes;

import java.io.*;
import java.util.*;

import javax.management.RuntimeErrorException;

import com.javium.utils.FileManager;

public class NodeReader {

    public ArrayList<Node> Parse(String filename) {
        ArrayList<String> content = FileManager.ReadFile(filename);
        ArrayList<Node> nodes = new ArrayList<>();
        int index = 0;

        while (index < content.size()) {
            String line = content.get(index).trim();
            if (line.isEmpty()) {
                index++;
                continue;
            }

            Pair<Node, Integer> result = ParseNode(content, index, filename);
            nodes.add(result.first());
            index = result.second();
        }

        return nodes;
    }

    public void writeNodes(ArrayList<Node> nodes, String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Node node : nodes) {
            lines.addAll(node.toLines());
        }

        FileManager.WriteFile(filename, lines.toArray(new String[0]));
    }

    private Pair<Node, Integer> ParseNode(List<String> content, int index, String filename) {
        String nodeName = content.get(index).trim();
        index++;

        if (index >= content.size() || !content.get(index).trim().equals("[")) {
            throw new RuntimeErrorException(new Error(), "Config parsing error: expected '[' after node name. File: " + filename + ", Line: " + index);
        }

        index++;

        Node node = new Node(nodeName); 

        while (index < content.size() && !content.get(index).trim().equals("]")) {
            String line = content.get(index).trim();
            if (line.isEmpty()) {
                index++;
                continue;
            }

            if (line.contains(":")) {
                int colonIndex = line.indexOf(":");
                String key = line.substring(0, colonIndex).trim();
                String value = line.substring(colonIndex + 1).trim();
                if (value.startsWith("\"") && value.endsWith("\"")) {
                    value = value.substring(1, value.length() - 1);
                }

                node.AddValue(key, value);
                index++;
            }
            else {
                Pair<Node, Integer> result = ParseNode(content, index, filename);
                node.AddChild(result.first());
                index = result.second();
            }
        }
        if (index >= content.size() || !content.get(index).trim().equals("]")) {
            throw new RuntimeErrorException(new Error(), "Config parsing error: expected ']' after node. File: " + filename + ", Line: " + index);
        }
        index++;
        return new Pair<>(node, index);
    }

    private static class Pair<T, U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T first() {
            return first;
        }

        public U second() {
            return second;
        }
    }
}

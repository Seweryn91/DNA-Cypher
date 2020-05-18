package com.Seweryn91.app.buisness.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class CodonMaps {

    private Map<String, String[]> encypheringMap = new HashMap<>();
    private Map<String, String> decypheringMap = new HashMap<>();

    public CodonMaps() {
        fillEncypheringMap();
        fillDecypheringMap();
    }

    private void fillEncypheringMap() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/codonMap.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] splitted = line.split("\\|");
                encypheringMap.put(splitted[0], Arrays.copyOfRange(splitted, 1, splitted.length));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillDecypheringMap() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/codonMap.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] splitted = line.split("\\|");
                for (int i = 1; i < splitted.length; i++) {
                    decypheringMap.put(splitted[i], splitted[0]);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String[]> getEncypheringMap() {
        return encypheringMap;
    }

    public Map<String, String> getDecypheringMap() {
        return decypheringMap;
    }
}

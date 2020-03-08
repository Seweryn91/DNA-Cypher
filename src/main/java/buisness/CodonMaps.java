package buisness;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                if (splitted.length == 2) {
                    encypheringMap.put(splitted[0], new String[]{splitted[1]});
                } else encypheringMap.put(splitted[0], new String[]{splitted[1], splitted[2], splitted[3]});
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
                if (splitted.length == 2) {
                    decypheringMap.put(splitted[1], splitted[0]);
                } else {
                    decypheringMap.put(splitted[1], splitted[0]);
                    decypheringMap.put(splitted[2], splitted[0]);
                    decypheringMap.put(splitted[3], splitted[0]);
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

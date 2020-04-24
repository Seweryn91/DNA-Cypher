package com.Seweryn91.app.buisness;


import java.io.*;

public class TextFileWriter {

    public void writeToFile(String path, String text, boolean isDecoded) throws IOException {
        String newPath = path.substring(0, path.lastIndexOf('/'));
        String filename = "Encoded";
        if (isDecoded) {
            filename = "Decoded";
        }
        BufferedWriter output = null;
        try {
            File file = new File(newPath + "/" + filename + ".txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            output.close();
        }
    }
}

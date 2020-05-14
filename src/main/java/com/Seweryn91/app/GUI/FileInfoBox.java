package com.Seweryn91.app.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileInfoBox extends JTextField {

    private static JTextField fileName;
    private static JTextField fileSize;
    private static JTextField filePath;
    private static JTextField mutationKey;

    public FileInfoBox() {
        fileName = new JTextField("File name: No file chosen");
        filePath = new JTextField("File path: ");
        fileSize = new JTextField("File size: ");
        mutationKey = new JTextField("Mutation key: ");
        add(fileName);
        add(filePath);
        add(fileSize);
        add(mutationKey);
        setLayout(new GridLayout(4,1));
        setPreferredSize(new Dimension(300, 50));

    }

    public static void setMutationKeyValue(String value) {
        mutationKey.setText(value);
    }

    public static String getMutationKeyValue() {
        return mutationKey.getText();
    }

    public static File displayValues(File file) {
        fileName.setText("File name: " + file.getName());
        filePath.setText("File path: " + file.getPath());
        fileSize.setText("File size: " + file.length() + " bytes");
        return file;
    }




}
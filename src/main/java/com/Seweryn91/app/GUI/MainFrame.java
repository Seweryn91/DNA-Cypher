package com.Seweryn91.app.GUI;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        JFrame frame = new JFrame("DNA CYPHER-DECYPHER");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        JLabel author = new JLabel("github.com/Seweryn91");
        PropertiesManager propertiesManager = new PropertiesManager();
        ActionBar buttonBar = new ActionBar(propertiesManager);
        FileInfoBox fileInfoBox = new FileInfoBox();
        FileChooserButton fileChooserButton = new FileChooserButton();
        frame.add(fileChooserButton);
        frame.add(fileInfoBox);
        frame.add(buttonBar);
        frame.add(author);
        frame.setSize(400, 350);
        frame.setVisible(true);
    }

}

package com.Seweryn91.app.GUI;

import javax.swing.*;

public class Popup {

    public static void popupInfo(String infoMessage, String title, int type) {
        JOptionPane.showMessageDialog(null, infoMessage, title, type);
    }
}

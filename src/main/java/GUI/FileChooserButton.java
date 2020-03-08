package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChooserButton extends JDesktopPane implements ActionListener {

    private JButton inputButton;

    public FileChooserButton() {
        inputButton = new JButton("Load file");
        inputButton.addActionListener(this);
        setSize(300, 50);
        setLayout(new GridLayout());
        add(inputButton);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        JButton source = (JButton) actionEvent.getSource();

        if (source == inputButton) {
            fileChooser.init();
        }
    }
}

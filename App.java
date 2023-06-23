package Textencryptionapp.application;

import Textencryptionapp.algorithms.CaesarCipher;
import Textencryptionapp.algorithms.MorseCode;
import Textencryptionapp.service.EncryptionService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class App {
    private JFrame frame;
    private JLabel label1, label2, label3;
    private JTextField inputField;
    private JTextField outputField;
    private JButton encryptButton;
    private JComboBox<String> algorithmSelector;

    public App() {
        // Setup the JFrame
        frame = new JFrame();
        frame.setTitle("Textrypt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.getContentPane().setBackground(new Color(36, 110, 90));
        ImageIcon logo = new ImageIcon("logo.jpg");
        frame.setIconImage(logo.getImage());
        frame.setLayout(null);

        // Setup the JLabel
        label1 = new JLabel();
        label1.setText("ENTER THE TEXT YOU WANT TO ENCRYPT");
        label1.setBounds(50, 20, 300, 20);
        frame.add(label1);

        // Input field for plaintext
        inputField = new JTextField();
        inputField.setBounds(50, 50, 300, 20);
        frame.add(inputField);

        // Text
        label2 = new JLabel();
        label2.setText("SELECT ENCRYPTION METHOD");
        label2.setBounds(50, 80, 300, 20);
        frame.add(label2);

        // Selector for encryption method
        String[] algorithms = {"Caesar Cipher", "Morse Code"};
        algorithmSelector = new JComboBox<>(algorithms);
        algorithmSelector.setBounds(50, 110, 300, 20);
        frame.add(algorithmSelector);

        // Button to start encryption
        encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(50, 140, 300, 20);
        frame.add(encryptButton);

        // Output field for ciphertext
        outputField = new JTextField();
        outputField.setBounds(50, 170, 300, 20);
        outputField.setEditable(false);
        frame.add(outputField);

        // Add action listener to button
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plaintext = inputField.getText();
                String selectedAlgorithm = (String) algorithmSelector.getSelectedItem();
                EncryptionService encryptionService;

                if ("Morse Code".equals(selectedAlgorithm)) {
                    encryptionService = new EncryptionService(new MorseCode());
                } else {
                    encryptionService = new EncryptionService(new CaesarCipher(3));
                }

                String ciphertext = encryptionService.encrypt(plaintext);
                outputField.setText(ciphertext);
            }
        });

        frame.setVisible(true);
    }
}

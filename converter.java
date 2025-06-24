import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.*;

public class converter {
    public static void main(String[] args) {
        JFrame f=new JFrame("Converter");
        f.setTitle("Unit Converter");
        // f.setBounds(800,600,0,0);
        
        f.setSize(800,600);
        f.setResizable(false);
        f.getContentPane().setBackground(Color.PINK);
        f.setLayout(null);
        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // f.setLocationRelativeTo(null);
f.add(new JLabel(new ImageIcon("/Users/armangupta/Desktop/icon.png")));

        JLabel l1 = new JLabel("Unit Converter");
        l1.setBounds(300, 20, 200, 30);
        l1.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 24));
        l1.setForeground(Color.BLUE);
        f.add(l1);
        JLabel l2 = new JLabel("Enter Value:");
        l2.setBounds(50, 80, 100, 30);
        l2.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        l2.setForeground(Color.BLUE);
        f.add(l2);

        JTextField inputField = new JTextField();
        inputField.setBounds(150, 80, 200, 30);
        inputField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));

        f.add(inputField);

        JLabel l3 = new JLabel("Convert From:");
        l3.setBounds(50, 130, 120, 30);
        l3.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        l3.setForeground(Color.BLUE);
        f.add(l3);
        String[] units = {"Meters", "Kilometers", "Miles", "Feet", "Inches"};
        JComboBox<String> fromUnit = new JComboBox<>(units);
        fromUnit.setBounds(180, 130, 150, 30);
        fromUnit.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        f.add(fromUnit);   
        JLabel l4 = new JLabel("Convert To:");
        l4.setBounds(50, 180, 120, 30);
        l4.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        l4.setForeground(Color.BLUE);
        f.add(l4);
        JComboBox<String> toUnit = new JComboBox<>(units);
        toUnit.setBounds(180, 180, 150, 30);
        toUnit.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        f.add(toUnit); 
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 230, 150, 40);
        convertButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        convertButton.setForeground(Color.black);
        convertButton.setBackground(Color.RED);
        convertButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f.add(convertButton);

        // JTextArea for displaying results
    JTextArea resultArea = new JTextArea();
    resultArea.setBounds(50, 290, 700, 200);
    resultArea.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
    resultArea.setEditable(false);
    resultArea.setLineWrap(true);
    resultArea.setWrapStyleWord(true);
    resultArea.setText("Result will be displayed here after conversion.");


    convertButton.addActionListener(e -> {
        double value = Double.parseDouble(inputField.getText());
        String from = (String) fromUnit.getSelectedItem();
        String to = (String) toUnit.getSelectedItem();
        double convertedValue = 0.0;
        if (from.equals("Meters")) {
            if (to.equals("Kilometers")) {
                convertedValue = value / 1000;
            } else if (to.equals("Miles")) {
                convertedValue = value * 0.000621371;
            } else if (to.equals("Feet")) {
                convertedValue = value * 3.28084;
            } else if (to.equals("Inches")) {   
                convertedValue = value * 39.3701;
            } else {
                convertedValue = value; // Meters to Meters
            }
        } else if (from.equals("Kilometers")) {
            if (to.equals("Meters")) {
                convertedValue = value * 1000;
            } else if (to.equals("Miles")) {
                convertedValue = value * 0.621371;
            } else if (to.equals("Feet")) {
                convertedValue = value * 3280.84;
            } else if (to.equals("Inches")) {
                convertedValue = value * 39370.1;
            } else {
                convertedValue = value; // Kilometers to Kilometers
            }
        } else if (from.equals("Miles")) {
            if (to.equals("Meters")) {
                convertedValue = value / 0.000621371;
            } else if (to.equals("Kilometers")) {           
                convertedValue = value / 0.621371;
            } else if (to.equals("Feet")) {
                convertedValue = value * 5280;
            } else if (to.equals("Inches")) {
                convertedValue = value * 63360;
            } else {
                convertedValue = value; // Miles to Miles
            }
        } else if (from.equals("Feet")) {
            if (to.equals("Meters")) {
                convertedValue = value / 3.28084;
            } else if (to.equals("Kilometers")) {
                convertedValue = value / 3280.84;
            } else if (to.equals("Miles")) {
                convertedValue = value / 5280;
            } else if (to.equals("Inches")) {
                convertedValue = value * 12;
            } else {
                convertedValue = value; // Feet to Feet
            }
        } else if (from.equals("Inches")) {
            if (to.equals("Meters")) {      
                convertedValue = value / 39.3701;
            } else if (to.equals("Kilometers")) {
                convertedValue = value / 39370.1;
            } else if (to.equals("Miles")) {
                convertedValue = value / 63360;
            } else if (to.equals("Feet")) {
                convertedValue = value / 12;
            } else {
                convertedValue = value; // Inches to Inches
            }
        }
        resultArea.setText(String.format("%.2f",  convertedValue));

        DefaultListModel<String> historyModel = new DefaultListModel<>();
JList<String> historyList = new JList<>(historyModel);
historyList.setBounds(500, 80, 250, 180);
historyList.setBackground(Color.LIGHT_GRAY);
historyList.setBounds(500, 80, 250, 100);
f.add(historyList);

// Inside convertButton action
historyModel.addElement(String.format("%.2f %s → %.2f %s", value, from, convertedValue, to));

    });

        
        resultArea.setText("\n\n\n                                Result will be displayed here after conversion.");
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setBackground(Color.white);
        resultArea.setForeground(Color.BLACK);
        resultArea.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        resultArea.setBounds(50, 290, 700, 200);
        resultArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    f.add(resultArea);

        f.add(convertButton);
        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(320, 230, 150, 40);
        resetButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        resetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetButton.setBackground(Color.RED);
        resetButton.setForeground(Color.black);
        resetButton.addActionListener(e -> {
            inputField.setText("");
            fromUnit.setSelectedIndex(0);
            toUnit.setSelectedIndex(0);
            resultArea.setText("");
        });



        f.add(resetButton);
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(490, 230, 150, 40);
        exitButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        exitButton.setForeground(Color.black);
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.setBackground(Color.RED);
        exitButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(f, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                f.dispose();
            }
        });

        f.add(exitButton); 
        
        
            JButton swapButton = new JButton("⇄");
    swapButton.setBounds(340, 155, 50, 30);
    swapButton.addActionListener(e -> {
        int fromIndex = fromUnit.getSelectedIndex();
        fromUnit.setSelectedIndex(toUnit.getSelectedIndex());
        toUnit.setSelectedIndex(fromIndex);
    });
    f.add(swapButton);

    JButton copyButton = new JButton("Copy Result");
copyButton.setBounds(50, 500, 150, 30);
copyButton.addActionListener(e -> {
    StringSelection stringSelection = new StringSelection(resultArea.getText());
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, null);
});
f.add(copyButton);





        f.setLocationRelativeTo(null);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }



}

    

package pl.waw.sgh.bank.ui;

import javax.swing.*;
import java.awt.*;

public class FirstWindows {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("My Window");
        myFrame.setSize(400, 600);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X exits from JVM, finishes the process
        myFrame.setLayout(new FlowLayout());

        JPanel firstNamePanel = new JPanel();
        JLabel label1 = new JLabel("First Name");
        JTextField firstName = new JTextField(25);
        firstNamePanel.add(label1);
        firstNamePanel.add(firstName);
        myFrame.add(firstNamePanel);

        JPanel lastNamePanel = new JPanel();
        JLabel label2 = new JLabel("Last Name");
        JTextField lastName = new JTextField(25);
        lastNamePanel.add(label2);
        lastNamePanel.add(lastName);
        myFrame.add(lastNamePanel);

        JPanel buttonsPanel = new JPanel();
        JButton okButton = new JButton("OK");
        buttonsPanel.add(okButton);
        myFrame.add(buttonsPanel);



        myFrame.setVisible(true); //put in the end
    }
}

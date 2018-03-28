package pl.waw.sgh;

import javax.swing.*;
import java.util.InputMismatchException;

public class GuiInput {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hello!");
//        String myText = JOptionPane.showInputDialog("What is your name");
//        JOptionPane.showMessageDialog(null, "Nice to meet you "+myText);

        Double height = null;
        while (height==null){
            try {
                String sHeight = JOptionPane.showInputDialog("What is your height in cm");
                height = Double.parseDouble(sHeight);
            } catch (NumberFormatException ne)  {
                JOptionPane.showMessageDialog(null, ne.getMessage());
            }
        }
//        String sHeight = JOptionPane.showInputDialog("What is your height in cm");
//        Double height = Double.parseDouble(sHeight);
//
//        //Integer.parseInt(sHeight);
//        //Long.parseLong(sHeight);
        JOptionPane.showMessageDialog(null, "Your height in m is: "+height/100);


//        int res=-1;
//        while (res!=0){
//        res = JOptionPane.showConfirmDialog(null, "Are your sure that is your name?");
//        JOptionPane.showMessageDialog(null, "Result: ");
//       }
    }
}

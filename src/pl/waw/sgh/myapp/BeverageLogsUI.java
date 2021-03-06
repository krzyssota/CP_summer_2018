package pl.waw.sgh.myapp;

import pl.waw.sgh.Strings;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ContainerAdapter;
import java.util.ArrayList;
import java.util.List;

public class BeverageLogsUI {

    private JPanel MainPanel;
    private JTextField userNameTextField;
    private JTextField userWaterTextField;
    private JComboBox typeOfBestBeverage;
    private JButton showRecipesButton;
    private JTextField userIDTextField;
    private JButton saveNewUserButton;
    private JButton deleteCurrentUserButton;
    private JTextField fetTextField;
    private JTextField doseTextField;
    private JTextField waterTextField;
    private JTextField temperatureTextField;
    private JTextField timeTextField;
    private JTextField typeTextField;
    private JTextField scoreTextField;
    private JTextField grindLevelTextField;
    private JTextField tdsTextField;
    private JTextField whichSteepingTextField;
    private JButton saveRecipeButton;
    private JTextPane listOfBeveragesTextPane;
    private JComboBox fetComboBox;
    private JSpinner userIDSpinner;

    //Database
    //TODO save the database somewhere. csv for example
    LogBase logBase = new LogBase();

    User u1 = logBase.createUser("Krzys", "50/50");
    User u2 = logBase.createUser("Janka", "100/70");
    User u3 = logBase.createUser("Julka", "60/70");
    User u4 = logBase.createUser("Tosia", "50/60");
    User u5 = logBase.createUser("Paweł", "100/100");

    Beverage bev3 = logBase.createBeverage(2, u1, 8, 400, 90, "240s", "Oolong", 7, 0, 0, 1);
    Beverage bev4 = logBase.createBeverage(2, u1, 8, 400, 90, "120s", "Oolong", 8, 0, 0, 2);
    Beverage bev5 = logBase.createBeverage(2, u1, 6, 300, 95, "60s", "Pu-ehr", 9, 0, 0, 1);

    Beverage bev8 = logBase.createBeverage(2, u2, 6, 400, 70, "60s", "Green", 10, 0, 0, 1);
    Beverage bev9 = logBase.createBeverage(2, u2, 6, 600, 70, "180s", "Green", 7, 0, 0, 2);
    Beverage bev10 = logBase.createBeverage(1, u2, 12, 50, 93, "120s", "Brasil", 9, 4, 19, 0);

    Beverage bev1 = logBase.createBeverage(0, u3, 12, 200, 95, "120s", "Kenya", 8, 15, 1.3, 1);
    Beverage bev2 = logBase.createBeverage(0, u3, 12, 200, 97, "120s", "Kenya", 9, 14, 1.4, 1);
    Beverage bev6 = logBase.createBeverage(0, u3, 12, 200, 97, "120s", "Brasil", 9, 14, 1.4, 1);
    Beverage bev7 = logBase.createBeverage(1, u3, 17, 40, 93, "35s", "Brasil", 4, 7, 9.6, 1);

    Beverage bev11 = logBase.createBeverage(1, u4, 20, 40, 94, "24s", "Colombia", 7, 7, 9.2, 1);
    Beverage bev12 = logBase.createBeverage(1, u4, 20, 55, 94, "32s", "Colombia", 6, 5, 9.8, 1);
    Beverage bev13 = logBase.createBeverage(1, u4, 20, 50, 94, "28s", "Colombia", 9, 6, 9.5, 1);

    Beverage bev14 = logBase.createBeverage(2, u5, 4, 400, 85, "120s", "White", 7, 0, 0, 1);
    Beverage bev15 = logBase.createBeverage(2, u5, 4, 300, 85, "180s", "White", 9, 0, 0, 2);
    Beverage bev16 = logBase.createBeverage(1, u5, 18, 300, 95, "150s", "Panama", 10, 20, 1.2, 1);

    public BeverageLogsUI() {

        $$$setupUI$$$();
        showRecipesButton.addActionListener(new ActionListener() { //show recipes of current user
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int currentUserID = (Integer) userIDSpinner.getValue();
                listOfBeveragesTextPane.setText(logBase.findBeveragesByUserID(currentUserID).toString());
            }
        });

        saveNewUserButton.addActionListener(new ActionListener() { //save new user with input name and water
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameTextField.getText();
                String userWater = userWaterTextField.getText();
                if (!userName.equals("") & !userWater.equals("")) {
                    logBase.createUser(userName, userWater);
                    JOptionPane.showMessageDialog(null, logBase);
                } else {
                    JOptionPane.showMessageDialog(MainPanel, "Missing data.");
                }
            }
        });

        saveRecipeButton.addActionListener(new ActionListener() { //save recipe to current user
            @Override
            public void actionPerformed(ActionEvent e) {

                String fetString = (String) fetComboBox.getSelectedItem(); //translate combobox to argument od create beverage
                int fetInt = 0;
                switch (fetString) {
                    case "Filter":
                        fetInt = 0;
                        break;
                    case "Espresso":
                        fetInt = 1;
                        break;
                    case "Tea":
                        fetInt = 2;
                        break;
                    default:
                        break;
                }

                int currentUserID = (Integer) userIDSpinner.getValue();
                User currentUser = logBase.findUserByID(currentUserID);

                if (!doseTextField.getText().equals("") && !waterTextField.getText().equals("") &&             //nonempty fields
                        !temperatureTextField.getText().equals("") && !timeTextField.getText().equals("") &&
                        !typeTextField.getText().equals("") && !scoreTextField.getText().equals("") &&
                        !grindLevelTextField.getText().equals("") && !tdsTextField.getText().equals("") &&
                        !whichSteepingTextField.getText().equals("")) {

                    logBase.createBeverage(
                            /*Integer.parseInt(fetTextField.getText()),*/
                            fetInt,
                            currentUser,
                            Double.parseDouble(doseTextField.getText()),
                            Double.parseDouble(waterTextField.getText()),
                            Integer.parseInt(temperatureTextField.getText()),
                            timeTextField.getText(),
                            typeTextField.getText(),
                            Integer.parseInt(scoreTextField.getText()),
                            Integer.parseInt(grindLevelTextField.getText()),
                            Double.parseDouble(tdsTextField.getText()),
                            Integer.parseInt(whichSteepingTextField.getText())
                    );
                    //createBeverage (int fet, User user, double dose, double waterUsed, int temperature
                    // String time, String type, int score, Integer grindLevel, double tds,  int noSteeps
                    JOptionPane.showMessageDialog(MainPanel, "Recipe\n" + logBase.bevsList.get(logBase.bevsList.size() - 1) + "\nsaved to user:\n" + currentUser);
                } else {
                    JOptionPane.showMessageDialog(MainPanel, "Missing data. All text fields should be filled.\n" +
                            "If you want to save coffee recipe type 0 in which steeping text field.\n" +
                            "If you want to save tea recipe type 0 in grind level and tds text field.");
                }
            }
        });
        deleteCurrentUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentUserID = (Integer) userIDSpinner.getValue();
                JOptionPane.showConfirmDialog(MainPanel, "Are you sure you want to delete user: " + logBase.findUserByID(currentUserID) + "?");
                logBase.deleteUserAndHisHersBeverages(currentUserID);
                userNameTextField.setText("");
                userWaterTextField.setText("");
            }
        });

    }

    private void createUIComponents() {

        int n = logBase.countTypes();                           //combobox of origins/types of tea
        String[] typesStrings = logBase.getListOfTypes(n);
        typeOfBestBeverage = new JComboBox(typesStrings);
        typeOfBestBeverage.setSelectedIndex(0);

        typeOfBestBeverage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typeName = (String) typeOfBestBeverage.getSelectedItem();
                listOfBeveragesTextPane.setText(logBase.findBestRecipeByType(typeName).toString());
            }
        });

        String[] fetStrings = new String[3];            // combobox of espresso/filter/tea
        fetStrings[0] = "Filter";
        fetStrings[1] = "Espresso";
        fetStrings[2] = "Tea";
        fetComboBox = new JComboBox(fetStrings);
        fetComboBox.setSelectedIndex(0);

        //jspinner with user ids
        SpinnerNumberModel spinnerRange = new SpinnerNumberModel(0, 0, (int) logBase.getLastUserID(), 1);
        userIDSpinner = new JSpinner(spinnerRange);

        userIDSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentUserID = (Integer) userIDSpinner.getValue();
                userNameTextField.setText(logBase.findUserByID(currentUserID).getName());
                userWaterTextField.setText(logBase.findUserByID(currentUserID).getWaterMineralization());
            }
        });
    }

    public static void main(String[] args) {
        JFrame customerFrame = new JFrame("Log Base");
        BeverageLogsUI beverageLogsUI = new BeverageLogsUI();
        customerFrame.add(beverageLogsUI.MainPanel);
        customerFrame.pack();
        customerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        customerFrame.setVisible(true);
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        MainPanel = new JPanel();
        MainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(13, 4, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("User ID");
        MainPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Name");
        MainPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Water Mineralization");
        MainPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(109, 22), null, 0, false));
        userNameTextField = new JTextField();
        MainPanel.add(userNameTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userWaterTextField = new JTextField();
        MainPanel.add(userWaterTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 22), null, 0, false));
        showRecipesButton = new JButton();
        showRecipesButton.setText("Show recipes");
        MainPanel.add(showRecipesButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveNewUserButton = new JButton();
        saveNewUserButton.setText("Save new user");
        MainPanel.add(saveNewUserButton, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteCurrentUserButton = new JButton();
        deleteCurrentUserButton.setText("Delete current user");
        MainPanel.add(deleteCurrentUserButton, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(135, 22), null, 0, false));
        MainPanel.add(typeOfBestBeverage, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(42, 8), null, 0, false));
        doseTextField = new JTextField();
        MainPanel.add(doseTextField, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        waterTextField = new JTextField();
        MainPanel.add(waterTextField, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        temperatureTextField = new JTextField();
        MainPanel.add(temperatureTextField, new com.intellij.uiDesigner.core.GridConstraints(7, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        timeTextField = new JTextField();
        MainPanel.add(timeTextField, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        typeTextField = new JTextField();
        MainPanel.add(typeTextField, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        scoreTextField = new JTextField();
        MainPanel.add(scoreTextField, new com.intellij.uiDesigner.core.GridConstraints(9, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        grindLevelTextField = new JTextField();
        MainPanel.add(grindLevelTextField, new com.intellij.uiDesigner.core.GridConstraints(9, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tdsTextField = new JTextField();
        MainPanel.add(tdsTextField, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        whichSteepingTextField = new JTextField();
        MainPanel.add(whichSteepingTextField, new com.intellij.uiDesigner.core.GridConstraints(11, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Dose");
        MainPanel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Water used");
        MainPanel.add(label5, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Temperature");
        MainPanel.add(label6, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Time");
        MainPanel.add(label7, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Origin of coffee, Type of tea");
        MainPanel.add(label8, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Score");
        MainPanel.add(label9, new com.intellij.uiDesigner.core.GridConstraints(8, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Grind Lever");
        MainPanel.add(label10, new com.intellij.uiDesigner.core.GridConstraints(8, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("TDS");
        MainPanel.add(label11, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("which Steeping");
        MainPanel.add(label12, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveRecipeButton = new JButton();
        saveRecipeButton.setText("Save recipe");
        MainPanel.add(saveRecipeButton, new com.intellij.uiDesigner.core.GridConstraints(11, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listOfBeveragesTextPane = new JTextPane();
        MainPanel.add(listOfBeveragesTextPane, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JSeparator separator1 = new JSeparator();
        MainPanel.add(separator1, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JSeparator separator2 = new JSeparator();
        MainPanel.add(separator2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("Show best recipe of brewing:");
        MainPanel.add(label13, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(91, 8), null, 0, false));
        MainPanel.add(fetComboBox, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        userIDSpinner.setEnabled(true);
        MainPanel.add(userIDSpinner, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MainPanel;
    }
}

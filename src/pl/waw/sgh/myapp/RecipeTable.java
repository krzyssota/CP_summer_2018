package pl.waw.sgh.myapp;

import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import pl.waw.sgh.myapp.Coffee;

public class RecipeTable extends DefaultTableModel {


        private static String[] columnNames = { "bevID", "F/E/T", "Dose", "water Used", "temperature", "time", "type", "score", "Grind level", "TDS", "which Steeping"};

        private List<Beverage> bevsList = new ArrayList<>();

        public Beverage getBeverageByRow (int row){ //gets recipes from list of beverages
            return bevsList.get(row);
        }

        public RecipeTable(List<Beverage> bevsList) { //adds recipes to table
            super(columnNames, 0);
            addRows(bevsList);
        }

        public void removeAllRows() {  //clears table when switching users
            dataVector.clear();
            bevsList.clear();
            fireTableDataChanged();
        }

        public void addRows(List<Beverage> bevsList) { //add recipes in gui
            for (Beverage bev : bevsList) {
                addRow(bev);
            }
        }

        public void addRow(Beverage bev) { //add recipe
            bevsList.add(bev);
            addRow(getVectorFromBeverage(bev));
            fireTableDataChanged();
        }

        public Vector getVectorFromBeverage (Beverage bev) {
            Vector vc = new Vector();
            vc.add(bev.getBeverageID());
            vc.add(bev.getClass().getSimpleName());
            vc.add(bev.getDose());
            vc.add(bev.getWaterUsed());
            vc.add(bev.getTemperature());
            vc.add(bev.getTime());
            vc.add(bev.getType());
            vc.add(bev.getScore());
            vc.add(bev.getGrindLevel());
            vc.add(bev.getTds());
            vc.add(bev.getNoSteeps());
            return vc;
        }


        @Override
        public Class getColumnClass(int colIndex) {
            switch (colIndex) {
                case 0:
                    return int.class;
                case 1:
                    return String.class;
                case 2:
                    return Double.class;
                case 3:
                    return Double.class;
                case 4:
                    return int.class;
                case 5:
                    return String.class;
                case 6:
                    return String.class;
                case 7:
                    return int.class;
                case 8:
                    return Integer.class;
                case 9:
                    return double.class;
                case 10:
                    return int.class;
                default:
                    return Object.class;
            }
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 1 || col==0) return false;
            return true;
        }

        @Override
        public void setValueAt (Object newVal, int row, int col){
            super.setValueAt(newVal, row, col);
            Beverage bev = bevsList.get(row);
            switch (col){
                case 2:
                    bev.setDose((Double)newVal);
                    return;
                case 3:
                    bev.setWaterUsed((Double)newVal);
                    return;
                case 4:
                    bev.setTemperature((int)newVal);
                    return;
                case 5:
                    bev.setTime((String)newVal);
                    return;
                case 6:
                    bev.setType((String)newVal); //newVal.toString() ?
                    return;
                case 7:
                    bev.setScore((int)newVal);
                    return;
                case 8:
                    bev.setGrindLevel((Integer)newVal);
                    return;
                case 9:
                    bev.setTds((Double)newVal);
                    return;
                case 10:
                    bev.setNoSteeps((int)newVal);
                    return;
            }
        }
}

package pl.waw.sgh.myapp;

import pl.waw.sgh.bank.exceptions.NonExistantAccountException;
import sun.rmi.runtime.Log;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.List;

public class LogBase {

    List<User> usersList = new ArrayList<>();
    List<Beverage> bevsList = new ArrayList<>();

    private Integer lastUserID = 0;
    private Integer lastBevID = 0;

    public User createUser(String Name, String waterMineralization) {
        User user = new User(lastUserID++, Name, waterMineralization);
        usersList.add(user);
        return user;
    }
    /*public void addBeverage(Beverage bev){
        bev.setID(lastBevID++);
        bevsList.add(bev);
    }*/  //TODO consider changing to dis

    public Beverage createBeverage (int fet, User user, double dose, double waterUsed, int temperature, String time, String type, int score, Integer grindLevel, double tds,  int noSteeps ) {
        if (fet==0) {
            Beverage beverage = new Filter(lastBevID++, user, dose, waterUsed, temperature, time, type, score, grindLevel, tds, tds*waterUsed/dose);
            bevsList.add(beverage);
            return beverage;
        }
        if (fet==1) {
            Beverage beverage = new Espresso(lastBevID++, user, dose, waterUsed, temperature, time, type, score, grindLevel, tds, tds*waterUsed/dose);
            bevsList.add(beverage); //TODO does extraction work?
            return beverage;
        }
        if (fet==2) {
            Beverage beverage = new Tea(lastBevID++, user, dose, waterUsed, temperature, time, type, score, noSteeps);
            bevsList.add(beverage);
            return beverage;
        }
        return null; //TODO handle exeption
    }
    public List<String> getListOfTypes(){
        List<String> typesList = new ArrayList();
        typesList.add(bevsList.get(0).getType());
        for (Beverage bev:bevsList){
            if (bevsList.indexOf(bev)!=0 && bev.getType() != bevsList.get(bevsList.indexOf(bev)-1).getType()){
                    typesList.add(bev.getType());
            }
        }
        return typesList;
    }
    public List<Beverage> createAListOfBeveragesOfTheSameType(String typeName){
        List<Beverage> listOfBeveragesOfTheSameType = new ArrayList<>();
        for (Beverage bev:bevsList){
            if (bev.getType().equals(typeName)){
                listOfBeveragesOfTheSameType.add(bev);
            }
        }
        return listOfBeveragesOfTheSameType;
    }

    public Beverage findBestRecipeByType(String typeName){
        List<Beverage> listOfBeveragesOfTheSameType = createAListOfBeveragesOfTheSameType(typeName);
        Beverage bestRecipe = listOfBeveragesOfTheSameType.get(0);
        for (Beverage bev:listOfBeveragesOfTheSameType){
            if (listOfBeveragesOfTheSameType.indexOf(bev)!=0 && bev.getScore() >= bestRecipe.getScore()){
                bestRecipe = bev;
            }
        }
        return bestRecipe;
    }

    public void deleteUserAndHisHersBeverages (Integer userID) {
        deleteUser(userID);
        deleteBeveragesByUserID(userID);
    }

    public void deleteUser (Integer userID) {
        User userToDel = findUserByID(userID);
        usersList.remove(userToDel);
    }

    public void deleteBeveragesByUserID (Integer userID) {
        List<Beverage> bevToDel = findBeveragesByUserID(userID);
        int i=bevToDel.size()-1;
        while (i>=0) {
            bevsList.remove(bevToDel.get(i));
            i--;
        }
    }

    public List<Beverage> findBeveragesByUserID(Integer userID){
        List<Beverage> allBevsWithUserID= new ArrayList<>();
        for (Beverage bev : bevsList) {
            if ( userID.equals(bev.getUser().getUserID())) {  //TODO add getter and setter in user
                allBevsWithUserID.add(bev);
            }
        }
        return allBevsWithUserID;
    }

    public User findUserByID (Integer userID) {
        for (User user : usersList) {
            if (userID==user.getUserID())
                return user;
        }
        return null;
    }

    /*public Beverage findBeverageByID (int bevID) throws NonExistantAccountException{
        for (Beverage bev : bevsList) {
            if (bevID == bev.getBeverageID())
                return bev;
        }
        throw new NonExistantBeverageException(  //TODO NEBE
                "Chosen beverage does not exist.");
    }*/

    @Override
    public String toString() {

        String res = "LogBase " +"\n" + "users: "+ usersList + "\n" +
                "beverages: \n";
        for (Beverage bev:bevsList) {
            Class originalClass = bev.getClass();
            res += originalClass.cast(bev).toString() + "\n";

        }
        return res;
    }

    public List<Beverage> getBevsList() {
        return bevsList;
    }
    public List<User> getUsersList() {
        return usersList;
    }
    public Integer getLastBevID() {
        return lastBevID;
    }
    public Integer getLastUserID() {
        return lastUserID;
    }
    public Integer getNewUserID() {
        return lastUserID++;
    }
    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
    public void setBevsList(List<Beverage> bevsList) {
        this.bevsList = bevsList;
    }
    public void setLastUserID (Integer lastUserID) {
        this.lastUserID = lastUserID;
    }
    public void setLastBevID (Integer lastBevID) {
        this.lastBevID = lastBevID;
    }
}


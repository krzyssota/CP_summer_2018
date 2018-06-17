package pl.waw.sgh.myapp;

public class User {

    private Integer userID;
    private String firstName;
    private String lastName;
    private String waterMineralization; //TODO GH/KH in 1 liter  add a format GH/KH
    // water should be a separate class?

    public User (Integer userID, String firstName, String lastName, String waterMineralization) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.waterMineralization = waterMineralization;
    }
}

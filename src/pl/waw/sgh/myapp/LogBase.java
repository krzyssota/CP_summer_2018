package pl.waw.sgh.myapp;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.List;

public class LogBase {
    List<User> usersList = new ArrayList<>();

    List<Beverage> bevsList = new ArrayList<>();

    private Integer lastUserID = 0;

    private Integer lastBevID = 0;

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

    public User createUser(String firstName, String lastName, String waterMineralization) {
        User user = new User(lastUserID++,firstName, lastName, waterMineralization);
        usersList.add(user);
        return user;
    }
}

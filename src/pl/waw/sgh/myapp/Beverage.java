package pl.waw.sgh.myapp;

public abstract class Beverage {

    private int beverageID;
    private double dose;
    private double waterUsed;
    private int temperature;
    private String time; //in seconds
    private String type; //origin/type of tea
    private User user;
    private int score;

    public Beverage(int beverageID, double dose, double waterUsed, int temperature, String time, String type, User user, int score) {
        this.beverageID = beverageID;
        this.dose = dose;
        this.waterUsed = waterUsed;
        this.temperature = temperature;
        this.time = time;
        this.type = type;
        this.user = user;
        this.score = score;
    }
    //getter setter toString
}
  //maybe rate each brew and show the best recipe of given coffee, tea?

    //reading csv files with prevous logs
    //herbata id 0 rodzaj (biala zielona itp) ratio temperatura czas woda (sklad mineralny)?
//kawa przelewowa id 1 drip/immersion kraj mielenie ratio temperatura czas woda
//espresso id 2 kraj mielenie ratio temperatura czas woda ciśnienie?
//beverage rodzaj/kraj ratio temperatura woda czas wzor na ekstrakcje: tds*beverageWater/gramatura
//                                                                     (bevWat = water-(2,08*gramatura)
// water GH KH for 1l, method dillute with destilled water
// user id first name last name email
// ui scroll through users, add user, delete user,
// view logs, add logs, delete logs, find the average ratio for coffee/region, add new water recipe

    //application (coffee, recipies origins, addaing your data)
//4-5 classes
//300-500 lines of code
//second week of the session, during office hours




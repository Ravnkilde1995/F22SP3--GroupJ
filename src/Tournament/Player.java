package Tournament;

public class Player {

    // fælles

    //Fields
    // ******************
    int playerid;
    String firstName;
    String lastName;
    int age;

    //Constructor
    // ******************
    public Player(int playerid, String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.playerid = playerid;
    }

    public Player(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    //Methods
    // ******************


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getPlayerid() {
        return playerid;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerid=" + playerid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
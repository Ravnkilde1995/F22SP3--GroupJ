package Tournament;

import java.util.ArrayList;
import java.util.Scanner;

public class Teams implements Comparable<Teams> {
    //Fields
    // ******************
    private String teamName;
    private int teamMembers;
    private int numberOfGoals;
    private int points;



    //Constructor
    //******************
    public Teams(String teamName, int teamMembers) {
        this.teamName = teamName;
        this.teamMembers = teamMembers;
    }

    public Teams(String teamName, int teamMembers, int numberOfGoals, int points) {
        this.teamName = teamName;
        this.teamMembers = teamMembers;
        this.numberOfGoals = numberOfGoals;
        this.points = points;
    }

    //Methods
    //******************
    public String getTeamName(){
        return teamName;
    }

    public int getNumberOfGoals() {
        return numberOfGoals;
    }

    public void setNumberOfGoals(int numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTeamMembers(){
        return teamMembers;
    }





    @Override
    public String toString() {
        return "Teams{" +
                "teamName='" + teamName + '\'' +
                ", teamMembers=" + teamMembers +
                ", numberOfGoals=" + numberOfGoals +
                ", points=" + points +
                '}';
    }

    @Override
    public int compareTo(Teams t) {
        return t.getPoints()-points;
    }
}

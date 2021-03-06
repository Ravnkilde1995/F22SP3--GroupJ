package Tournament;

import java.util.ArrayList;
import java.util.Scanner;

public class Teams implements Comparable<Teams> {
    //Fields
    // ******************
   ArrayList<Player> players = new ArrayList<Player>();

    private String teamName;
    private int teamid;
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

    public Teams(int teamid, String teamName, int teamMembers, int numberOfGoals, int points) {
        this.teamid = teamid;
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

    public int getTeamid() {
        return teamid;
    }

    public void setTeamMembers(int teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public String toString() {
        return "All teams: " +
                "teamName= " + teamName +
                ", teamMembers= " + teamMembers +
                ", numberOfGoals= " + numberOfGoals +
                ", points= " + points;
    }

    @Override
    public int compareTo(Teams t) {
        return t.getPoints()-points;
    }
}

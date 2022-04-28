package Tournament;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;

import static Tournament.DBConnection.connection;

public class TeamMenu {

    static TeamRepo teamRepo;

    public static void teamMenu(Scanner input, ArrayList<Teams> teams) {

        int answer = 1;

        while (answer != 0) {
            System.out.println("Team menu");
            System.out.println("****************************");
            System.out.println("Press 1 to create a team");
            System.out.println("Press 2 to assign points to team");
            System.out.println("Press 3 to assign goals and negative goals to team");
            System.out.println("Press 4 to show all teams assigned to tournament");
            System.out.println("Press 5 to delete a team");
            System.out.println("Press 6 to search for a team");
            System.out.println("Press 0 to return to main menu");

            answer = input.nextInt();

            switch (answer) {
                case 1:
                    createTeam(input, teams);
                    break;
                case 2:
                    addPointsToTeam(input, teams);
                    break;
                case 3:
                    addGoalsToTeam(input, teams);
                    break;
                case 4:
                    showAllTeams(teams);
                    break;
                case 5:
                    deleteTeam(input, teams);
                    break;
                case 6:
                    searchForTeams(input, teams);
                    break;
                case 0:
                    System.out.println("returning to main menu...");
                    break;
            }
        }
    }

    public static void createTeam(Scanner input, ArrayList<Teams> teams) {
        System.out.println("Input team name: ");
        String teamName = input.next();
        System.out.println("Input team members: ");
        int teamMembers = input.nextInt();
        Teams ole = new Teams(teamName, teamMembers);
        teams.add(ole);
        System.out.println("You're new team: " + ole);
        teamRepo.create(ole);
        teams=teamRepo.readAll();

    }

    public static void addPointsToTeam(Scanner input, ArrayList<Teams> teams) {
        System.out.println("Type in the name of the team you want to add points to: ");
        String teamID = input.next();
        System.out.println("Assign the total value of points: ");
        int points = input.nextInt();

        String sql = "UPDATE teams SET points = " + points + " WHERE teamid = " + teamID;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addGoalsToTeam(Scanner input, ArrayList<Teams> teams) {
        System.out.println("Type in the ID for the team you want to add goals to");
        String teamID = input.next();
        System.out.println("How many goals do you want to add?: ");
        int goals = input.nextInt();
        System.out.println("How many negative goals do you want to add?: ");
        int negativeGoals = input.nextInt();
        int allGoals = goals-negativeGoals;

        String sql = "UPDATE teams SET numberOfGoals = " + allGoals + " WHERE teamid = " + teamID;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showAllTeams(ArrayList<Teams> teams) {
        teamRepo.readAll();
        teams=teamRepo.readAll();
        for(Teams t : teams) {
            System.out.println(t);
        }
    }

    public static void deleteTeam(Scanner input, ArrayList<Teams> teams){
        System.out.println("Type the ID of the team you want to remove: ");
        int teamNumber = input.nextInt();
        teamRepo.delete(teamNumber);
    }

    public static void searchForTeams(Scanner input, ArrayList<Teams> teams) {
        System.out.println("Search for a team");
        String searchTeams = input.next();
        String sql = "SELECT * FROM teams WHERE teamname LIKE " + "'%" + searchTeams + "%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String teamName = rs.getString("teamName");
                int teamMembers = rs.getInt("teamMembers");
                int numberOfGoals = rs.getInt("numberOfGoals");
                int points = rs.getInt("points");

                System.out.println(teamName + ", " + teamMembers + ", " + numberOfGoals + ", " + points);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

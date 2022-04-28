package Tournament;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static Tournament.DBConnection.connection;



public class PlayerMenu {

    static PlayerRepo playerRepo;

    public static void playerMenu(Scanner input, ArrayList<Player> players, ArrayList<Teams> teams) {

        int answer = 1;

        while (answer != 0) {
            System.out.println("Player menu");
            System.out.println("****************************");
            System.out.println("Press 1 to create a player");
            System.out.println("Press 2 to add a player to a team");
            System.out.println("Press 3 to delete a player");
            System.out.println("Press 4 to search for a player");
            System.out.println("Press 0 to terminate the program");

            answer = input.nextInt();

            switch (answer) {
                case 1:
                    createPlayer(input, players);
                    break;
                case 2:
                    addPlayerToTeam(input, players, teams);
                    break;
                case 3:
                    deletePlayer(input, players);
                    break;
                case 4:
                    searchForPlayer(input, players);
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
            }
        }
    }

    public static void createPlayer(Scanner input, ArrayList<Player> players) {
        System.out.println("Input first name of player: ");
        String firstName = input.next();
        System.out.println("Input last name of player: ");
        String lastName = input.next();
        System.out.println("Input age of player: ");
        int age = input.nextInt();
        Player ole = new Player(firstName, lastName, age);
        players.add(ole);
        System.out.println("Your new player: " + ole);
        playerRepo.create(ole);
        players = playerRepo.readAll();

    }

    public static void addPlayerToTeam(Scanner input, ArrayList<Player> players, ArrayList<Teams> teams) {
        System.out.println("Type the number of the team you want to add a player to: ");
        for (int i = 0; i < teams.size(); i++) {
            if(teams.get(i).getTeamMembers()<=3) {
                System.out.println(i + 1 + ": " + teams.get(i));
            }
        }
        int teamNumber = input.nextInt();
        Teams selectedTeam = teams.get(teamNumber - 1);
        selectedTeam.setTeamMembers(selectedTeam.getTeamMembers()+1);

        System.out.println("Type the number of the player you want to add to the team: ");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(i + 1 + ": " + players.get(i));
        }
        int playerNumber = input.nextInt();
        Player selectedPlayer = players.get(playerNumber - 1);
        players.remove(selectedPlayer);
        selectedTeam.players.add(selectedPlayer);
    }

    public static void deletePlayer(Scanner input, ArrayList<Player> players) {
        System.out.println("Type the ID of the player you want to remove: ");
        int playerNumber = input.nextInt();
        playerRepo.delete(playerNumber);
    }

    public static void searchForPlayer(Scanner input, ArrayList<Player> players) {
        System.out.println("Search for a player");
        String searchPlayer = input.next();
        String sql = "SELECT * FROM players WHERE firstname LIKE " + "'%" + searchPlayer + "%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                int age = rs.getInt("age");

                System.out.println(firstName + ", " + lastName + ", " + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

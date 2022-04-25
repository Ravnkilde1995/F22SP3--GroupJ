package Tournament;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Teams> teams = new ArrayList<>();
        ArrayList<Match> matches = new ArrayList<>();
        ArrayList<Tournament> tournaments = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();

        DBConnection.createConnection();

        Menu.teamRepo = new TeamRepo();
        Teams testTeam = new Teams("ole", 4, 5,2);
        Menu.teamRepo.create(testTeam);
        teams = Menu.teamRepo.readAll();
        System.out.println(teams);

        PlayerRepo playerRepo = new PlayerRepo();
        Player testPlayer = new Player("Jane","Doe",30);
        playerRepo.create(testPlayer);
        players = playerRepo.readAll();
        System.out.println(players);

        FileIOTeams teamsIO = new FileIOTeams();
        teams=teamsIO.loadData();

        FileIOTournament tournamentIO = new FileIOTournament();
        tournaments=tournamentIO.loadData();

        FileIOMatch matchIO = new FileIOMatch(teams);
        matches=matchIO.loadData();

        Menu.mainMenu(input, teams, matches, tournaments);

        teamsIO.saveData(teams);
        tournamentIO.saveData(tournaments);
        matchIO.saveData(matches);

    }

}

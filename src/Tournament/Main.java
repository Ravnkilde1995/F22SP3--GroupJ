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

        /*

        Menu.teamRepo = new TeamRepo();
        Teams testTeam = new Teams("ole", 4, 5,2);
        Teams testTeam2 = new Teams ("søren", 4, 5, 2);
        Menu.teamRepo.create(testTeam);
        teams = Menu.teamRepo.readAll();


        PlayerRepo playerRepo = new PlayerRepo();
        Player testPlayer = new Player("Jane","Doe",30);
        playerRepo.create(testPlayer);
        players = playerRepo.readAll();


        Menu.matchRepo = new MatchRepo();
        Match testMatch = new Match(10,5,10, 1, 2);
        Menu.matchRepo.create(testMatch);
        matches = Menu.matchRepo.readAll();


        Menu.tournamentRepo = new TournamentRepo();
        Tournament testTournament = new Tournament(10, 12, "marts", "ole");
        Menu.tournamentRepo.create(testTournament);
        tournaments = Menu.tournamentRepo.readAll();

         */

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

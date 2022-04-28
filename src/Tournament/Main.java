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

        TeamMenu.teamRepo = new TeamRepo();
        teams = TeamMenu.teamRepo.readAll();

        PlayerMenu.playerRepo = new PlayerRepo();
        players = PlayerMenu.playerRepo.readAll();

        MatchMenu.matchRepo = new MatchRepo();
        matches = MatchMenu.matchRepo.readAll();

        TournamentMenu.tournamentRepo = new TournamentRepo();
        tournaments = TournamentMenu.tournamentRepo.readAll();


        FileIOTeams teamsIO = new FileIOTeams();
        teams=teamsIO.loadData();

        FileIOTournament tournamentIO = new FileIOTournament();
        tournaments=tournamentIO.loadData();

        FileIOMatch matchIO = new FileIOMatch(teams);
        matches=matchIO.loadData();

        Menu.mainMenu(input, teams, matches, tournaments, players);
        TeamMenu.teamMenu(input, teams);
        TournamentMenu.tournamentMenu(input, teams, tournaments);
        PlayerMenu.playerMenu(input, players, teams);
        MatchMenu.matchMenu(input, matches, teams);

        teamsIO.saveData(teams);
        tournamentIO.saveData(tournaments);
        matchIO.saveData(matches);

    }

}

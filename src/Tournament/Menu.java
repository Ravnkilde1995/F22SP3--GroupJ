package Tournament;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    //Fields
    //**********
   static ArrayList<Teams> teamsInTournament = new ArrayList<Teams>();
   static TeamRepo teamRepo;
   static TournamentRepo tournamentRepo;
   static MatchRepo matchRepo;
   static PlayerRepo playerRepo;


   public static void mainMenu(Scanner input, ArrayList<Teams> teams, ArrayList<Match> matches, ArrayList<Tournament> tournaments, ArrayList<Player> players) {

        int answer = 1;

        while (answer != 0) {
            System.out.println("GruppeJ´s fodboldtunering");
            System.out.println("****************************");
            System.out.println("Press 1 for \"Team menu\"");
            System.out.println("Press 2 for \"Player menu\"");
            System.out.println("Press 3 for \"Tournament menu\"");
            System.out.println("Press 4 for \"Match menu\"");
            System.out.println("Press 0 to terminate the program");
            answer = input.nextInt();

            switch (answer) {
                case 1:
                    TeamMenu.teamMenu(input, teams);
                    break;
                case 2:
                    PlayerMenu.playerMenu(input, players, teams);
                    break;
                case 3:
                    TournamentMenu.tournamentMenu(input, teams, tournaments);
                    break;
                case 4:
                    MatchMenu.matchMenu(input, matches, teams);
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
            }
        }
    }
}

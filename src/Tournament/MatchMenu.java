package Tournament;

import java.util.ArrayList;
import java.util.Scanner;

public class MatchMenu {

    static MatchRepo matchRepo;

    public static void matchMenu(Scanner input, ArrayList<Match> matches, ArrayList<Teams> teams) {

        int answer = 1;

        while (answer != 0) {
            System.out.println("Match menu");
            System.out.println("****************************");
            System.out.println("Press 1 for to create a match");
            System.out.println("Press 2 for show all upcoming matches");
            System.out.println("Press 0 to terminate the program");

            answer = input.nextInt();

            switch (answer) {
                case 1:
                    createMatch(input, matches, teams);
                    break;
                case 2:
                    showAllMatches(matches);
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
            }
        }
    }

    public static void createMatch(Scanner input, ArrayList<Match> matches, ArrayList<Teams> teams) {
        System.out.println("Type the number of the first team: ");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println(i + 1 + ": " + teams.get(i));
        }
        int teamNumber = input.nextInt();
        Teams teamOne = teams.get(teamNumber - 1);

        System.out.println("Type the number of the second team: ");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println(i + 1 + ": " + teams.get(i));
        }
        teamNumber = input.nextInt();
        Teams teamTwo = teams.get(teamNumber - 1);
        System.out.println("Enter date of match start: ");
        int matchDate = input.nextInt();
        System.out.println("Enter month of match start: ");
        int matchMonth = input.nextInt();
        System.out.println("Enter time of match start: ");
        int matchTime = input.nextInt();
        Match newMatch = new Match(matchMonth, matchDate, matchTime, teamOne, teamTwo);
        matches.add(newMatch);
        matchRepo.create(newMatch);
        System.out.println(newMatch);
    }

    public static void showAllMatches(ArrayList<Match> matches) {
        matchRepo.readAll();
        matches=matchRepo.readAll();
        for(Match m : matches) {
            System.out.println(m);
        }
    }

    public static void deleteMatch(Scanner input, ArrayList<Match> matches) {
        System.out.println("Type the ID of the match you want to remove: ");
        int teamNumber = input.nextInt();
        matchRepo.delete(teamNumber);
    }
}

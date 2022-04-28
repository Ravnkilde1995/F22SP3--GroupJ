package Tournament;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TournamentMenu {

    static ArrayList<Teams> teamsInTournament = new ArrayList<Teams>();
    static TournamentRepo tournamentRepo;


    public static void tournamentMenu(Scanner input, ArrayList<Teams> teams, ArrayList<Tournament> tournaments) {

        int answer = 1;

        while (answer != 0) {
            System.out.println("Tournament menu");
            System.out.println("****************************");
            System.out.println("Press 1 to create tournament");
            System.out.println("Press 2 to show the placement of teams");
            System.out.println("Press 3 to add team to tournament");
            System.out.println("Press 4 to show all tournaments");
            System.out.println("Press 5 to remove a team from tournament");
            System.out.println("Press 6 to show all teams in tournament");
            System.out.println("Press 0 to return to main menu");

            answer = input.nextInt();

            switch (answer) {
                case 1:
                    createTournament(input, tournaments);
                    break;
                case 2:
                    showPlacement(teams);
                    break;
                case 3:
                    addTeamToTournament(input, teams);
                    break;
                case 4:
                    showTournaments(tournaments);
                    break;
                case 5:
                    removeTeamFromTournament(input);
                    break;
                case 6:
                    showTeamsAddedToTournament();
                    break;
                case 0:
                    System.out.println("returning to main menu...");
                    break;
            }
        }
    }

    public static void createTournament(Scanner input, ArrayList<Tournament> tournaments) {
        System.out.println("Type tournament name");
        String tournamentName = input.next();
        System.out.println("Type in the date of the tournament");
        String date = input.next();
        System.out.println("Type in the start time of the tournament");
        int startTime = input.nextInt();
        System.out.println("Type in the end time of the tournament");
        int endTime = input.nextInt();
        Tournament tournament1 = new Tournament(startTime, endTime, date, tournamentName);
        tournaments.add(tournament1);
        tournamentRepo.create(tournament1);
    }

    public static void addTeamToTournament(Scanner input, ArrayList<Teams> teams){
        if(teams.size()< 8){
            System.out.println("You need to have 8 teams.");
            return;
        }
        while(teamsInTournament.size()< 8) {
            System.out.println("Type the number of the team you want to add to the tournament: ");
            for (int i = 0; i < teams.size(); i++) {
                System.out.println(i + 1 + ": " + teams.get(i));
            }
            int teamNumber = input.nextInt();
            Teams selectedTeam = teams.get(teamNumber - 1);
            teamsInTournament.add(selectedTeam);
        }
    }

    public static void removeTeamFromTournament(Scanner input){
        System.out.println("Type the number of the team you want to remove from the tournament: ");
        for(int i = 0; i< teamsInTournament.size();i++){
            System.out.println(i+1+": "+teamsInTournament.get(i));
        }
        int teamNumber = input.nextInt();
        teamsInTournament.remove(teamNumber-1);
    }

    public static void showTournaments(ArrayList<Tournament> tournaments) {
        tournamentRepo.readAll();
        tournaments=tournamentRepo.readAll();
        for(Tournament t : tournaments) {
            System.out.println(t);
        }
    }

    public static void showTeamsAddedToTournament(){
        for(Teams team : teamsInTournament){
            System.out.println(team);
        }
    }

    public static void showPlacement(ArrayList<Teams> teams) {
        Collections.sort(teams);

        for (int i = 0; i < teams.size(); i++) {
            Teams team = teams.get(i);
            System.out.println(i + 1 + ": " + team);
        }
    }
}

package Tournament;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIOTeams implements FileIO <Teams> {



    //methods
    //******************
    @Override
    public  void saveData(ArrayList<Teams> teams) {
        String gameData = "";
        for (Teams p : teams) {
            gameData += "Teamname: " + p.getTeamName() + " Members: " + p.getTeamMembers() + " Goals: " + p.getNumberOfGoals() + " Points: " + p.getPoints() + "\n" ;
        }
        try {
            FileWriter output = new FileWriter("src/tournament/teamData.txt");
            output.write(gameData);
            output.close();
        }
        catch (IOException e) {
        }
    }

    @Override
    public  ArrayList<Teams> loadData() {
        File text = new File("src/tournament/teamData.txt");
        ArrayList<Teams> teams = new ArrayList<>();
            try {
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length()>0) {
                    Scanner lineScanner = new Scanner(line);
                    lineScanner.next();
                    String teamName = lineScanner.next();
                    lineScanner.next();
                    int teamMembers = lineScanner.nextInt();
                    lineScanner.next();
                    int numberOfGoals = lineScanner.nextInt();
                    lineScanner.next();
                    int points = lineScanner.nextInt();
                    Teams loadedTeam = new Teams(teamName, teamMembers, numberOfGoals, points);
                    teams.add(loadedTeam);
                }
            }
         }
         catch (IOException e) {

         }
            return teams;
      }
    }



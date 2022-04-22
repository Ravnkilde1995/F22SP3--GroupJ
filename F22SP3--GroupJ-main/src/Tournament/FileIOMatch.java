package Tournament;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIOMatch implements FileIO<Match>{
    //Fields
    //*********

    ArrayList<Teams> teams;

    //Constructor
    //*********


    public FileIOMatch(ArrayList<Teams> teams) {
        this.teams = teams;
    }

    @Override
    public void saveData(ArrayList<Match> matches) {
        String gameData = "";
        for (Match a : matches) {
            gameData += "Teamone: " + a.getTeamOne().getTeamName() + " Teamtwo: " + a.getTeamTwo().getTeamName() +
                    " MatchMonth: " + a.getMatchMonth() + " MatchDate: " + a.getMatchDate() + " MatchTime: " +
                    a.getMatchTime() +"\n";
        }
        try {
            FileWriter output = new FileWriter("src/Tournament/MatchData.txt");
            output.write(gameData);
            output.close();
        }
        catch (IOException e) {
        }
    }


    @Override
    public ArrayList<Match> loadData() {
        File text = new File("src/Tournament/MatchData.txt");
        ArrayList<Match> matches = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length()>0) {
                    Scanner lineScanner = new Scanner(line);
                    lineScanner.next();
                    String teamNameOne = lineScanner.next();
                    Teams teamOne = null;
                    for(Teams team : teams){
                        if(team.getTeamName().equalsIgnoreCase(teamNameOne)){
                            teamOne = team;
                        }
                    }
                    lineScanner.next();
                    String teamNameTwo = lineScanner.next();
                    Teams teamTwo = null;
                    for(Teams team : teams){
                        if(team.getTeamName().equalsIgnoreCase(teamNameTwo)){
                            teamTwo = team;
                        }
                    }
                    lineScanner.next();
                    int matchMonth = lineScanner.nextInt();
                    lineScanner.next();
                    int matchDate = lineScanner.nextInt();
                    lineScanner.next();
                    int matchTime = lineScanner.nextInt();
                    Match loadedMatch = new Match(teamOne, teamTwo,  matchMonth,  matchDate, matchTime);
                    matches.add(loadedMatch);
                }
            }
        }
        catch (IOException e) {

        }
        return matches;
    }
}

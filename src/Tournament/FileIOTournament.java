package Tournament;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIOTournament implements FileIO<Tournament>{


    @Override
    public void saveData(ArrayList<Tournament> tournaments) {
        String gameData = "";
        for (Tournament a : tournaments) {
            gameData += "Starttime: " + a.getStartTime() + " Endtime: " + a.getEndTime() + " Date: " + a.getDate() + " Name: " + a.getTournamentName() + "\n";
        }
        try {
            FileWriter output = new FileWriter("src/Tournament/TournamentData.txt");
            output.write(gameData);
            output.close();
        }
        catch (IOException e) {
        }
    }
    @Override
    public ArrayList<Tournament> loadData() {
        File text = new File("src/Tournament/TournamentData.txt");
        ArrayList<Tournament> tournaments = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length()>0) {
                    Scanner lineScanner = new Scanner(line);
                    lineScanner.next();
                    int startTime = lineScanner.nextInt();
                    lineScanner.next();
                    int endTime = lineScanner.nextInt();
                    lineScanner.next();
                    String date = lineScanner.next();
                    lineScanner.next();
                    String name = lineScanner.next();
                    Tournament loadedTournament = new Tournament(startTime, endTime, date, name);
                    tournaments.add(loadedTournament);
                }
            }
        }
        catch (IOException e) {

        }
        return tournaments;
    }
}

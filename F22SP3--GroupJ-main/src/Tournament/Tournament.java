package Tournament;

import java.util.ArrayList;
import java.util.Scanner;

public class Tournament {
    //Fields
    // ******************
    private  int startTime;
    private int endTime;
    private String date;
    private String tournamentName;
    static ArrayList<Match> gamesPlayed;

    //Constructor
    //******************
    public Tournament( int startTime,int endTime, String date, String tournamentName){
        this.startTime=startTime;
        this.endTime=endTime;
        this.date=date;
        this.tournamentName=tournamentName;
    }

    //Methods
    //******************
    public int getStartTime(){
        return startTime;
    }

    public int getEndTime(){
        return endTime;
    }

    public String getDate(){
        return date;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", date='" + date + '\'' +
                ", tournamentName='" + tournamentName + '\'' +
                '}';
    }
}

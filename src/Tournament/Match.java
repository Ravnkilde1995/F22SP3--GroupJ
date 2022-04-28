package Tournament;

public class Match {

    //Fields
    // **

    private Teams teamTwo;
    private Teams teamOne;
    private int matchDate;
    private int matchTime;
    private int matchMonth;
    private int teamOneID;
    private int teamTwoID;


    //Constructor
    //**
    public Match(int matchMonth, int matchDate, int matchTime, Teams teamOne, Teams teamTwo){
        this.matchDate =matchDate;
        this.matchTime =matchTime;
        this.matchMonth = matchMonth;
        this.teamOne=teamOne;
        this.teamTwo=teamTwo;

    }

    //Created constructor

    public Match(int matchDate, int matchTime, int matchMonth, int teamOneID, int teamTwoID) {
        this.matchDate=matchDate;
        this.teamTwoID=teamTwoID;
        this.teamOneID=teamOneID;
        this.matchTime=matchTime;
        this.matchMonth=matchMonth;

    }

    //Methods
    //**


    public Teams getTeamTwo() {
        return teamTwo;
    }

    public Teams getTeamOne() {
        return teamOne;
    }

    public int getMatchDate() {
        return matchDate;
    }

    public int getMatchTime() {
        return matchTime;
    }

    public int getMatchMonth() {
        return matchMonth;
    }


    public int getTeamOneID() {
        return teamOneID;
    }

    public void setTeamOneID(int teamOneID) {
        this.teamOneID = teamOneID;
    }

    public int getTeamTwoID() {
        return teamTwoID;
    }

    public void setTeamTwoID(int teamTwoID) {
        this.teamTwoID = teamTwoID;
    }

    @Override
    public String toString() {
        return "Upcoming matches: " +
                "matchDate=" + matchDate +
                ", matchTime=" + matchTime +
                ", matchMonth=" + matchMonth +
                ", teamOneID=" + teamOneID +
                ", teamTwoID=" + teamTwoID;
    }
}
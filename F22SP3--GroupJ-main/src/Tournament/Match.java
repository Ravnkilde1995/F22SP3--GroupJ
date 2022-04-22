package Tournament;

public class Match {

    //Fields
    // **

    private Teams teamTwo;
    private Teams teamOne;
    private int matchDate;
    private int matchTime;
    private int matchMonth;


    //Constructor
    //**
    public Match(Teams teamOne, Teams teamTwo, int matchMonth, int matchDate, int matchTime){
        this.matchDate =matchDate;
        this.matchTime =matchTime;
        this.matchMonth = matchMonth;
        this.teamOne=teamOne;
        this.teamTwo=teamTwo;

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

    @Override
    public String toString() {
        String timeformated = "";
        if(matchTime <= 12) {
            timeformated=matchTime+" am";
        }
        else {
            timeformated=matchTime-12+ " pm";
        }
        return "\"" +teamOne+"\"" + " vs " + "\""+teamTwo+"\"" + "" +
                " is scheduled for: " +"\n" + matchMonth + "/" +matchDate + " at " +timeformated + ".";
    }
}
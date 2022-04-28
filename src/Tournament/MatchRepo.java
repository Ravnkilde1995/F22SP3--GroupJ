package Tournament;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Tournament.DBConnection.connection;

//Veronika

public class MatchRepo implements Repository <Match> {
    @Override
    public ArrayList<Match> readAll() {
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM matches");

            ResultSet result = statement.getResultSet();

            ArrayList<Match> matches = new ArrayList<>();

            while (result.next()) {
                int date = result.getInt("matchdate");
                int month = result.getInt("matchmonth");
                int time = result.getInt("matchtime");
                int teamOne = result.getInt("teamoneid");
                int teamTwo = result.getInt("teamtwoid");
                Match matchesTest = new Match(date, month, time, teamOne, teamTwo);

                matches.add(matchesTest);
            }
            return matches;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void create(Match matches) {
        try{
            String sql = "INSERT INTO matches(matchdate, matchmonth, matchtime, teamoneid, teamtwoid) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, matches.getTeamOneID());
            preparedStatement.setInt(2, matches.getTeamTwoID());
            preparedStatement.setInt(3, matches.getMatchMonth());
            preparedStatement.setInt(4, matches.getMatchDate());
            preparedStatement.setInt(5, matches.getMatchTime());
            preparedStatement.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}

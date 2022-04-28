package Tournament;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Tournament.DBConnection.connection;

public class TournamentRepo implements Repository<Tournament>{
    @Override
    public ArrayList<Tournament> readAll() {
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM tournament");

            ResultSet result = statement.getResultSet();

            ArrayList<Tournament> tournaments = new ArrayList<>();

            while (result.next()) {
                int startTime = result.getInt("startTime");
                int endTime = result.getInt("endTime");
                String date = result.getString("date");
                String tournamentName = result.getString("tournamentName");
                Tournament tournament = new Tournament(startTime, endTime, date, tournamentName);

                tournaments.add(tournament);
            }
            return tournaments;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        try{
            String sql = "DELETE FROM tournament WHERE tournamentID = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void create(Tournament tournament) {
        try{
            String sql = "INSERT INTO tournament(startTime, endTime, date, tournamentName) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tournament.getStartTime());
            preparedStatement.setInt(2, tournament.getEndTime());
            preparedStatement.setString(3, tournament.getDate());
            preparedStatement.setString(4, tournament.getTournamentName());
            preparedStatement.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

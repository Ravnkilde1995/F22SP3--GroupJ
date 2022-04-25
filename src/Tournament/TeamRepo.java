package Tournament;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Tournament.DBConnection.connection;

public class TeamRepo implements Repository <Teams>{



    //methods
    //*******************

    @Override
    public ArrayList<Teams> readAll() {

        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM teams");

            ResultSet result = statement.getResultSet();

            ArrayList<Teams> teams = new ArrayList<>();

            while (result.next()) {
                int teamid = result.getInt("teamid");
                String teamName = result.getString("teamname");
                int teamMembers = result.getInt("teammembers");
                int numberOfGoals = result.getInt("numberofgoals");
                int points = result.getInt("points");
                Teams team = new Teams(teamid, teamName,teamMembers,numberOfGoals, points );

                teams.add(team);
            }
            return teams;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void create(Teams teams) {

        try{
            String sql = "INSERT INTO teams(teamname, teammembers, numberofgoals, points) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, teams.getTeamName());
            preparedStatement.setInt(2, teams.getTeamMembers());
            preparedStatement.setInt(3, teams.getNumberOfGoals());
            preparedStatement.setInt(4, teams.getPoints());
            preparedStatement.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }



    @Override
    public void delete(int id) {

        try{

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

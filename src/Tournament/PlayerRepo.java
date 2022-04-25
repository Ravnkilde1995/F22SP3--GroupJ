package Tournament;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static Tournament.DBConnection.connection;

public class PlayerRepo implements Repository <Player>{

    //methods
    //******************

    @Override
    public ArrayList<Player> readAll() {
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM players");

            ResultSet result = statement.getResultSet();

            ArrayList<Player> players = new ArrayList<>();

            while (result.next()) {
                int playerid = result.getInt("playerid");
                String firstName = result.getString("firstname");
                String lastName = result.getString("lastname");
                int age = result.getInt("age");
                Player player = new Player(playerid, firstName, lastName, age);

                players.add(player);
            }
            return players;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(Player player) {

        try{
            String sql = "INSERT INTO players(firstname, lastname, age) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, player.getFirstName());
            preparedStatement.setString(2, player.getLastName());
            preparedStatement.setInt(3, player.getAge());
            preparedStatement.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {

        try{
            String sql = "DELETE FROM players WHERE playerid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
}

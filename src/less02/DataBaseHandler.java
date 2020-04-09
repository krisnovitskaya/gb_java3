package less02;
import java.sql.*;

public class DataBaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useSSL=false";

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void addUser(String login, String pass, String nickname){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_LOGIN + "," + Const.USER_PASS + "," + Const.USER_NICK + ")" + "VALUES(?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = getDbConnection().prepareStatement(insert);
            stmt.setString(1, login);
            stmt.setString(2, pass);
            stmt.setString(3, nickname);
            stmt.executeUpdate();
            //stmt.close();
            //dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }




}

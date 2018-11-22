
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dejan
 */
public class DbConnection {
    static Connection conn = null;
    static DbConnection db =null;
    private String url = "jdbc:mysql://localhost:3306/movies/user";
    private String user = "root";
    private String password = "";           
    private DbConnection()
    {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConn(){
        if(db == null)
            db = new DbConnection();
        return conn;
    }
}

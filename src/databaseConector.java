import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConector {
    private String urlJDBC;
    private String usuarioDB;
    private String passwordDB;

    public databaseConector(String urlJDBC, String usuarioDB, String passwordDB){
        this.urlJDBC = urlJDBC;
        this.usuarioDB = usuarioDB;
        this.passwordDB = passwordDB;
    }

    public Connection obtenerConexion () throws SQLException {
        return DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);
    }
}

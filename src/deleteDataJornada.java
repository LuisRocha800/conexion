import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteDataJornada {

    public void startDeleteJornadas(settersGettersJornadas jornadasId){

        int jrndsId = jornadasId.getIdJornada();

        String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            deleteDataJornadas(conexion, jrndsId);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void deleteDataJornadas(Connection conexion, int jornadas_id) throws SQLException{

        String sql = "DELETE FROM jornadas WHERE id_jornada = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, jornadas_id);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos borrados correctamente");
            } else {
                System.out.println("No se pudieron borrar los datos");
            }            

        }

    }
    
}

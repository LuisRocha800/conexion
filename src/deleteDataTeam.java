import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteDataTeam {
    
    public void startDeleteTeams(settersGettersEquipos teamId){

        int tmId = teamId.getIdTeam();


            String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            deleteDataTeams(conexion, tmId);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void deleteDataTeams(Connection conexion, int team_id) throws SQLException{

        String sql = "DELETE FROM equipos WHERE id_equipo = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, team_id);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos borrados correctamente");
            } else {
                System.out.println("No se pudieron borrar los datos");
            }            

        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertarDatosJugadorxEquipo {
    
    public void start(settersGettersJugadorXequipo playerId, settersGettersJugadorXequipo teamId){

        int pyrId = playerId.getIdPlayer();
        int tmId = teamId.getIdTeam();

            String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            insertDataPlayersXTeams(conexion, pyrId, tmId);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void insertDataPlayersXTeams(Connection conexion, int player_id, int team_id) throws SQLException{

        String sql = "INSERT INTO jugadores_x_equipo VALUES (?,?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, player_id);
            statement.setInt(2, team_id);


            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("No se pudieron insertar los datos");
            }

            

        }
    }
}

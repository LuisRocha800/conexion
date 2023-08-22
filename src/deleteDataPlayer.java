import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteDataPlayer {
    
    public void startDeletePlayer(settersGettersJugadores playerId){

        int plyerId = playerId.getIdJugador();

    String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            deleteDataPlayers(conexion, plyerId);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void deleteDataPlayers(Connection conexion, int player_id) throws SQLException{

        String sql = "DELETE FROM jugadores WHERE id_jugador = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, player_id);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos borrados correctamente");
            } else {
                System.out.println("No se pudieron borrar los datos");
            }            

        }

    }
}

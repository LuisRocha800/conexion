import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteDataTournament {

    public void startDeleteTournament(settersGettersTorneos idTournament){

        int trnmntId = idTournament.getIdTorneo();

    String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            deleteDataTournaments(conexion, trnmntId);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void deleteDataTournaments(Connection conexion, int tournament_id) throws SQLException{

        String sql = "DELETE FROM torneos WHERE id_torneo = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, tournament_id);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos borrados correctamente");
            } else {
                System.out.println("No se pudieron borrar los datos");
            }            

        }
    }
    
}

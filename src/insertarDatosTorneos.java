import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertarDatosTorneos {
    
    public void startInsertTournament(settersGettersTorneos idTorneo, settersGettersTorneos nombreTorneo){

        int idtournament = idTorneo.getIdTorneo();
        String tournamentName = nombreTorneo.getNombreTorneo();

        String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            insertDataTournaments(conexion, idtournament, tournamentName);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void insertDataTournaments(Connection conexion, int tournament_id, String tournament_name) throws SQLException{

        String sql = "INSERT INTO torneos VALUES (?,?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, tournament_id);
            statement.setString(2, tournament_name);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("No se pudieron insertar los datos");
            }

            

        }

    }
    
}

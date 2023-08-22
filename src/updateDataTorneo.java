import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateDataTorneo {
    
    public void startUpdateTournament(settersGettersTorneos nameTournament, settersGettersTorneos idTournament){

        String nmtrnmnt = nameTournament.getNombreTorneo();
        int idtrnmnt = idTournament.getIdTorneo();

        String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            updateDataTournaments(conexion, nmtrnmnt, idtrnmnt);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void updateDataTournaments(Connection conexion, String name_tournament, int id_tournament) throws SQLException{

        String sql = "UPDATE torneos SET nombre_torneo = ? WHERE id_torneo = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setString(1, name_tournament);
            statement.setInt(2, id_tournament);;

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("No se pudieron insertar los datos");
            }

        }

    }
}

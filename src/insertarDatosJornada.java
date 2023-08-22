import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertarDatosJornada {
   
    public void start(settersGettersJornadas jornadaId, settersGettersJornadas localTeam, settersGettersJornadas visitorTeam, settersGettersJornadas matchDate, settersGettersJornadas matchTime ){

        int jrndId = jornadaId.getIdJornada();
        int lcltm = localTeam.getIdTeamLocal();
        int vstrtm = visitorTeam.getIdTeamVisitor();
        String mtchdte = matchDate.getDateMatch();
        String mtchTme = matchTime.getTimeMatch();

            String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            insertDataJornadas(conexion, jrndId, lcltm, vstrtm, mtchdte, mtchTme);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void insertDataJornadas(Connection conexion, int jornada_id, int local_team, int visitor_team, String match_date, String match_time) throws SQLException{

        String sql = "INSERT INTO jornadas VALUES (?,?,?,?,?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, jornada_id);
            statement.setInt(2, local_team);
            statement.setInt(3, visitor_team);
            statement.setString(4, match_date);
            statement.setString(5, match_time);


            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("No se pudieron insertar los datos");
            }

            

        }
    }
}

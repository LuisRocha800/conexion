import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateDataJornada {
    
    public void startUpdateJornada(settersGettersJornadas localTeam, settersGettersJornadas visitorTeam, settersGettersJornadas matchDate, settersGettersJornadas matchTime, settersGettersJornadas jornadaId){

        int lcltm = localTeam.getIdTeamLocal();
        int vstrtm = visitorTeam.getIdTeamVisitor();
        String mtchdte = matchDate.getDateMatch();
        String mtchtme = matchTime.getTimeMatch();
        int jrndid = jornadaId.getIdJornada();

        String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            updateDataJornadas(conexion, lcltm, vstrtm, mtchdte, mtchtme, jrndid);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void updateDataJornadas(Connection conexion, int local_team, int visitor_team, String match_date, String match_time, int jornada_id) throws SQLException{

        String sql = "UPDATE jornadas SET equipo_local = ? , equipo_visitante = ?, fecha = ?, hora = ? WHERE id_jornada = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, local_team);
            statement.setInt(2, visitor_team);
            statement.setString(3, match_date);
            statement.setString(4, match_time);
            statement.setInt(5, jornada_id);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("No se pudieron insertar los datos");
            }


        }

    }
}

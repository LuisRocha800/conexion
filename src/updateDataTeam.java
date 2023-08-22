import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateDataTeam {
    
    public void startUpdateTeam(settersGettersEquipos nameTeam, settersGettersEquipos groupId, settersGettersEquipos teamId){

        String  nmeTm = nameTeam.getNameTeam();
        int grpId = groupId.getIdGroup();
        int tmid = teamId.getIdTeam();

        String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            updateDataTeams(conexion, nmeTm, grpId, tmid);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void updateDataTeams(Connection conexion, String name_team, int group_id, int team_id) throws SQLException{

        String sql = "UPDATE equipos SET nombre_equipo = ? , id_grupo = ? WHERE id_equipo = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setString(1, name_team);
            statement.setInt(2, group_id);
            statement.setInt(3, team_id);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("No se pudieron insertar los datos");
            }


        }
    }
}

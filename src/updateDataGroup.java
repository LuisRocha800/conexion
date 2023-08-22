import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateDataGroup {
    
    public void startUpdateGroup(settersGettersGrupos nameGroup, settersGettersGrupos tournamentId, settersGettersGrupos groupId){

        String nmegrp = nameGroup.getGroupName();
        int trnmntid = tournamentId.getTournamentId();
        int grpid = groupId.getGroupId();

        String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            updateDataGroups(conexion, nmegrp, trnmntid, grpid);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void updateDataGroups(Connection conexion, String name_group, int tournament_id, int group_id) throws SQLException{

        String sql = "UPDATE grupos SET nombre_grupo = ? , id_torneo = ? WHERE id_torneo = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setString(1, name_group);
            statement.setInt(2, tournament_id);
            statement.setInt(3, group_id);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("No se pudieron insertar los datos");
            }


        }

    }
}

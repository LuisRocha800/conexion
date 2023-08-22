import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertarDatosGrupo {
    
    public void startInsertGroup(settersGettersGrupos groupId, settersGettersGrupos groupName, settersGettersGrupos tournamentId){

        int grpId = groupId.getGroupId();
        String grpNme = groupName.getGroupName();
        int grpTrnmt = tournamentId.getTournamentId();

        String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            insertDataGroups(conexion, grpId, grpNme, grpTrnmt);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void insertDataGroups(Connection conexion, int group_id, String group_name, int tournament_id) throws SQLException{

        String sql = "INSERT INTO grupos VALUES (?,?,?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, group_id);
            statement.setString(2, group_name);
            statement.setInt(3, tournament_id);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("No se pudieron insertar los datos");
            }

            

        }
    }
}

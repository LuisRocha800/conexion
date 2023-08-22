import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteDataGroup {

    public void startDeleteGroups(settersGettersGrupos groupId){

        int dlteGrp = groupId.getGroupId();

            String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            deleteDataPlayers(conexion, dlteGrp);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void deleteDataPlayers(Connection conexion, int group_id) throws SQLException{

        String sql = "DELETE FROM grupos WHERE id_grupo = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, group_id);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos borrados correctamente");
            } else {
                System.out.println("No se pudieron borrar los datos");
            }            

        }
    }
    
}

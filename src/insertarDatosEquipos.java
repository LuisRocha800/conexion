import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertarDatosEquipos {

    public void startInsertTeam(settersGettersEquipos teamId, settersGettersEquipos teamName, settersGettersEquipos groupTeam){

    int tmId = teamId.getIdTeam();
    String tmNme = teamName.getNameTeam();
    int tmgrp = groupTeam.getIdGroup();

    String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            insertDataTeams(conexion, tmId, tmNme, tmgrp);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void insertDataTeams(Connection conexion, int team_id, String team_name, int group_team) throws SQLException{

        String sql = "INSERT INTO equipos VALUES (?,?,?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, team_id);
            statement.setString(2, team_name);
            statement.setInt(3, group_team);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("No se pudieron insertar los datos");
            }

            

        }

    }
    
}

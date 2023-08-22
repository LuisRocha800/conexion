import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateDataPlayer {

        public void startUpdatePLayers(settersGettersJugadores insertApp1, settersGettersJugadores insertApp2, settersGettersJugadores insertNom, settersGettersJugadores insertAge, settersGettersJugadores insertID){
  
        String app1 = insertApp1.getPrimerApellido();
        String app2 = insertApp2.getSegundoApellido();
        String nom = insertNom.getNombre();
        int age = insertAge.getEdad();
        int id = insertID.getIdJugador(); 

        String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            updateDataPlayers(conexion,app1,app2,nom,age,id);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void updateDataPlayers(Connection conexion, String primer_apellido, String segundo_apellido, String nombre, int edad,  int id_jugador) throws SQLException{

        String sql = "UPDATE jugadores SET primer_apellido = ? , segundo_apellido = ?, nombre = ?, edad = ? \r\n" + //
                     "WHERE id_jugador = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setString(1, primer_apellido);
            statement.setString(2, segundo_apellido);
            statement.setString(3, nombre);
            statement.setInt(4, edad);
            statement.setInt(5, id_jugador);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("No se pudieron insertar los datos");
            }


        }
}

}

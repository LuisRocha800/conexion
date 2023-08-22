import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertarDatosJugadores {



    public void iniciar(settersGettersJugadores insertID, settersGettersJugadores insertApp1, settersGettersJugadores insertApp2, settersGettersJugadores insertNom, settersGettersJugadores insertAge){

        int id = insertID.getIdJugador();   
        String app1 = insertApp1.getPrimerApellido();
        String app2 = insertApp2.getSegundoApellido();
        String nom = insertNom.getNombre();
        int age = insertAge.getEdad();

        String urlJDBC = "jdbc:postgresql://localhost:5432/torneosdatabase";
        String usuarioDB = "postgres";
        String passwordDB = "1234";

        try{

            Connection conexion = DriverManager.getConnection(urlJDBC, usuarioDB, passwordDB);

            insertarDataJugadores(conexion,id,app1,app2,nom,age);

        } catch (SQLException ex){
           System.out.println("ERROR: "+ ex.getMessage()); 
        }


    }

    public static void insertarDataJugadores(Connection conexion, int id_jugador, String primer_apellido, String segundo_apellido, String nombre, int edad) throws SQLException{

        String sql = "INSERT INTO jugadores VALUES (?,?,?,?,?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)){

            statement.setInt(1, id_jugador);
            statement.setString(2, primer_apellido);
            statement.setString(3, segundo_apellido);
            statement.setString(4, nombre);
            statement.setInt(5, edad);

            int filas = statement.executeUpdate();

            if(filas > 0){
                System.out.println("Datos insertados correctamente");
            } else {
                System.out.println("No se pudieron insertar los datos");
            }


        }

    }
    
}

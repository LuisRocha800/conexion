public class ejemplo {
    
    public static void main(String[] args){

        int torneoId = 5678;
        String nombreTorneo = "Champions League";
        int grupoId = 67970;
        String nombreGrupo = "A";
        int equipoId = 69795;
        String equipoNombre = "FC Barcelona";

        /*String nombre = "Julian Manuel";
        String primApellido = "Rosas"; 
        String secApellido = "Silva";
        int edad = 30;
        int id = 1234;


        settersGettersJugadores jgdor = new settersGettersJugadores();
        jgdor.setNombre(nombre);
        jgdor.setPrimerApellido(primApellido);
        jgdor.setSegundoApellido(secApellido);
        jgdor.setEdad(edad);
        jgdor.setIdJugador(id);

        updateDataPlayer updtPlyr = new updateDataPlayer();
        updtPlyr.startUpdatePLayers(jgdor, jgdor, jgdor, jgdor, jgdor);*/



        settersGettersTorneos torneo = new settersGettersTorneos();
        torneo.setIdTorneo(torneoId);
        torneo.setNombreTorneo(nombreTorneo);

        settersGettersGrupos grupos = new settersGettersGrupos();
        grupos.setGroupId(grupoId);
        grupos.setGroupName(nombreGrupo);
        grupos.setTournamentId(torneoId);

        settersGettersEquipos equipos = new settersGettersEquipos();
        equipos.setIdTeam(equipoId);
        equipos.setNameTeam(equipoNombre);
        equipos.setIdGroup(grupoId);


        insertarDatosTorneos insertTorneo = new insertarDatosTorneos();
        insertTorneo.startInsertTournament(torneo, torneo);

        insertarDatosGrupo insertGrupo = new insertarDatosGrupo();
        insertGrupo.startInsertGroup(grupos, grupos, grupos);

        insertarDatosEquipos insertEquipo = new insertarDatosEquipos();
        insertEquipo.startInsertTeam(equipos, equipos, equipos);

       // settersGettersJugadores jugador = new settersGettersJugadores();
       // jugador.setIdJugador(idJugador);

       // deleteDataPlayer dlte = new deleteDataPlayer();
       // dlte.startDeletePlayer(jugador); 

    }
}

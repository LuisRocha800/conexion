public class ejemplo {
    
    public static void main(String[] args){

        int id = 1234;
        String nombre = "Jose Carlos";
        String primApellido = "Mariano";
        String segunApellido = "Rosas";
        int edad = 37;

        settersGettersJugadores jgdrs = new settersGettersJugadores();
        jgdrs.setPrimerApellido(primApellido);
        jgdrs.setSegundoApellido(segunApellido);
        jgdrs.setNombre(nombre);
        jgdrs.setEdad(edad);
        jgdrs.setIdJugador(id);


        updateDataPlayer updtPlyr = new updateDataPlayer();
        updtPlyr.startUpdatePLayers(jgdrs, jgdrs, jgdrs, jgdrs, jgdrs);




        /*int torneoId = 56655445;
        String nombreTorneo = "Champions League";
        int grupoId = 53459655;
        String nombreGrupo = "A";
        int equipoId = 345667675;
        String equipoNombre = "Manchester City";

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
        insertEquipo.startInsertTeam(equipos, equipos, equipos);*/

       // settersGettersJugadores jugador = new settersGettersJugadores();
       // jugador.setIdJugador(idJugador);

       // deleteDataPlayer dlte = new deleteDataPlayer();
       // dlte.startDeletePlayer(jugador);

    }
}

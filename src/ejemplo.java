public class ejemplo {
    
    public static void main(String[] args){

        int torneoId = 45605;
        String nombreTorneo = "Champions League";
        int grupoId = 59665;
        String nombreGrupo = "A";
        int equipoId = 30450;
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
        insertEquipo.startInsertTeam(equipos, equipos, equipos);

       // settersGettersJugadores jugador = new settersGettersJugadores();
       // jugador.setIdJugador(idJugador);

       // deleteDataPlayer dlte = new deleteDataPlayer();
       // dlte.startDeletePlayer(jugador);

    }
}

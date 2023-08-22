public class settersGettersJornadas {

    private int idJornada;
    private int idTeamLocal;
    private int idTeamVisitor;
    private String dateMatch;
    private String timeMatch;

    public int getIdJornada(){
        return idJornada;
    }

    public void setIdJornada(int idJornada){
        this.idJornada = idJornada;
    }

    public int getIdTeamLocal(){
        return idTeamLocal;
    }

    public void setIdTeamLocal(int idTeamLocal){
        this.idTeamLocal = idTeamLocal;
    }

    public int getIdTeamVisitor(){
        return idTeamVisitor;
    }

    public void setIdTeamVisitor(int idTeamVisitor){
        this.idTeamVisitor = idTeamVisitor;
    }

    public String getDateMatch(){
        return dateMatch;
    }

    public void setDateMatch(String dateMatch){
        this.dateMatch = dateMatch;
    }

    public String getTimeMatch(){
        return timeMatch;
    }

    public void setTimeMatch(String timeMatch){
        this.timeMatch = timeMatch;
    }
    
}

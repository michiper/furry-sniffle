package it.stockato.its.myniuko.Calendario;

public class Lezione {

    String idCorso;
    String idModulo;
    String dataGiorno;
    String oreInizio;
    String oreFine;

    public Lezione(String idCorso,String idModulo, String dataGiorno, String oreInizio, String oreFine) {
        this.idCorso = idCorso;
        this.idModulo = idModulo;
        this.dataGiorno = dataGiorno;
        this.oreInizio = oreInizio;
        this.oreFine = oreFine;
    }

    public String getIdCorso() {
        return idCorso;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public String getDataGiorno() {
        return dataGiorno;
    }

    public String getOreInizio() {
        return oreInizio;
    }

    public String getOreFine() {
        return oreFine;
    }
}

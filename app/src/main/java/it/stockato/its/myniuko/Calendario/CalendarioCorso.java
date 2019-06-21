package it.stockato.its.myniuko.Calendario;

import java.util.Date;

public class CalendarioCorso{

    String id;
    String idCorso;
    String idModulo;
    String dataGiorno;
    String oreInizio;
    String oreFine;
    String autla;
    String ore;
    String statoGiorno;


    public CalendarioCorso(String id, String idCorso, String idModulo, String dataGiorno, String oreInizio, String oreFine, String autla, String ore, String statoGiorno) {
        this.id = id;
        this.idCorso = idCorso;
        this.idModulo = idModulo;
        this.dataGiorno = dataGiorno;
        this.oreInizio = oreInizio;
        this.oreFine = oreFine;
        this.autla = autla;
        this.ore = ore;
        this.statoGiorno = statoGiorno;
    }


    public String getId() {
        return id;
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

    public String getAutla() {
        return autla;
    }

    public String getOre() {
        return ore;
    }

    public String getStatoGiorno() {
        return statoGiorno;
    }
}

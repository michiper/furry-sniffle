package it.stockato.its.myniuko.Calendario;

import java.util.Date;

public class CalendarioCorso{

    //chiamata al usercALENDAR passandogli l'id utente E POi al prof passandogli l'id del modulo

    String id;
    String idCorso;
    String idModulo;
    String dataGiorno;
    String oreInizio;
    String oreFine;
    String autla;
    String ore;
    String statoGiorno;
    String codiceCorso;
    String titoloCorso;
    String descrizioneCorso;
    String totOreCorso;
    String QRCorso;
    String oreMin;
    String dataInizioAtt;
    String dataFineAtt;
    String statoCorso;
    String nomeAule;

    public CalendarioCorso(String id, String idCorso, String idModulo, String dataGiorno, String oreInizio, String oreFine, String autla, String ore, String statoGiorno, String codiceCorso, String titoloCorso, String descrizioneCorso, String totOreCorso, String QRCorso, String oreMin, String dataInizioAtt, String dataFineAtt, String statoCorso, String nomeAule) {
        this.id = id;
        this.idCorso = idCorso;
        this.idModulo = idModulo;
        this.dataGiorno = dataGiorno;
        this.oreInizio = oreInizio;
        this.oreFine = oreFine;
        this.autla = autla;
        this.ore = ore;
        this.statoGiorno = statoGiorno;
        this.codiceCorso = codiceCorso;
        this.titoloCorso = titoloCorso;
        this.descrizioneCorso = descrizioneCorso;
        this.totOreCorso = totOreCorso;
        this.QRCorso = QRCorso;
        this.oreMin = oreMin;
        this.dataInizioAtt = dataInizioAtt;
        this.dataFineAtt = dataFineAtt;
        this.statoCorso = statoCorso;
        this.nomeAule = nomeAule;
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

    public String getCodiceCorso() {
        return codiceCorso;
    }

    public String getTitoloCorso() {
        return titoloCorso;
    }

    public String getDescrizioneCorso() {
        return descrizioneCorso;
    }

    public String getTotOreCorso() {
        return totOreCorso;
    }

    public String getQRCorso() {
        return QRCorso;
    }

    public String getOreMin() {
        return oreMin;
    }

    public String getDataInizioAtt() {
        return dataInizioAtt;
    }

    public String getDataFineAtt() {
        return dataFineAtt;
    }

    public String getStatoCorso() {
        return statoCorso;
    }

    public String getNomeAule() {
        return nomeAule;
    }
}

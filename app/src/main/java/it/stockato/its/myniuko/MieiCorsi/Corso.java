package it.stockato.its.myniuko.MieiCorsi;

import java.util.Date;

public class Corso {

    //[{"ID":"","IDUtente":"","IDCorso":"","CodiceCorso":"","TitoloCorso":"","DescrizioneCorso":"","TotOreCorso":"","QRCorso":"","OreMin":"600","DataInizioAtt":"","DataFineAtt":"","StatoCorso":"1"}]
    String ID;
    String IDUtente;
    String idCorso;
    String codiceCorso;
    String titoloCorso;
    String descrizioneCorso;
    String totOreCorso;
    String QRcorso;
    String oreMin;
    String dataInizioAtt;
    String dataFineAtt;
    String statoCorso;

    public Corso(String ID, String IDUtente, String idCorso, String codiceCorso, String titoloCorso, String descrizioneCorso, String totOreCorso, String QRcorso, String oreMin, String dataInizioAtt, String dataFineAtt, String statoCorso) {
        this.ID = ID;
        this.IDUtente = IDUtente;
        this.idCorso = idCorso;
        this.codiceCorso = codiceCorso;
        this.titoloCorso = titoloCorso;
        this.descrizioneCorso = descrizioneCorso;
        this.totOreCorso = totOreCorso;
        this.QRcorso = QRcorso;
        this.oreMin = oreMin;
        this.dataInizioAtt = dataInizioAtt;
        this.dataFineAtt = dataFineAtt;
        this.statoCorso = statoCorso;
    }

    public String getID() {
        return ID;
    }

    public String getIDUtente() {
        return IDUtente;
    }

    public String getIdCorso() {
        return idCorso;
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

    public String getQRcorso() {
        return QRcorso;
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
}

package it.stockato.its.myniuko.Calendario;

public class ModuloCorso {

    String id,CodiceCorso,TitoloCorso,DescrizioneCorso,TotOreCorso,QRCorso;
    String oreMin, dataInizioAtt, dataFineAtt, StatoCorso, CodiceModulo;
    String TitoloModulo, DescrizioneModulo, TotOreModulo, IDCorso;


    public ModuloCorso(String id, String codiceCorso, String titoloCorso, String descrizioneCorso, String totOreCorso, String QRCorso, String oreMin, String dataInizioAtt, String dataFineAtt, String statoCorso, String codiceModulo, String titoloModulo, String descrizioneModulo, String totOreModulo, String IDCorso) {
        this.id = id;
        CodiceCorso = codiceCorso;
        TitoloCorso = titoloCorso;
        DescrizioneCorso = descrizioneCorso;
        TotOreCorso = totOreCorso;
        this.QRCorso = QRCorso;
        this.oreMin = oreMin;
        this.dataInizioAtt = dataInizioAtt;
        this.dataFineAtt = dataFineAtt;
        StatoCorso = statoCorso;
        CodiceModulo = codiceModulo;
        TitoloModulo = titoloModulo;
        DescrizioneModulo = descrizioneModulo;
        TotOreModulo = totOreModulo;
        this.IDCorso = IDCorso;
    }

    public String getId() {
        return id;
    }

    public String getCodiceCorso() {
        return CodiceCorso;
    }

    public String getTitoloCorso() {
        return TitoloCorso;
    }

    public String getDescrizioneCorso() {
        return DescrizioneCorso;
    }

    public String getTotOreCorso() {
        return TotOreCorso;
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
        return StatoCorso;
    }

    public String getCodiceModulo() {
        return CodiceModulo;
    }

    public String getTitoloModulo() {
        return TitoloModulo;
    }

    public String getDescrizioneModulo() {
        return DescrizioneModulo;
    }

    public String getTotOreModulo() {
        return TotOreModulo;
    }

    public String getIDCorso() {
        return IDCorso;
    }
}

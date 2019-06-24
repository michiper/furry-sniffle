package it.stockato.its.myniuko.Calendario;

public class Modulo {

    String id,CodiceModulo,TitoloModulo,DescrizioneModulo,TotOreModulo,IDCorso;


    public Modulo(String id, String codiceModulo, String titoloModulo, String descrizioneModulo, String totOreModulo, String IDCorso) {
        this.id = id;
        CodiceModulo = codiceModulo;
        TitoloModulo = titoloModulo;
        DescrizioneModulo = descrizioneModulo;
        TotOreModulo = totOreModulo;
        this.IDCorso = IDCorso;
    }

    public String getId() {
        return id;
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

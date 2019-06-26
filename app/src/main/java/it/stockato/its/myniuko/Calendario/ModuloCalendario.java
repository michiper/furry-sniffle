package it.stockato.its.myniuko.Calendario;

public class ModuloCalendario {

    String id,CodiceModulo,TitoloModulo,DescrizioneModulo,TotOreModulo,IDCorso;
    String ID, IDModulo, DataGiorno, OreInizio, OreFine, Aula, Ore, StatoGiorno;

    public ModuloCalendario(String id, String codiceModulo, String titoloModulo, String descrizioneModulo, String totOreModulo, String IDCorso, String ID, String IDModulo, String dataGiorno, String oreInizio, String oreFine, String aula, String ore, String statoGiorno) {
        this.id = id;
        CodiceModulo = codiceModulo;
        TitoloModulo = titoloModulo;
        DescrizioneModulo = descrizioneModulo;
        TotOreModulo = totOreModulo;
        this.IDCorso = IDCorso;
        this.ID = ID;
        this.IDModulo = IDModulo;
        DataGiorno = dataGiorno;
        OreInizio = oreInizio;
        OreFine = oreFine;
        Aula = aula;
        Ore = ore;
        StatoGiorno = statoGiorno;
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

    public String getID() {
        return ID;
    }

    public String getIDModulo() {
        return IDModulo;
    }

    public String getDataGiorno() {
        return DataGiorno;
    }

    public String getOreInizio() {
        return OreInizio;
    }

    public String getOreFine() {
        return OreFine;
    }

    public String getAula() {
        return Aula;
    }

    public String getOre() {
        return Ore;
    }

    public String getStatoGiorno() {
        return StatoGiorno;
    }
}

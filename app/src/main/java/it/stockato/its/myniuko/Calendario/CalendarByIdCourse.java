package it.stockato.its.myniuko.Calendario;

public class CalendarByIdCourse {

    //{"ID":"1","IDCorso":"1","IDModulo":"2","DataGiorno":"2019-06-12","OreInizio":"9","OreFine":"13","Aula":"1","Ore":"4","StatoGiorno":"1"},
String ID, IDCorso, IDModulo, DataGiorno, OreInizio, OreFine, Aula, Ore, StatoGiorno, titoloModulo;

    public CalendarByIdCourse(String ID, String IDCorso, String IDModulo, String dataGiorno, String oreInizio, String oreFine, String aula, String ore, String statoGiorno, String titoloModulo) {
        this.ID = ID;
        this.IDCorso = IDCorso;
        this.IDModulo = IDModulo;
        DataGiorno = dataGiorno;
        OreInizio = oreInizio;
        OreFine = oreFine;
        Aula = aula;
        Ore = ore;
        StatoGiorno = statoGiorno;
        this.titoloModulo = titoloModulo;
    }

    public void setTitoloModulo(String titoloModulo) {
        this.titoloModulo = titoloModulo;
    }

    public String getTitoloModulo() {
        return titoloModulo;
    }

    public String getID() {
        return ID;
    }

    public String getIDCorso() {
        return IDCorso;
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

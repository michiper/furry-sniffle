package it.stockato.its.myniuko.Calendario;

public class Lezioni {

        String data;
        String mattina;
        String pomeriggio;

        public Lezioni(String data, String mattina, String pomeriggio){
            this.data= data;
            this.mattina=mattina;
            this.pomeriggio = pomeriggio;
        }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMattina() {
        return mattina;
    }

    public void setMattina(String mattina) {
        this.mattina = mattina;
    }

    public String getPomeriggio() {
        return pomeriggio;
    }

    public void setPomeriggio(String pomeriggio) {
        this.pomeriggio = pomeriggio;
    }
}

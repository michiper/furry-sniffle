package it.stockato.its.myniuko.Utente;

public class Utente {

    private String ID;
    private String TipoUtente;
    private String Nome;
    private String Cognome;
    private String Email;
    private String Password;
    private String PasswordCambiata;
    private String CodiceFiscale;
    private String ImmagineProfilo;

    public Utente()
    {
        ID = null;
        TipoUtente = null;
        Nome = null;
        Cognome = null;
        Email = null;
        Password = null;
        PasswordCambiata = null;
        CodiceFiscale = null;
        ImmagineProfilo = null;
    }

    public Utente(String id, String t, String n, String c, String e, String p, String pc, String cf, String img)
    {
        ID = id;
        TipoUtente = t;
        Nome = n;
        Cognome = c;
        Email = e;
        Password = p;
        PasswordCambiata = pc;
        CodiceFiscale = cf;
        ImmagineProfilo = img;
    }

    public String getID(){ return ID; }

    public String getTipoUtente(){ return TipoUtente; }

    public String getNome(){ return Nome; }

    public String getCognome(){ return Cognome; }

    public String getEmail(){ return Email; }

    public String getPassword() { return Password; }

    public String getPasswordCambiata(){ return PasswordCambiata; }

    public String getImmagineProfilo(){ return ImmagineProfilo; }

    public String getCodiceFiscale(){ return CodiceFiscale; }

}

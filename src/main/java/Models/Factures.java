package Models;

public class Factures {
    private String nomclient;
    private String nomentraineur;

    private String service;
    private int id;

    public Factures(String nomclient, String nomentraineur, String service) {
        this.id = id;
        this.nomclient = nomclient;
        this.nomentraineur = nomentraineur;
        this.service = service;
    }

    public String getNomclient() {
        return nomclient;
    }

    public String getNomentraineur() {
        return nomentraineur;
    }

    public String getService() {return service;}

    @Override
    public String toString() {
        return nomclient + " " + nomentraineur + " " + service;
    }

    public int getId() {
        return this.id;
    }
}

package Models;

public class Entrainement {

    private String sport;
    private String entraineurs;

    private String client;

    private int id;

    public Entrainement(int id, String sport, String entraineurs, String client) {
        this.id = id;
        this.sport = sport;
        this.entraineurs = entraineurs;
        this.client = client;

    }
    public String getSport() {
        return sport;
    }

    public String getEntraineurs() {
        return entraineurs;
    }

    @Override
    public String toString() {
        return sport + " " + entraineurs +" "+ client;
    }

    public int getId() {
        return this.id;
    }
}



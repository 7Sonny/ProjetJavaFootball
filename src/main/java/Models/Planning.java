package Models;

import java.sql.Timestamp;

public class Planning {
    private int id;
    private String client;
    private String entraineur;
    private Timestamp dateTime;

    public Planning(int id, String client, String entraineur, Timestamp dateTime) {
        this.id = id;
        this.client = client;
        this.entraineur = entraineur;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public String getEntraineur() {
        return entraineur;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Client: " + client + ", Entraineur: " + entraineur + ", Date/Heure: " + dateTime;
    }
}

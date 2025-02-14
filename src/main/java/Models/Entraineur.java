package Models;

public class Entraineur {
    private String firstname;
    private String name;
    private String adresse;
    private String email;
    private int id;

    public Entraineur(int id, String firstname, String name, String adresse, String email) {
        this.id = id;
        this.firstname = firstname;
        this.adresse = adresse;
        this.email = email;
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return firstname + " " + name;
    }

    public int getId() {
        return this.id;
    }
}

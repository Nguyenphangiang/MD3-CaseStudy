package model;

public class Collab {
    private int id;
    private String collabName;
    private String collabEmail;
    private String collabPassword;

    public Collab(int id, String collabName, String collabEmail, String collabPassword) {
        this.id = id;
        this.collabName = collabName;
        this.collabEmail = collabEmail;
        this.collabPassword = collabPassword;


    }

    public Collab(String collabName, String collabEmail, String collabPassword ) {
        this.collabName = collabName;
        this.collabEmail = collabEmail;
        this.collabPassword = collabPassword;
    }

    public Collab() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollabName() {
        return collabName;
    }

    public void setCollabName(String collabName) {
        this.collabName = collabName;
    }

    public String getCollabEmail() {
        return collabEmail;
    }

    public void setCollabEmail(String collabEmail) {
        this.collabEmail = collabEmail;
    }

    public String getCollabPassword() {
        return collabPassword;
    }

    public void setCollabPassword(String collabPassword) {
        this.collabPassword = collabPassword;
    }

    @Override
    public String toString() {
        return "Collab{" +
                "id=" + id +
                ", collabName='" + collabName + '\'' +
                ", collabEmail='" + collabEmail + '\'' +
                ", collabPassword='" + collabPassword + '\'' +
                '}';
    }
}

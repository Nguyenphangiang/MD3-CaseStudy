package model;

public class Collab {
    private int id;
    private String collabName;
    private String collabEmail;
    private String collabPassword;
//    private String restaurant;

    public Collab(int id, String collabName, String collabEmail, String collabPassword, String restaurant) {
        this.id = id;
        this.collabName = collabName;
        this.collabEmail = collabEmail;
        this.collabPassword = collabPassword;
//        this.restaurant =restaurant;

    }

    public Collab(String collabName, String collabEmail, String collabPassword, Restaurant restaurant) {
        this.collabName = collabName;
        this.collabEmail = collabEmail;
        this.collabPassword = collabPassword;
//        this.restaurant = restaurant;
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

//    public Restaurant getRestaurant() {
//        return restaurant;
//    }

//    public void setRestaurant(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }

    @Override
    public String toString() {
        return "Collab{" +
                "id=" + id +
                ", collabName='" + collabName + '\'' +
                ", collabEmail='" + collabEmail + '\'' +
                ", collabPassword='" + collabPassword + '\'' +
//                ", restaurant=" + restaurant +
                '}';
    }
}

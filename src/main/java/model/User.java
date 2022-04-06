package model;

public class User {
    private int id;
    private String userName;
    private String userPhone;
    private String userAddress;

    public User(int id, String userName, String userPhone, String userAddress) {
        this.id = id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }

    public User(String userName, String userPhone, String userAddress) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}

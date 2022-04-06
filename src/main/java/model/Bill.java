package model;

import java.time.LocalDateTime;

public class Bill {
    private int id;
    private String billCode;
    private LocalDateTime dateTime;
    private User user;

    public Bill(String billCode, LocalDateTime dateTime, User user) {
        this.billCode = billCode;
        this.dateTime = dateTime;
        this.user = user;
    }

    public Bill() {
    }

    public Bill(int id, String billCode, LocalDateTime dateTime, User user) {
        this.id = id;
        this.billCode = billCode;
        this.dateTime = dateTime;
        this.user = user;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", billCode='" + billCode + '\'' +
                ", dateTime=" + dateTime +
                ", user=" + user +
                '}';
    }
}

package model;

public class DiscountCode {
    private int id;
    private String discountCode;
    private int discountPrice;

    public DiscountCode(int id, int discountPrice) {
        this.id = id;
        this.discountPrice = discountPrice;
    }

    public DiscountCode(int id, String discountCode, int discountPrice) {
        this.id = id;
        this.discountCode = discountCode;
        this.discountPrice = discountPrice;
    }

    public DiscountCode(String discountCode, int discountPrice) {
        this.discountCode = discountCode;
        this.discountPrice = discountPrice;
    }

    public DiscountCode() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "DiscountCode{" +
                "id=" + id +
                ", discountCode='" + discountCode + '\'' +
                ", discountPrice=" + discountPrice +
                '}';
    }
}

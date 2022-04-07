package model;

import java.util.List;

public class Tag {
    private int id;
    private String tagName;
    private int viewNumber;
    private int addNumber;
    private List<Dish> dishList;

    public Tag(int id, String tagName) {
        this.id = id;
        this.tagName = tagName;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public Tag(String tagName, int viewNumber, int addNumber, List<Dish> dishList) {
        this.tagName = tagName;
        this.viewNumber = viewNumber;
        this.addNumber = addNumber;
        this.dishList = dishList;
    }

    public Tag(int id, String tagName, int viewNumber, int addNumber, List<Dish> dishList) {
        this.id = id;
        this.tagName = tagName;
        this.viewNumber = viewNumber;
        this.addNumber = addNumber;
        this.dishList = dishList;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }

    public int getAddNumber() {
        return addNumber;
    }

    public void setAddNumber(int addNumber) {
        this.addNumber = addNumber;
    }

    public Tag(int id, String tagName, int viewNumber, int addNumber) {
        this.id = id;
        this.tagName = tagName;
        this.viewNumber = viewNumber;
        this.addNumber = addNumber;
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Tag() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}

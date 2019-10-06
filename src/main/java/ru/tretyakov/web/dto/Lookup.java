package ru.tretyakov.web.dto;

/**
 * @author A.Tretyakov.
 * @since 05.10.19
 */
public class Lookup {

    private int box;
    private String color;

    public Lookup() {
    }

    public Lookup(int box, String color) {
        this.box = box;
        this.color = color;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

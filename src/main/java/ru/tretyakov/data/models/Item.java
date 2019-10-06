package ru.tretyakov.data.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

/**
 * @author A.Tretyakov.
 * @since 04.10.19
 */
@Entity
@Table(name = "Item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item extends Element {

    @XmlAttribute
    private String color;

    public Item() {
    }

    public Item(String color) {
        this.color = color;
    }

    public Item(int id, int contained_in, String color) {
        super(id, contained_in);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        if (!super.equals(o)) return false;
        Item item = (Item) o;
        return Objects.equals(color, item.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}

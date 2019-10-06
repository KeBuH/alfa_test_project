package ru.tretyakov.data.models;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;

/**
 * @author A.Tretyakov.
 * @since 04.10.19
 */
@Entity
@Table(name = "Box")
@XmlAccessorType(XmlAccessType.FIELD)
public class Box extends Element {

    @OneToMany(mappedBy = "contained_in", cascade = CascadeType.ALL)
    @XmlElement(name = "Box")
    private List<Box> box;
    @OneToMany(mappedBy = "contained_in", cascade = CascadeType.ALL)
    @XmlElement(name = "Item")
    private List<Item> item;

    public Box() {
    }

    public Box(List<Box> box, List<Item> item) {
        this.box = box;
        this.item = item;
    }

    public Box(int id, int contained_in, List<Box> box, List<Item> item) {
        super(id, contained_in);
        this.box = box;
        this.item = item;
    }

    public List<Box> getBox() {
        return box;
    }

    public void setBox(List<Box> box) {
        this.box = box;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        if (!super.equals(o)) return false;
        Box box1 = (Box) o;
        return Objects.equals(box, box1.box) &&
                Objects.equals(item, box1.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), box, item);
    }
}


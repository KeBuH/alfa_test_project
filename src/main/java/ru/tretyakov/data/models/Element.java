package ru.tretyakov.data.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

/**
 * @author A.Tretyakov.
 * @since 05.10.19
 */
@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Element {

    @Id
    @XmlAttribute
    private int id;
    @Column(name = "CONTAINED_IN")
    private int contained_in;

    public Element() {
    }

    public Element(int id, int contained_in) {
        this.id = id;
        this.contained_in = contained_in;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContained_in() {
        return contained_in;
    }

    public void setContained_in(int contained_in) {
        this.contained_in = contained_in;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return id == element.id &&
                contained_in == element.contained_in;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contained_in);
    }
}

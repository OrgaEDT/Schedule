package amu.licence.edt.model.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="T_GROUP")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column (name="ID_GROUP")
    private int id;

    @Column (name="GROUP_SIZE")
    private int groupSize;

    @ManyToOne
    @JoinColumn (name="ID_PROMO", nullable=false)
    private Promo promo;

    public Group() { }

    public Group(int groupSize, Promo promo) {
        super();
        this.groupSize = groupSize;
        this.promo = promo;
    }

    @Override
    public String toString() {
        return "Group [id=" + id + ", groupSize=" + groupSize + ", promo="
                + promo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + groupSize;
        result = prime * result + ((promo == null) ? 0 : promo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Group other = (Group) obj;
        if (groupSize != other.groupSize) return false;
        if (promo == null) {
            if (other.promo != null) return false;
        } else if (!promo.equals(other.promo)) return false;
        return true;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public int getId() {
        return id;
    }

}

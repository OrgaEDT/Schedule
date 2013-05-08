package amu.licence.edt.model.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="T_GROUP")
@NamedNativeQueries ({
    @NamedNativeQuery (name=Group.IS_AVAILABLE,
                       query="SELECT group_available(?1, ?2, ?3) FROM dual"),
})
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String IS_AVAILABLE = "isGroupAvailable";

    @Id
    @GeneratedValue
    @Column (name="ID_GROUP")
    private int id;

    @Column (name="SIZE_GROUP")
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
                + ((promo != null) ? promo.getId() : null) + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Group other = (Group) obj;
        if (id != other.id)
            return false;
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

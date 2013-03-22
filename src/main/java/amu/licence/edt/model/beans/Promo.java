package amu.licence.edt.model.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="T_PROMO")
public class Promo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column (name="ID_PROMO")
    private int id;

    @Column (name="SIZE_PROMO")
    private int size;

    @OneToOne (mappedBy="promo")
    @JoinColumn (name="ID_LEVEL", nullable=false)
    private Level level;

    @OneToMany (mappedBy="promo")
    private Set<Group> group;

    public Promo() { }

    public Promo(int size, Level level, Set<Group> group) {
        super();
        this.size = size;
        this.level = level;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Promo [id=" + id + ", size=" + size + ", level=" + level
                + ", group=" + group + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((group == null) ? 0 : group.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + size;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Promo other = (Promo) obj;
        if (group == null) {
            if (other.group != null) return false;
        } else if (!group.equals(other.group)) return false;
        if (level == null) {
            if (other.level != null) return false;
        } else if (!level.equals(other.level)) return false;
        if (size != other.size) return false;
        return true;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Set<Group> getGroup() {
        return group;
    }

    public void setGroup(Set<Group> group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

}

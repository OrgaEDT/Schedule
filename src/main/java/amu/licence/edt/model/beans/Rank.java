package amu.licence.edt.model.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="T_RANK")
public class Rank implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)	// TODO mysql only
    @Column (name="ID_RANK")
    private int id;

    @Column (name="LIBEL_RANK", nullable=false, unique=true)
    private String libel;

    public Rank() { }

    public Rank(String libel) {
        super();
        this.libel = libel;
    }

    @Override
    public String toString() {
        return "Rank [id=" + id + ", libel=" + libel + "]";
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
        Rank other = (Rank) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public String getLibel() {
        return libel;
    }

    public void setLibel(String libel) {
        this.libel = libel;
    }

    public int getId() {
        return id;
    }

}

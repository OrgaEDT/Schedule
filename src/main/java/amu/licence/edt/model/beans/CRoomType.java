package amu.licence.edt.model.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="T_CROOM_TYPE")
public class CRoomType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column (name="ID_CROOM_TYPE")
    private int id;

    @Column (name="LIBEL_CROOM_TYPE", nullable=false, unique=true)
    private String libel;

    @ManyToMany (fetch=FetchType.LAZY)
    @JoinTable (name="T_SESSION_CROOM_COMPATIBILITY",
                joinColumns={@JoinColumn(name="ID_CROOM_TYPE")},
                inverseJoinColumns={@JoinColumn(name="ID_SESSION_TYPE")})
    private Set<SessionType> compatibleSessionTypes;

    public CRoomType() { }

    public CRoomType(String libel, Set<SessionType> compatibleSessionTypes) {
        super();
        this.libel = libel;
        this.compatibleSessionTypes = compatibleSessionTypes;
    }

    @Override
    public String toString() {
        return "CRoomType [id=" + id + ", libel=" + libel
                + ", compatibleSessionTypes=" + compatibleSessionTypes + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((compatibleSessionTypes == null) ? 0
                        : compatibleSessionTypes.hashCode());
        result = prime * result + ((libel == null) ? 0 : libel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        CRoomType other = (CRoomType) obj;
        if (compatibleSessionTypes == null) {
            if (other.compatibleSessionTypes != null) return false;
        } else if (!compatibleSessionTypes.equals(other.compatibleSessionTypes)) return false;
        if (libel == null) {
            if (other.libel != null) return false;
        } else if (!libel.equals(other.libel)) return false;
        return true;
    }

    public String getLibel() {
        return libel;
    }

    public void setLibel(String libel) {
        this.libel = libel;
    }

    public Set<SessionType> getCompatibleSessionTypes() {
        return compatibleSessionTypes;
    }

    public void setCompatibleSessionTypes(Set<SessionType> compatibleSessionTypes) {
        this.compatibleSessionTypes = compatibleSessionTypes;
    }

    public int getId() {
        return id;
    }

}

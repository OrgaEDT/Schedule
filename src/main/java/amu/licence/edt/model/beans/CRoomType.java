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
        return "CRoomType [id=" + id + ", libel=" + libel + "]";
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
        CRoomType other = (CRoomType) obj;
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

    public Set<SessionType> getCompatibleSessionTypes() {
        return compatibleSessionTypes;
    }

    public boolean addCompatibleSessionType(SessionType sessionType) {
        return this.compatibleSessionTypes.add(sessionType);
    }

    public boolean removeCompatibleSessionType(SessionType sessionType) {
        return this.compatibleSessionTypes.remove(sessionType);
    }

    public int getId() {
        return id;
    }

}

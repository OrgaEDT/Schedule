package amu.licence.edt.model.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="T_SESSION_TYPE")
public class SessionType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column (name="ID_SESSION_TYPE")
    private int id;

    @Column (name="LIBEL_SESSION_TYPE")
    private String libel;

    @Column (name="TUTOR_WORTH_COEF")
    private double tutorWorthCoef;

    @ManyToMany (fetch=FetchType.LAZY, mappedBy="compatibleSessionTypes")
    private Set<CRoomType> compatibleCRoomTypes;

    public SessionType() { }

    public SessionType(String libel, double tutorWorthCoef,
            Set<CRoomType> compatibleCRoomTypes) {
        super();
        this.libel = libel;
        this.tutorWorthCoef = tutorWorthCoef;
        this.compatibleCRoomTypes = compatibleCRoomTypes;
    }

    @Override
    public String toString() {
        return "SessionType [id=" + id + ", libel=" + libel
                + ", tutorWorthCoef=" + tutorWorthCoef
                + ", compatibleCRoomTypes=" + compatibleCRoomTypes + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((compatibleCRoomTypes == null) ? 0
                        : compatibleCRoomTypes.hashCode());
        result = prime * result + ((libel == null) ? 0 : libel.hashCode());
        long temp;
        temp = Double.doubleToLongBits(tutorWorthCoef);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SessionType other = (SessionType) obj;
        if (compatibleCRoomTypes == null) {
            if (other.compatibleCRoomTypes != null) return false;
        } else if (!compatibleCRoomTypes.equals(other.compatibleCRoomTypes)) return false;
        if (libel == null) {
            if (other.libel != null) return false;
        } else if (!libel.equals(other.libel)) return false;
        if (Double.doubleToLongBits(tutorWorthCoef) != Double.doubleToLongBits(other.tutorWorthCoef)) return false;
        return true;
    }

    public String getLibel() {
        return libel;
    }

    public void setLibel(String libel) {
        this.libel = libel;
    }

    public double getTutorWorthCoef() {
        return tutorWorthCoef;
    }

    public void setTutorWorthCoef(double tutorWorthCoef) {
        this.tutorWorthCoef = tutorWorthCoef;
    }

    public Set<CRoomType> getCompatibleCRoomTypes() {
        return compatibleCRoomTypes;
    }

    public void setCompatibleCRoomTypes(Set<CRoomType> compatibleCRoomTypes) {
        this.compatibleCRoomTypes = compatibleCRoomTypes;
    }

    public int getId() {
        return id;
    }

}

package amu.licence.edt.model.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="T_LEVEL")
public class Level implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column (name="ID_LEVEL")
    private int id;

    @Column (name="CODE_LEVEL", nullable=false, unique=true)
    private String code;

    @Column (name="LIBEL_LEVEL")
    private String libel;

    @OneToOne
    @JoinColumn (name="ID_PROMO", nullable=false)
    private Promo promo;

    public Level() { }

    public Level(String code, String libel, Promo promo) {
        super();
        this.code = code;
        this.libel = libel;
        this.promo = promo;
    }

    @Override
    public String toString() {
        return "Level [id=" + id + ", code=" + code + ", libel=" + libel
                + ", promo=" + promo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((libel == null) ? 0 : libel.hashCode());
        result = prime * result + ((promo == null) ? 0 : promo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Level other = (Level) obj;
        if (code == null) {
            if (other.code != null) return false;
        } else if (!code.equals(other.code)) return false;
        if (libel == null) {
            if (other.libel != null) return false;
        } else if (!libel.equals(other.libel)) return false;
        if (promo == null) {
            if (other.promo != null) return false;
        } else if (!promo.equals(other.promo)) return false;
        return true;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibel() {
        return libel;
    }

    public void setLibel(String libel) {
        this.libel = libel;
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

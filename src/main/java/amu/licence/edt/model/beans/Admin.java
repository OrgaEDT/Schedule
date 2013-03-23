package amu.licence.edt.model.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="T_ADMIN")
@Inheritance (strategy=InheritanceType.JOINED)
@DiscriminatorColumn (name="ADMIN_STATUS")
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column (name="ID_ADMIN")
    private int id;

    @Column (nullable=false)
    private String login;

    @Column (nullable=false)
    private String pw;

    @Column (name="IS_TEACHER_ADMIN", nullable=false)
    private boolean isTeacherAdmin;

    @ManyToMany
    @JoinTable (name="T_LEVEL_ADMIN",
                joinColumns={@JoinColumn(name="ID_ADMIN")},
                inverseJoinColumns={@JoinColumn(name="ID_LEVEL")})
    private Set<Level> levels;

    public Admin() { }

    public Admin(String login, String pw, boolean isTeacherAdmin,
            Set<Level> levels) {
        super();
        this.login = login;
        this.pw = pw;
        this.isTeacherAdmin = isTeacherAdmin;
        this.levels = levels;
    }

    @Override
    public String toString() {
        return "Admin [id=" + id + ", login=" + login + ", pw=" + pw
                + ", isTeacherAdmin=" + isTeacherAdmin + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (isTeacherAdmin ? 1231 : 1237);
        result = prime * result + ((levels == null) ? 0 : levels.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((pw == null) ? 0 : pw.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Admin other = (Admin) obj;
        if (isTeacherAdmin != other.isTeacherAdmin) return false;
        if (levels == null) {
            if (other.levels != null) return false;
        } else if (!levels.equals(other.levels)) return false;
        if (login == null) {
            if (other.login != null) return false;
        } else if (!login.equals(other.login)) return false;
        if (pw == null) {
            if (other.pw != null) return false;
        } else if (!pw.equals(other.pw)) return false;
        return true;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public boolean isTeacherAdmin() {
        return isTeacherAdmin;
    }

    public void setTeacherAdmin(boolean isTeacherAdmin) {
        this.isTeacherAdmin = isTeacherAdmin;
    }

    public Set<Level> getLevels() {
        return levels;
    }

    public boolean addLevel(Level level) {
        return this.levels.add(level);
    }

    public boolean removeLevel(Level level) {
        return this.levels.remove(level);
    }

    public int getId() {
        return id;
    }

}

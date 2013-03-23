package amu.licence.edt.model.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="T_TEACHER")
@DiscriminatorValue (value="T")
public class Teacher extends Admin
                     implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column (name="NAME_TEACHER")
    private String name;

    @Column (name="ATTACHMENT_SITE")
    private String attachmentSite;

    @Column (name="TEL_TEACHER")
    private String tel;

    @Column (name="MAIL_TEACHER")
    private String mail;

    @Column (name="SERVICE_HOURS")
    private int serviceHours;

    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn (name="ID_RANK_TEACHER")
    private Rank rank;

    public Teacher() { }

    public Teacher(String login, String pw, boolean isTeacherAdmin,
            Set<Level> levels, String name, String attachmentSite, String tel,
            String mail, int serviceHours, Rank rank) {
        super(login, pw, isTeacherAdmin, levels);
        this.name = name;
        this.attachmentSite = attachmentSite;
        this.tel = tel;
        this.mail = mail;
        this.serviceHours = serviceHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Teacher [name=" + name + ", attachmentSite=" + attachmentSite
                + ", tel=" + tel + ", mail=" + mail + ", serviceHours="
                + serviceHours + ", rank=" + rank + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((attachmentSite == null) ? 0 : attachmentSite.hashCode());
        result = prime * result + ((mail == null) ? 0 : mail.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + serviceHours;
        result = prime * result + ((tel == null) ? 0 : tel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Teacher other = (Teacher) obj;
        if (attachmentSite == null) {
            if (other.attachmentSite != null) return false;
        } else if (!attachmentSite.equals(other.attachmentSite)) return false;
        if (mail == null) {
            if (other.mail != null) return false;
        } else if (!mail.equals(other.mail)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (rank == null) {
            if (other.rank != null) return false;
        } else if (!rank.equals(other.rank)) return false;
        if (serviceHours != other.serviceHours) return false;
        if (tel == null) {
            if (other.tel != null) return false;
        } else if (!tel.equals(other.tel)) return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttachmentSite() {
        return attachmentSite;
    }

    public void setAttachmentSite(String attachmentSite) {
        this.attachmentSite = attachmentSite;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getServiceHours() {
        return serviceHours;
    }

    public void setServiceHours(int serviceHours) {
        this.serviceHours = serviceHours;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

}

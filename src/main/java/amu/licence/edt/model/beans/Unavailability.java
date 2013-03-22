package amu.licence.edt.model.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table (name="T_UNAVAILABILITY",
		uniqueConstraints={@UniqueConstraint(columnNames={"START_UNAV_DATE", "ID_TEACHER"})})
public class Unavailability implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column (name="ID_UNAVAILABILITY")
    private int id;

    @Column (name="START_UNAV_DATE", nullable=false)
    private Date startDate;

    @ManyToOne
    @JoinColumn (name="ID_TEACHER", nullable=false)
    private Teacher teacher;

    @Column (name="DURATION_UNAV")
    private int duration;

    public Unavailability() { }

	public Unavailability(Date startDate, Teacher teacher, int duration) {
		super();
		this.startDate = startDate;
		this.teacher = teacher;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Unavailability [id=" + id + ", startDate=" + startDate
				+ ", teacher=" + teacher + ", duration=" + duration + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration;
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
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
		Unavailability other = (Unavailability) obj;
		if (duration != other.duration)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

}

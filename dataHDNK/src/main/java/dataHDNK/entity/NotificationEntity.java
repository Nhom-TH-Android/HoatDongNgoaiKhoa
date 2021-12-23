package dataHDNK.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class NotificationEntity extends BaseEntity {

//	@Column(name = "msv")
//	private String msv;

	@Column(name = "content")
	private String content;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private StudentEntity student;

//	public String getMsv() {
//		return msv;
//	}
//
//	public void setMsv(String msv) {
//		this.msv = msv;
//	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

}

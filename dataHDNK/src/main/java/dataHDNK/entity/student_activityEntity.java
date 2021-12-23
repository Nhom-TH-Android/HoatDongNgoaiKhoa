package dataHDNK.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_activity")
public class student_activityEntity extends BaseEntity {

//	@Column(name = "msv")
//	private String msv;
//	
//	@Column(name = "code")
//	private String code;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private StudentEntity student;

	@ManyToOne
	@JoinColumn(name = "activity_id")
	private ActivityEntity activity;

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public ActivityEntity getActivity() {
		return activity;
	}

	public void setActivity(ActivityEntity activity) {
		this.activity = activity;
	}

//	public String getMsv() {
//		return msv;
//	}
//
//	public void setMsv(String msv) {
//		this.msv = msv;
//	}
//
//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}

}

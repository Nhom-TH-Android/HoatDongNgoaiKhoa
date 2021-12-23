package dataHDNK.dto;

public class student_activityDTO extends BaseDTO {
	private String msv;
	private String code;
	private Long student_id;
	private Long activity_id;

	public String getMsv() {
		return msv;
	}

	public void setMsv(String msv) {
		this.msv = msv;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public Long getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(Long activity_id) {
		this.activity_id = activity_id;
	}
}

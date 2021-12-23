package dataHDNK.dto;

public class NotificationDTO extends BaseDTO{
//	private String msv;
	private String content;
	private String student_id;

//	public String getMsv() {
//		return msv;
//	}
//
//	public void setMsv(String msv) {
//		this.msv = msv;
//	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

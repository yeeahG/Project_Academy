package model.dto;

public class Teacher {
	//강사
	private int teacherNo; //강사번호
	private String name;
	private String contactInformation;
	private String email;
	private String major;
	private int career;
	
	public Teacher() {
		super();
	}

	public Teacher(int teacherNo, String name, String contactInformation, String email, String major, int career) {
		super();
		this.teacherNo = teacherNo;
		this.name = name;
		this.contactInformation = contactInformation;
		this.email = email;
		this.major = major;
		this.career = career;
	}

	public int getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" [강사번호 : ");
		builder.append(teacherNo);
		builder.append(", 이름 : ");
		builder.append(name);
		builder.append(", 연락처 : ");
		builder.append(contactInformation);
		builder.append(", 이메일 : ");
		builder.append(email);
		builder.append(", 전공 : ");
		builder.append(major);
		builder.append(", 경력 : ");
		builder.append(career);
		builder.append("]");
		return builder.toString();
	}

}

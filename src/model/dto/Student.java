package model.dto;

public class Student {
	
	//학생번호
	private int studentNo;
	
	//수강생
	private String name;
	
	//연락처
	private String contactInformation;
	
	//수강하고 있는 강의
	private String lectureName;
	
	//등록날짜
	private String regDate;
	
	public Student() {
		super();
	}

	public Student(int studentNo, String name, String contactInformation, String lectureName, String regDate) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.contactInformation = contactInformation;
		this.lectureName = lectureName;
		this.regDate = regDate;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public int getStudentNo() {
		return studentNo;
	}

	public String getName() {
		return name;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" [학생번호 : ");
		builder.append(studentNo);
		builder.append(", 이름 : ");
		builder.append(name);
		builder.append(", 연락처 : ");
		builder.append(contactInformation);
		builder.append(", 수강중인 강의 : ");
		builder.append(lectureName);
		builder.append(", 등록날짜 : ");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
	
}

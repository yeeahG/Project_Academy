package model.dto;

public class LectureInfo {
	private String lectureName;
	private String teacher;
	private String testName;
	private String startDate;
	private String endDate;
	
	public LectureInfo() {
		super();
	}
	
	public LectureInfo(String lectureName, String teacher, String testName, String startDate, String endDate) {
		super();
		this.lectureName = lectureName;
		this.teacher = teacher;
		this.testName = testName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public String getLectureName() {
		return lectureName;
	}



	public String getTeacher() {
		return teacher;
	}


	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" [강의명 : ");
		builder.append(lectureName);
		builder.append(", 강사 : ");
		builder.append(teacher);
		builder.append(", 시험명 : ");
		builder.append(testName);
		builder.append(", 개강일 : ");
		builder.append(startDate);
		builder.append(", 종강일 : ");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}
	

}

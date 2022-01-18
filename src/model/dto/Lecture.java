package model.dto;

public class Lecture {
	
	private String lectureName;
	private Teacher teacher;
	private LectureInfo lectureInformation;
	private Student student;
	
	public Lecture() {
		super();
	}
	
	public Lecture(String lectureName, Teacher teacher, LectureInfo lectureInformation, Student student) {
		super();
		this.lectureName = lectureName;
		this.teacher = teacher;
		this.lectureInformation = lectureInformation;
		this.student = student;
	}
	
	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public LectureInfo getLectureInformation() {
		return lectureInformation;
	}

	public void setLectureInformation(LectureInfo lectureInformation) {
		this.lectureInformation = lectureInformation;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n * 강의이름 : ");
		builder.append(lectureName);
		builder.append("\n * 강사정보 : ");
		builder.append(teacher);
		builder.append("\n * 강의정보 : ");
		builder.append(lectureInformation);
		builder.append("\n * 수강생정보 : ");
		builder.append(student);
		return builder.toString();
	}
	
}

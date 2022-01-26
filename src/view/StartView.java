package view;

import controller.AcademyProjectController;
import model.dto.Lecture;
import model.dto.LectureInfo;
import model.dto.Student;
import model.dto.Teacher;

public class StartView {
	public static void main(String[] args) {
		
		//강사- 번호, 이름, 연락처, 이메일, 전공, 경력
		Teacher teacher1 = new Teacher(1, "김종원", "010-1111-2222", "jongwon@playdata.com", "영어", 5);
		Teacher teacher2 = new Teacher(2, "윤지원", "010-3333-2322", "jiwon@playdata.com", "중국어", 6);
		Teacher teacher3 = new Teacher(3, "김예지", "010-9877-6544", "yeji@playdata.com", "일본어", 3);
		
		//수강생 - 번호, 이름, 연착처, 수업명, 등록날짜
		Student student1 = new Student(1, "김정민", "010-4567-3453", "jlpt N2반", "2022-01-11");
		Student student2 = new Student(2, "조선하", "010-3232-4555", "HSK 5급반", "2021-12-05");
		Student student3 = new Student(3, "이혜지", "010-2342-2525", "flex일본어", "2022-01-02");
		Student student4 = new Student(4, "강찬표", "010-5253-4543", "TOEFL 주5일 고급특강", "2021-11-23");
		Student student5 = new Student(5, "박지민", "010-4333-6567", "한달완성 900점", "2022-01-09");
		Student student6 = new Student(6, "한지수", "010-2222-2344", "HSK 5급반", "2021-10-25");
		Student student7 = new Student(7, "장선형", "010-4235-5667", "TOEFL 주5일 고급특강", "2021-09-30");
		Student student8 = new Student(8, "도재현", "010-1445-0999", "flex일본어", "2022-01-07");
		
		//수업목록 - 강의이름, 강사, 시험이름, 개강날짜, 종강날짜
		LectureInfo information1 = new LectureInfo("한달완성 900점", "김종원", "Toeic", "2022-02-01", "2022-03-01");
		LectureInfo information2 = new LectureInfo("HSK 5급반", "윤지원", "hsk", "2022-02-05", "2022-04-04");
		LectureInfo information3 = new LectureInfo("jlpt N2반", "김예지", "jlpt", "2022-02-10", "2022-04-09");
		LectureInfo information4 = new LectureInfo("TOEFL 주5일 고급특강", "김종원", "toefl", "2022-01-24", "2022-02-28");
		LectureInfo information5 = new LectureInfo("flex일본어", "김예지", "flex", "2022-01-31", "2022-02-20");
		
		//개설된 수업목록
		Lecture toeicTest = new Lecture("01한달완성 900점", teacher1, information1, student5);
		Lecture hskTest = new Lecture("02HSK 5급반", teacher2, information2, student2);
		Lecture jlptN2Test = new Lecture("03jlpt N2반", teacher3, information3, student1);
		Lecture toeflTest = new Lecture("04TOEFL 주5일 고급특강", teacher1, information4, student4);
		Lecture flexTest = new Lecture("05flex일본어", teacher3, information5, student3);
		
		AcademyProjectController controller = AcademyProjectController.getInstance();
		
		System.out.println("----수업 개설----");
		controller.lectureInsert(toeicTest);
		controller.lectureInsert(hskTest);
		controller.lectureInsert(jlptN2Test);
		controller.lectureInsert(toeflTest);
		controller.lectureInsert(flexTest);
		
		
		System.out.println("\n----수강 가능한 수업 목록----");
		controller.getLectureList();
		
		
		//05flex일본어 수업 검색
		System.out.println("\n----05flex일본어 수업 검색----");
		controller.getLecture("05flex일본어");		
		
		//05flex일본어강사 정보 출력
		System.out.println("\n----05flex일본어 강사정보----");
		controller.getLectureTeacher("05flex일본어");		
		
				
		//04TOEFL 주5일 고급특강 수업 검색
		System.out.println("\n----04TOEFL 주5일 고급특강 수업 강의 검색----");
		controller.getLecture("04TOEFL 주5일 고급특강");
		
		
		//04TOEFL 주5일 고급특강 수강생 정보 출력
		System.out.println("\n----04TOEFL 주5일 고급특강 수업 수강생 정보----");
		controller.getLectureStudent("04TOEFL 주5일 고급특강");
		
		
		//04TOEFL 주5일 고급특강 개강날짜 변경
		System.out.println("\n----04TOEFL 주5일 고급특강 개강날짜 변경----");
		controller.lectureDateUpdate(null, "2022-02-01");
		controller.lectureDateUpdate("04TOEFL 주5일 고급특강", null);
		controller.lectureDateUpdate("04TOEFL 주5일 고급특강", "2022-02-01");		

		
		//04TOEFL 주5일 고급특강 강사 정보 변경
		System.out.println("\n---04TOEFL 주5일 고급특강 수업 강사 변경----");
		controller.lectureTeacherUpdate(null, teacher2);
		controller.lectureTeacherUpdate("04TOEFL 주5일 고급특강", null);
		controller.lectureTeacherUpdate("04TOEFL 주5일 고급특강", teacher2);
		
		
		//04TOEFL 주5일 고급특강 수강생 변경
		System.out.println("\n----04TOEFL 주5일 고급특강 수강생 변경----");
		controller.letcutreStudentUpdate("04TOEFL 주5일 고급특강", student7);
		
		
		//04TOEFL 주5일 고급특강 삭제
		System.out.println("\n----04TOEFL 주5일 고급특강 폐강-----");
		controller.lectureDelete("04TOEFL 주5일 고급특강");
		controller.getLecture("04TOEFL 주5일 고급특강");
		controller.lectureDelete(null);
		
		System.out.println("\n---재입력----");
		controller.getLecture("04TOEFL 주5일 고급특강");
		
		
	}

}
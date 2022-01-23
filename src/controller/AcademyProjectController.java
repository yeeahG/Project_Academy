package controller;

import java.util.Optional;

import exception.LectureNameDuplicationException;
import exception.LectureNotFoundException;
import model.dto.Lecture;
import model.dto.Student;
import model.dto.Teacher;
import service.AcademyProjectService;
import view.EndFailView;
import view.EndView;

public class AcademyProjectController {

	private static AcademyProjectController instance = new AcademyProjectController();
	private AcademyProjectService service = AcademyProjectService.getInstance();

	private AcademyProjectController() {
	}

	public static AcademyProjectController getInstance() {
		return instance;
	}

	// 강의 생성
	public void lectureInsert(Lecture lecture) {

		Optional<Object> optLec = Optional.ofNullable(lecture);
		optLec.ifPresent(data -> {
			try {
				service.lectureInsert(lecture);
			} catch (LectureNameDuplicationException e) {
				EndFailView.failView(e.getMessage());
				e.printStackTrace();
			}

		});
		//System.out.println(optLec.orElse("\n* 강의가 없습니다 *"));
	}


	// 모든 강의 정보 출력
	public void getLectureList() {
		EndView.lectureListView(service.getLectureList());
	}

	// 강의 정보 검색
	public void getLecture(String lectureName) {
		try {
			EndView.lectureListView(service.getLecture(lectureName));
		} catch (LectureNotFoundException e) {
			// e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// 수강생 정보 출력
	public void getLectureStudent(String lectureName) {
		try {
			EndView.lectureStudentView(service.getLecture(lectureName));
		} catch (LectureNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// 강사 정보 출력
	public void getLectureTeacher(String lectureName) {
		try {
			EndView.lectureTeacherView(service.getLectureTeacher(lectureName));

		} catch (LectureNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}

	}

	// 개강날짜 변경 및 검색
	public void lectureDateUpdate(String lectureName, String information) {
		
		Optional<Object> optLec = Optional.ofNullable(lectureName);
		Optional<Object> optInfo = Optional.ofNullable(information);

		if (optLec.isPresent()) {// null이면 false
			optInfo.ifPresent(data -> {
				boolean result = service.lectureDateUpdate(lectureName, information);
				// info가 null이 아니면(둘다 null아니면)

				if (result) {
					try {
						EndView.lectureListView(service.getLecture(lectureName)); // select
					} catch (LectureNotFoundException e) {
						EndFailView.failView("* 개강 날짜 변경 후 검색에 실패했습니다 *");
					}
				} else {
					EndFailView.failView("* 존재하지 않는 강의를 수정 시도했습니다 *");
				}

			}); // info가 null이면
			//System.out.println(optInfo.orElse("** 변경하실 날짜를 제대로 입력하세요  **"));
			System.out.println(" -> TOEFL 주5일 고급특강 수업 개강날짜 : " + optInfo.orElse("존재하지 않습니다\n"));

		} else { // lectureName이 null이면
			System.out.println(optLec.orElse("** 변경하실 강의를 제대로 입력하세요 **"));
		}
	}


	// API 강사 정보 변경 및 검색
	public void lectureTeacherUpdate(String lectureName, Teacher teacher) {
		
		Optional<Object> optLec = Optional.ofNullable(lectureName);
		Optional<Object> optTea = Optional.ofNullable(teacher);
		
		if(optLec.isPresent()) {
			optTea.ifPresent(data -> {String information = null;
			boolean result = service.lectureDateUpdate(lectureName, information);
			
			if(result) {
			try {
				EndView.lectureListView(service.getLecture(lectureName));
			} catch (LectureNotFoundException e) {
				EndFailView.failView("개강 날짜 변경 후 검색에 실패했습니다");
			}
			} else {
				EndFailView.failView("존재하지 않는 강의를 수정 시도했습니다");
			}
			});
			System.out.println(optTea.orElse("** 강사 이름을 제대로 입력하세요 **"));
			} else {
				System.out.println(optLec.orElse("** 강의 이름을 제대로 입력하세요 **"));
			}
			
		}
		

	public void letcutreStudentUpdate(String lectureName, Student student) {
		
		Optional<Object> optLecName = Optional.ofNullable(lectureName);
		Optional<Object> optStuUp = Optional.ofNullable(student);
		
		optLecName.ifPresent(data -> {
			boolean result = service.lectureStudentUpdate(lectureName, student);
			
			if (!result) {
				EndFailView.failView("변경하실 수강정보를 제대로 입력하세요");
			} 
			
		});
		
		if (optStuUp.orElse(optStuUp).equals(student)) {
			System.out.println(optStuUp.orElse(student) + " 학생으로 변경되었습니다.");
		} else {
			EndFailView.failView("변경하실 수강생 이름을 제대로 입력하세요");
		}
	}

	
	// 강의 삭제 API
	public void lectureDelete(String lectureName) {

		Optional<Object> optLec = Optional.ofNullable(lectureName);
		
		optLec.ifPresent(data -> {
			boolean result = service.lectureDelete(lectureName);

			if (!result) {
				EndFailView.failView("삭제할 강의가 존재하지 않습니다."); // 다른 값이 입력될 경우 아래 문장 수행됨
			}

		});

		if (optLec.orElse(optLec).equals(lectureName)) {
			System.out.println("[" + optLec.orElse(lectureName) + "]" + " 강의가 삭제되었습니다.");
		} else {
			System.out.println(optLec.orElse("삭제하려는 강의 이름을 입력하세요!"));
		}
	}


}
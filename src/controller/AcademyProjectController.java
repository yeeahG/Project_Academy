package controller;

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
	
	private AcademyProjectController() {}
	public static AcademyProjectController getInstance() {
		return instance;
	}
	
	//강의 개설
	public void lectureInsert(Lecture lecture) {
		if(lecture != null) {
			try {
			service.lectureInsert(lecture);	
			} catch (LectureNameDuplicationException e) {
				e.printStackTrace ();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("저장할 강의 정보가 없습니다");
		}
	}	
	
	//모든 강의 정보 출력
	public void getLectureList() {
		EndView.lectureListView(service.getLectureList());
	}
	
	//강의 정보 검색
	public void getLecture(String lectureName) {
		try {
		EndView.lectureListView(service.getLecture(lectureName));			
		} catch (LectureNotFoundException e) {
			//e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}
	
	//수강생 정보 출력
	public void getLectureStudent(String lectureName) {
		try {
			EndView.lectureStudentView(service.getLecture(lectureName));		
		}catch (LectureNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}
	
	//강사 정보 출력
	public void getLectureTeacher(String lectureName) {
		try {
			EndView.lectureTeacherView(service.getLectureTeacher(lectureName));
			
		}catch (LectureNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
			
	}	
	
	//개강날짜 변경 및 검색
	public void lectureDateUpdate(String lectureName, String information) {
		if(lectureName != null && information != null) {
			boolean result = service.lectureDateUpdate(lectureName, information);
			
			if(result) {
				try {
					EndView.lectureListView(service.getLecture(lectureName));
				} catch (LectureNotFoundException e) {
					e.printStackTrace();
					EndFailView.failView("개강 날짜 변경 후 검색에 실패했습니다");
				}
			} else { 
				EndFailView.failView("존재하지 않는 강의를 수정 시도했습니다");
			}
		} else {
			EndFailView.failView("변경하실 날짜를 제대로 입력하세요");
		}
	}

	//강사 정보 변경 및 검색
	public void lectureTeacherUpdate(String lectureName, Teacher teacher) {
		if(lectureName != null && teacher != null) {
			boolean result = service.lectureTeacherUpdate(lectureName, teacher);
			
			if(result) {
				try {
					EndView.lectureListView(service.getLecture(lectureName));
				} catch (LectureNotFoundException e) {
					e.printStackTrace();
					EndFailView.failView("강사 변경 후 검색에 실패했습니다");
				}
			}else {
				EndFailView.failView("존재하지 않는 강의를 수정 시도했습니다");
			}
		} else {
			EndFailView.failView("변경하실 강사 정보를 제대로 입력하세요");
		}
	}

	//수강생 목록 수정
	public void letcutreStudentUpdate(String lectureName, Student student) {
		if(lectureName != null && student != null) {
			boolean result = service.lectureStudentUpdate(lectureName, student);
			
			if(result) {
				try {
					EndView.lectureListView(service.getLecture(lectureName));
				} catch (LectureNotFoundException e){
					e.printStackTrace();
					EndFailView.failView("수강생 정보 변경 후에 검색에 실패했습니다");
				}
			} else {
				EndFailView.failView("변경하실 수강정보를 제대로 입력하세요");
			}
		} else {
			EndFailView.failView("변경하실 수강생 이름을 제대로 입력하세요");
		}
	}

	//강의 삭제
	public void lectureDelete(String lectureName) {
		if(lectureName != null) {
			boolean result = service.lectureDelete(lectureName);
			
			if(result) {
				EndView.succesView("lectureName" + "강의가 삭제되었습니다.");
			} else {
				EndFailView.failView("삭제할 강의가 없습니다");
			}
		} else {
			EndFailView.failView("삭제하려는 강의 이름을 입력하세요");
		}
	}
	

		
}
	
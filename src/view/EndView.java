package view;

import java.util.ArrayList;

import model.dto.Lecture;

public class EndView {

	// 모든 강의 출력
	public static void lectureListView(ArrayList<Lecture> allLecture) {
		if (allLecture != null) {
			int lectureSize = allLecture.size();

			for (int index = 0; index < lectureSize; index++) {
				if (allLecture.get(index) != null) {
					System.out.println("[개설된 강의 : " + (index + 1) + "] " + allLecture.get(index));
				}
			}
		} else {
			System.out.println("현재 개설된 강의가 없습니다");
		}
	}

	
	// 강의 이름 받아서 출력
	public static void lectureListView(Object lecture) {
		if (lecture != null) {
			System.out.println(lecture);
		} else {
			System.out.println("해당 강의는 존재하지 않습니다");
		}
	}

	
	//수강생 출력
	public static void lectureStudentView(Lecture lecture) {
		if (lecture.getStudent() != null) {
			System.out.println(lecture.getStudent());
		} else {
			System.out.println("해당 강의의 학생은 존재하지 않습니다");
		}
	}
	
	
	
	public static void succesView(String message) {
		System.out.println(message);
	}

	
	public static void lectureTeacherView(Lecture lecture) {
		if (lecture.getTeacher() != null) {
			System.out.println(lecture.getTeacher());
		} else {
			System.out.println("해당 강사가 존재하지 않습니다.");
		}
	}

}

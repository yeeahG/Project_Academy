package view;

import java.util.ArrayList;
import java.util.Optional;

import model.dto.Lecture;

public class EndView {

	
	//모든 강의 출력 API
	public static void lectureListView(ArrayList<Lecture> allLecture) {
		Optional<Object> optLec = Optional.ofNullable(allLecture);
		optLec.ifPresent(data -> {
			allLecture.stream().forEach(project -> System.out.println("\n  개설된 강의  " + project));
			});
	}

	
	//강의이름 받아서 출력 API
	public static void lectureListView(Lecture lecture) {
		//lecture = null;
		Optional<Object> optLeclist = Optional.ofNullable(lecture.getLectureInformation());
		System.out.println(optLeclist.orElse("* 해당 강의는 존재하지 않습니다 *"));
	}
	
	
	public static void lectureStudentView(Lecture lecture) {
		//lecture = null;
		Optional<Object> optStu = Optional.ofNullable(lecture.getStudent());
		System.out.println(optStu.orElse("* 해당 강의의 학생은 존재하지 않습니다 *"));
	}
	
	
	
	public static void lectureTeacherView(Lecture lecture) {
		//lecture=null;
		Optional<Object> optTeacher = Optional.ofNullable(lecture.getTeacher());
		System.out.println(optTeacher.orElse("* 해당 강사가 존재하지 않습니다 *"));
	}

	
	public static void succesView(String message) {
		System.out.println(message);
	}


}
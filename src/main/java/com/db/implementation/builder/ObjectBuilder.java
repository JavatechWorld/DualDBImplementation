package com.db.implementation.builder;

import com.db.implementation.entity1.Student;
import com.db.implementation.entity1.StudentDTO;
import com.db.implementation.entity2.Teacher;
import com.db.implementation.entity2.TeacherDTO;

public class ObjectBuilder {
	
	
	public  static Student createStudentFromStudentDTO(StudentDTO studentDTO) {
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setSchoolName(studentDTO.getSchoolName());
		student.setStandard(studentDTO.getStandard());
		return student;
	}

	
	public static  Teacher createTeacherFromTeacherDTO(TeacherDTO teacherDTO) {
		
		Teacher teacher = new Teacher();
		teacher.setName(teacherDTO.getName());
		teacher.setSubject(teacherDTO.getSubject());
		return teacher;
	}
}

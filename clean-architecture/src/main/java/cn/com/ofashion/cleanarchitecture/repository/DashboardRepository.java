package cn.com.ofashion.cleanarchitecture.repository;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.model.Student;
import cn.com.ofashion.cleanarchitecture.model.Teacher;

public class DashboardRepository {

    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public DashboardRepository(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }


    public Dashboard dashboard(String studentId, String teacherId) throws IOException {
        Student student = this.studentRepository.fetch(studentId);
        Teacher teacher = this.teacherRepository.fetch(teacherId);
        Dashboard dashboard = Dashboard.builder().student(student).teacher(teacher).build();
        return dashboard;
    }
}

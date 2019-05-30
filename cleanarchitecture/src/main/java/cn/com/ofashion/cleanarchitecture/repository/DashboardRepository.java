package cn.com.ofashion.cleanarchitecture.repository;

import java.io.IOException;

import javax.inject.Inject;

import cn.com.ofashion.cleanarchitecture.api.StudentApi;
import cn.com.ofashion.cleanarchitecture.api.TeacherApi;
import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.model.Student;
import cn.com.ofashion.cleanarchitecture.model.Teacher;

public final class DashboardRepository {

    private StudentApi studentApi;
    private TeacherApi teacherApi;

    @Inject
    public DashboardRepository(StudentApi studentApi, TeacherApi teacherApi) {
        this.studentApi = studentApi;
        this.teacherApi = teacherApi;
    }

    public Dashboard dashboard(String studentId, String teacherId) throws IOException {
        Student student = this.studentApi.fetch(studentId).execute().body();
        Teacher teacher = this.teacherApi.fetch(teacherId).execute().body();
        Dashboard dashboard = Dashboard.builder().student(student).teacher(teacher).build();
        return dashboard;
    }
}

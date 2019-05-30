package cn.com.ofashion.cleanarchitecture.repository;

import java.io.IOException;

import javax.inject.Inject;

import cn.com.ofashion.cleanarchitecture.api.StudentApi;
import cn.com.ofashion.cleanarchitecture.model.Student;

public final class StudentRepository {

    private String studentId;
    private StudentApi api;

    @Inject
    public StudentRepository(StudentApi api, String studentId) {
        this.api = api;
        this.studentId = studentId;
    }

    public Student get() throws IOException {
        return api.fetch(this.studentId).execute().body();
    }
}

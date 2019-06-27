package cn.com.ofashion.cleanarchitecture.repository;

import java.io.IOException;

import javax.inject.Inject;

import cn.com.ofashion.cleanarchitecture.api.StudentApi;
import cn.com.ofashion.cleanarchitecture.model.Student;

public class StudentRepository {

    private StudentApi api;

    @Inject
    public StudentRepository(StudentApi api) {
        this.api = api;
    }

    public Student fetch(String studentId) throws IOException {
        return api.fetch(studentId).execute().body();
    }
}

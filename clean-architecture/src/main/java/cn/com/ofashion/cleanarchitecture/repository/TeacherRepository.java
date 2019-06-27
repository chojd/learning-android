package cn.com.ofashion.cleanarchitecture.repository;

import java.io.IOException;

import javax.inject.Inject;

import cn.com.ofashion.cleanarchitecture.api.TeacherApi;
import cn.com.ofashion.cleanarchitecture.model.Teacher;

public class TeacherRepository {

    private TeacherApi api;

    @Inject
    public TeacherRepository(TeacherApi api) {
        this.api = api;
    }

    public Teacher fetch(String teacherId) throws IOException {
        return api.fetch(teacherId).execute().body();
    }
}

package cn.com.ofashion.cleanarchitecture.repository;

import java.io.IOException;
import java.nio.file.Path;

import javax.inject.Inject;

import cn.com.ofashion.cleanarchitecture.api.TeacherApi;
import cn.com.ofashion.cleanarchitecture.model.Teacher;

public final class TeacherRepository {

    private TeacherApi api;
    private String teacherId;

    @Inject
    public TeacherRepository(TeacherApi api, String teacherId) {
        this.api = api;
        this.teacherId = teacherId;
    }

    public Teacher fetch() throws IOException {
        return api.fetch(this.teacherId).execute().body();
    }
}

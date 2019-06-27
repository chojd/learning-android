package cn.com.ofashion.cleanarchitecture.api;

import cn.com.ofashion.cleanarchitecture.model.Teacher;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TeacherApi {
    @GET("{teacher_id}")
    Call<Teacher> fetch(@Path("teacher_id") String id);
}

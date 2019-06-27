package cn.com.ofashion.cleanarchitecture.api;

import cn.com.ofashion.cleanarchitecture.model.Student;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StudentApi {
    @GET("{student_id}")
    Call<Student>fetch(@Path("student_id") String id);
}

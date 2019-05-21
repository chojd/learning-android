package cn.com.ofashion.httpservice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApi {
    @GET("{path}")
    Call<Metadata> getService(@Path("path") String path);
}

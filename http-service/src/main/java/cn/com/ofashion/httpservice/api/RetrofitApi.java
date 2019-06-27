package cn.com.ofashion.httpservice.api;

import java.util.List;

import cn.com.ofashion.httpservice.model.Member;
import cn.com.ofashion.httpservice.model.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApi {
    @GET("{path}")
    Call<Metadata> getService(@Path("path") String path);

    @GET("family")
    Call<List<Member>> getFamily();
}

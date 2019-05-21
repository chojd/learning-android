package cn.com.ofashion.cleanarchitecture.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

interface TestApi {
    @GET("/test")
    Call<Map> getTest();
}

package cn.com.ofashion.cleanarchitecture.api;


import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import retrofit2.Call;
import retrofit2.http.GET;

interface SchoolApi {
    @GET("/dashboard")
    Call<Dashboard> getDashboard();
}

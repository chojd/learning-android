package cn.com.ofashion.cleanarchitecture.http;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

interface HomeApi {
    @GET("/from")
    Call<Map> getFrom();
}

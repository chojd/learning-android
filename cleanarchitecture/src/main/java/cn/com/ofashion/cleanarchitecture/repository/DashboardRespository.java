package cn.com.ofashion.cleanarchitecture.repository;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.api.SchoolApi;
import cn.com.ofashion.cleanarchitecture.di.DaggerHTTPComponent;
import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import retrofit2.Call;
import retrofit2.Retrofit;

public final class DashboardRespository {

    public Dashboard getDashboard(String baseUrl) throws IOException {
        Retrofit mRetrofit = DaggerHTTPComponent.builder().baseUrl(baseUrl).build().retrofit();
        SchoolApi api = mRetrofit.create(SchoolApi.class);
        Call<Dashboard> dashboardCall = api.getDashboard();
        Dashboard dashboard = dashboardCall.execute().body();
        return dashboard;
    }
}

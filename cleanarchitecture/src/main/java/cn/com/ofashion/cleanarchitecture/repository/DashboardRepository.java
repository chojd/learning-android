package cn.com.ofashion.cleanarchitecture.repository;

import java.io.IOException;

import javax.inject.Inject;

import cn.com.ofashion.cleanarchitecture.api.SchoolApi;
import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import retrofit2.Call;

public final class DashboardRepository {

    private SchoolApi schoolApi;

    @Inject
    public DashboardRepository(SchoolApi schoolApi) {
        this.schoolApi = schoolApi;
    }

    public Dashboard getDashboard() throws IOException {
        Call<Dashboard> dashboardCall = this.schoolApi.getDashboard();
        Dashboard dashboard = dashboardCall.execute().body();
        return dashboard;
    }
}

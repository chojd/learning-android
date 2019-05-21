package cn.com.ofashion.cleanarchitecture.usecase;

import java.io.IOException;

import javax.inject.Inject;

import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.repository.DashboardRespository;

public class FetchDashboardUseCase {

    public Dashboard getDashboard(String mBaseUrl) throws IOException {
        Dashboard dashboard = new DashboardRespository().getDashboard(mBaseUrl);
        return dashboard;
    }
}

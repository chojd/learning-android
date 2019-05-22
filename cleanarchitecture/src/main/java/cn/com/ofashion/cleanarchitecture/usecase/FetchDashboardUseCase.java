package cn.com.ofashion.cleanarchitecture.usecase;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.repository.DashboardRespository;
import io.reactivex.Single;

public class FetchDashboardUseCase {

    public Single<Dashboard> getDashboard(String baseUrl) throws IOException {
        Dashboard dashboard = new DashboardRespository().getDashboard(baseUrl);
        return Single.just(dashboard);
    }
}

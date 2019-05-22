package cn.com.ofashion.cleanarchitecture.usecase;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.repository.DashboardRespository;
import io.reactivex.Single;

public class FetchDashboardUseCase {

    public Single<Dashboard> getDashboard(final String baseUrl) throws IOException {
        final DashboardRespository dashboardRespository = new DashboardRespository();
        Single<Dashboard> dashboardSingle = Single.fromCallable(() -> dashboardRespository.getDashboard(baseUrl));
        return dashboardSingle;
    }
}

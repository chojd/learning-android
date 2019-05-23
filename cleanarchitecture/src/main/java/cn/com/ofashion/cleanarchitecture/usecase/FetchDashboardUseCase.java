package cn.com.ofashion.cleanarchitecture.usecase;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.repository.DashboardRepository;
import io.reactivex.Single;

public class FetchDashboardUseCase {

    public Single<Dashboard> getDashboard(final String baseUrl) throws IOException {
        final DashboardRepository dashboardRespository = new DashboardRepository();
        Single<Dashboard> dashboardSingle = Single.fromCallable(() -> dashboardRespository.getDashboard(baseUrl));
        return dashboardSingle;
    }
}

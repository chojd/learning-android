package cn.com.ofashion.cleanarchitecture.usecase;

import javax.inject.Inject;

import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.repository.DashboardRepository;
import io.reactivex.Single;

public class FetchDashboardUseCase {

    private DashboardRepository repository;

    @Inject
    public FetchDashboardUseCase(DashboardRepository repository) {
        this.repository = repository;
    }

    public Single<Dashboard> getDashboard() {
        Single<Dashboard> dashboardSingle = Single.fromCallable(() -> this.repository.getDashboard());
        return dashboardSingle;
    }
}

package cn.com.ofashion.cleanarchitecture.presenter;

import javax.inject.Inject;

import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.usecase.DashboardUseCase;

public class DashboardPresenter {

    private DashboardUseCase useCase;
    private DashboardView view;

    @Inject
    public DashboardPresenter(DashboardUseCase useCase, DashboardView view) {
        this.useCase = useCase;
        this.view = view;
    }

    public void loadView(String studentId, String teacherId) {
//        Dashboard dashboard = this.useCase.getDashboard(studentId, teacherId).blockingGet();
        this.view.loadDashboard(null);
    }
}

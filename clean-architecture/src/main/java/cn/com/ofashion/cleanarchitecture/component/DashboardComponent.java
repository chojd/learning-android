package cn.com.ofashion.cleanarchitecture.component;


import cn.com.ofashion.cleanarchitecture.presenter.DashboardPresenter;
import cn.com.ofashion.cleanarchitecture.presenter.DashboardView;
import dagger.BindsInstance;
import dagger.Component;

@Component(modules = DashboardModule.class)
public interface DashboardComponent {

    DashboardPresenter presenter();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder baseUrl(String url);

        @BindsInstance
        Builder dashboardView(DashboardView view);

        DashboardComponent build();
    }
}

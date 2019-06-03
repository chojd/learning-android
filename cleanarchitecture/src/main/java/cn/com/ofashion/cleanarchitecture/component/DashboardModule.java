package cn.com.ofashion.cleanarchitecture.component;

import cn.com.ofashion.cleanarchitecture.api.DaggerApiComponent;
import cn.com.ofashion.cleanarchitecture.api.StudentApi;
import cn.com.ofashion.cleanarchitecture.api.TeacherApi;
import cn.com.ofashion.cleanarchitecture.presenter.DashboardPresenter;
import cn.com.ofashion.cleanarchitecture.presenter.DashboardView;
import cn.com.ofashion.cleanarchitecture.repository.DashboardRepository;
import cn.com.ofashion.cleanarchitecture.repository.StudentRepository;
import cn.com.ofashion.cleanarchitecture.repository.TeacherRepository;
import cn.com.ofashion.cleanarchitecture.usecase.DashboardUseCase;
import dagger.Module;
import dagger.Provides;

@Module
public class DashboardModule {

    @Provides
    DashboardPresenter presenter(DashboardUseCase useCase, DashboardView view) {
        return new DashboardPresenter(useCase, view);
    }

    @Provides
    DashboardUseCase dashboardUseCase(DashboardRepository repository) {
        return new DashboardUseCase(repository);
    }

    @Provides
    DashboardRepository dashboardRepository(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        return new DashboardRepository(studentRepository, teacherRepository);
    }

    @Provides
    StudentRepository studentRepository(StudentApi studentApi) {
        return new StudentRepository(studentApi);
    }

    @Provides
    TeacherRepository teacherRepository(TeacherApi teacherApi) {
        return new TeacherRepository(teacherApi);
    }

    @Provides
    StudentApi studentApi(String baseUrl) {
        return DaggerApiComponent.builder().baseUrl(baseUrl).build().studentApi();
    }

    @Provides
    TeacherApi teacherApi(String baseUrl) {
        return DaggerApiComponent.builder().baseUrl(baseUrl).build().teacherApi();
    }
}

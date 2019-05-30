package cn.com.ofashion.cleanarchitecture.api;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = ApiModule.class)
public interface ApiComponent {
    StudentApi studentApi();
    TeacherApi teacherApi();
    SchoolApi schoolApi();
    TestApi testApi();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder baseUrl(String baseUrl);

        ApiComponent build();
    }
}

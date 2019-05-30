package cn.com.ofashion.cleanarchitecture.api;

import cn.com.ofashion.cleanarchitecture.di.HTTPComponent;
import dagger.Component;

@Component(modules = ApiModule.class, dependencies = HTTPComponent.class)
public interface ApiComponent {
    StudentApi studentApi();
    TeacherApi teacherApi();
    SchoolApi schoolApi();
    TestApi testApi();

    @Component.Builder
    interface Builder {

        Builder HTTPComponent(HTTPComponent component);

        ApiComponent build();
    }
}

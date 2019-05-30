package cn.com.ofashion.cleanarchitecture.api;

import cn.com.ofashion.cleanarchitecture.di.HTTPComponent;
import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    StudentApi studentApi(HTTPComponent component) {
        return component.retrofit().create(StudentApi.class);
    }

    @Provides
    TeacherApi teacherApi(HTTPComponent component) {
        return component.retrofit().create(TeacherApi.class);
    }

    @Provides
    SchoolApi schoolApi(HTTPComponent component) {
        return component.retrofit().create(SchoolApi.class);
    }

    @Provides
    TestApi testApi(HTTPComponent component) {
        return component.retrofit().create(TestApi.class);
    }
}

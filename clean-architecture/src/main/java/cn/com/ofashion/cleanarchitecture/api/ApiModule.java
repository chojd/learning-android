package cn.com.ofashion.cleanarchitecture.api;

import cn.com.ofashion.cleanarchitecture.di.DaggerHTTPComponent;
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
    HTTPComponent component(String baseUrl) {
        return DaggerHTTPComponent.builder().baseUrl(baseUrl).build();
    }
}

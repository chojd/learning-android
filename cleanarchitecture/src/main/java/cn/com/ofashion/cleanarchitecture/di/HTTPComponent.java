package cn.com.ofashion.cleanarchitecture.di;

import dagger.BindsInstance;
import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = RetrofitModule.class)
public interface HTTPComponent {

    Retrofit retrofit();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder baseUrl(String baseUrl);

        HTTPComponent build();
    }

}

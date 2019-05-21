package cn.com.ofashion.httpservice;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = RetrofitModule.class)
public interface HTTPComponent {
    RetrofitApi retrofit();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder baseUrl(String baseUrl);

        HTTPComponent build();
    }
}

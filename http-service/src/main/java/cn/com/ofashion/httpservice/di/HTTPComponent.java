package cn.com.ofashion.httpservice.di;

import cn.com.ofashion.httpservice.api.RetrofitApi;
import dagger.BindsInstance;
import dagger.Component;

@Component(modules = RetrofitModule.class)
public interface HTTPComponent {
    RetrofitApi retrofitApi();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder baseUrl(String baseUrl);

        HTTPComponent build();
    }
}

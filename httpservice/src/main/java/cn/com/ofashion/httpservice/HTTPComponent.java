package cn.com.ofashion.httpservice;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = OkHttpModule.class)
public interface HTTPComponent {
    HTTPRequest httpRequest();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder url(String url);

        HTTPComponent build();
    }
}

package cn.com.ofashion.httpservice;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Module
class OkHttpModule {

    @Provides
    OkHttpClient provideHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    Request provideRequest(String url) {
        return new Request.Builder().url(url).build();
    }
}

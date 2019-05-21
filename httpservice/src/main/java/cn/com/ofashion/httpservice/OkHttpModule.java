package cn.com.ofashion.httpservice;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class OkHttpModule {

    @Provides
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }
}

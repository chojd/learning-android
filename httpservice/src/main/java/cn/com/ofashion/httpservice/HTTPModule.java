package cn.com.ofashion.httpservice;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
class HTTPModule {

    @Provides
    OkHttpClient provideHttpClient() {
        return new OkHttpClient();
    }

    @Provides HTTPRequest provideHTTPReuqest(OkHttpClient client){
        return new HTTPRequest(client);
    }
}

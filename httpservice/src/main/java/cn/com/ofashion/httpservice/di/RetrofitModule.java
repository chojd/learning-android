package cn.com.ofashion.httpservice.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.com.ofashion.httpservice.api.RetrofitApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpModule.class)
class RetrofitModule {

    @Provides
    RetrofitApi provideRetrofitApi(Retrofit retrofit) {
        return retrofit.create(RetrofitApi.class);
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient client,
                             String baseUrl,
                             GsonConverterFactory factory) {
    return new Retrofit.Builder()
            .client(client)
            .addConverterFactory(factory)
            .baseUrl(baseUrl)
            .build();
    }

    @Provides
    GsonConverterFactory provideConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(AutoValueTypeAdapterFactory.create());
        return builder.create();
    }
}

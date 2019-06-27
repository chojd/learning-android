package cn.com.ofashion.cleanarchitecture.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpModule.class)
class RetrofitModule {

    @Provides
    Retrofit provideRetrofit(OkHttpClient client, String baseUrl, GsonConverterFactory converterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(converterFactory)
                .client(client)
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

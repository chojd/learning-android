package cn.com.ofashion.httpservice;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class RetrofitModule {

    @Provides
    RetrofitApi provideRetrofitApi(Retrofit retrofit) {
        return retrofit.create(RetrofitApi.class);
    }

    @Provides
    Retrofit provideRetrofit(String baseUrl, GsonConverterFactory factory) {
    return new Retrofit.Builder()
            .addConverterFactory(factory)
            .baseUrl(baseUrl)
            .build();
    }

    @Provides
    GsonConverterFactory factory() {
        return GsonConverterFactory.create();
    }
}

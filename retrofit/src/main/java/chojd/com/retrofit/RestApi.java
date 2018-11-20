package chojd.com.retrofit;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {
    String HOST = "https://tsuppluapi.ofashion.com.cn:82/";

    @GET("index/getIndex")
    Single<Response<IndexDto>> createUser(@Query("start") int start, @Query("count") int count);
}

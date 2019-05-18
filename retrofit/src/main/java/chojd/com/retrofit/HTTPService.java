package chojd.com.retrofit;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface HTTPService {
    String BASE_URL = "https://retailapi.buyerbox.com/";

    @GET("config/getHotConfig")
    Single<Response<ConfigEntity>> getHotConfig(@Query("div") String div, @Query("no_check") int check);
}

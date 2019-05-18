package chojd.com.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

public class ConfigServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void configResponseValidate() {

//        Retrofit.Builder builder = new Retrofit.Builder();
//        builder.addConverterFactory(GsonConverterFactory.create(TestGsonUtil.gson()));
//        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
//        builder.baseUrl(mockWebServer.url(MOCK_SERVER));
//        Retrofit retrofit = builder.build();

        //given
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create(baseGson()));
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.baseUrl(HTTPService.BASE_URL);
        Retrofit retrofit = builder.build();
        //when
        HTTPService service = retrofit.create(HTTPService.class);
        Single<Response<ConfigEntity>> hotConfig = service.getHotConfig("1.2.0", 1);
        TestObserver<Response<ConfigEntity>> testObserver = new TestObserver<>();
        hotConfig.subscribe(testObserver);
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    private Gson baseGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        return builder.create();
    }
}
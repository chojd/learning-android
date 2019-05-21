package cn.com.ofashion.cleanarchitecture.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import cn.com.ofashion.cleanarchitecture.di.DaggerHTTPComponent;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Retrofit;

import static org.junit.Assert.*;

public class TestApiTest {

    private MockWebServer mServer;
    private Retrofit mRetrofit;

    @Before
    public void setUp() throws Exception {
        mServer = new MockWebServer();
        assertNotNull(mServer);
        mServer.start();

        String baseUrl = "http://" + mServer.getHostName() + ":" + mServer.getPort();
        assertNotNull(baseUrl);
        System.out.println(baseUrl);

        mRetrofit = DaggerHTTPComponent.builder().baseUrl(baseUrl).build().retrofit();
        assertNotNull(mRetrofit);
    }

    @After
    public void tearDown() throws Exception {
        mServer.close();
    }

    @Test
    public void getTest() throws IOException {

        MockResponse mockResponse = new MockResponse()
                .setBody("{\"name\":\"gene\"}");
        mServer.enqueue(mockResponse);

        TestApi api = mRetrofit.create(TestApi.class);
        Call<Map> from = api.getTest();
        Map body = from.execute().body();
        assertEquals(body.get("name"), "gene");
    }
}
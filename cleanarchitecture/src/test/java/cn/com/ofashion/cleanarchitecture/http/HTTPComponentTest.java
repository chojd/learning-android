package cn.com.ofashion.cleanarchitecture.http;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Retrofit;

import static org.junit.Assert.*;

public class HTTPComponentTest {

    static final String MOCK_BASE_URL = "http://mockserver.com/";

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void mockServer() throws IOException {
        MockWebServer server = new MockWebServer();
        assertNotNull(server);

        MockResponse mockResponse = new MockResponse()
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .setBody("{\"name\":\"gene\"}");
        server.enqueue(mockResponse);

        String baseUrl = "http://" + server.getHostName() + ":" + server.getPort();
        assertNotNull(baseUrl);
        System.out.println(baseUrl);

        Retrofit mRetrofit = DaggerHTTPComponent.builder().baseUrl(baseUrl).build().retrofit();
        assertNotNull(mRetrofit);

        HomeApi api = mRetrofit.create(HomeApi.class);
        Call<Map> from = api.getFrom();
        Map body = from.execute().body();
        assertEquals(body.get("name"), "gene");
    }

}
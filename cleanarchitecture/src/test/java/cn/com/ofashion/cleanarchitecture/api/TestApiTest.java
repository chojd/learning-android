package cn.com.ofashion.cleanarchitecture.api;

import com.google.common.truth.Truth;

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

public class TestApiTest{

    private MockWebServer server;
    private Retrofit retrofit;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        Truth.assertThat(server).isNotNull();
        server.start();

        String baseUrl = server.url("/").toString();
        Truth.assertThat(baseUrl).isNotNull();

        retrofit = DaggerHTTPComponent.builder().baseUrl(baseUrl).build().retrofit();
        Truth.assertThat(retrofit).isNotNull();
    }

    @After
    public void tearDown() throws Exception {
        server.close();
    }

    @Test
    public void getTest() throws IOException {

        MockResponse mockResponse = new MockResponse()
                .setBody("{\"name\":\"gene\"}");
        server.enqueue(mockResponse);

        TestApi api = retrofit.create(TestApi.class);
        Call<Map> from = api.getTest();
        Map body = from.execute().body();
        String name = (String) body.get("name");
        Truth.assertThat(name).isEqualTo("gene");
    }
}
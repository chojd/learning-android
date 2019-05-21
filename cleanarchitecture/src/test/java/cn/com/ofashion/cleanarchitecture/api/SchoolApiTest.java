package cn.com.ofashion.cleanarchitecture.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.di.DaggerHTTPComponent;
import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Retrofit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SchoolApiTest{

    private MockWebServer mServer;
    private Retrofit mRetrofit;

    @Before
    public void setUp() throws Exception {
        mServer = new MockWebServer();
        assertNotNull(mServer);
        mServer.start();

        String baseUrl = mServer.url("/").toString();
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
    public void getDashboard() throws IOException {

        MockResponse mockResponse = new MockResponse()
                .setBody("{\"teacher\":{\"name\":\"teacher_name\"},\"student\":{\"name\":\"student_name\"}}");
        mServer.enqueue(mockResponse);

        SchoolApi api = mRetrofit.create(SchoolApi.class);
        Call<Dashboard> dashboardCall = api.getDashboard();
        Dashboard dashboard = dashboardCall.execute().body();
        assertNotNull(dashboard);

        assertNotNull(dashboard.teacher());
        assertEquals(dashboard.teacher().name(), "teacher_name");

        assertNotNull(dashboard.student());
        assertEquals(dashboard.student().name(), "student_name");
    }

}
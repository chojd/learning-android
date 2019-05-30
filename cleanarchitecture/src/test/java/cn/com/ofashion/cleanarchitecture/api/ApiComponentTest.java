package cn.com.ofashion.cleanarchitecture.api;

import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;

import cn.com.ofashion.cleanarchitecture.di.DaggerHTTPComponent;
import cn.com.ofashion.cleanarchitecture.di.HTTPComponent;
import okhttp3.mockwebserver.MockWebServer;

import static org.junit.Assert.*;

public class ApiComponentTest {

    private MockWebServer server;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        Truth.assertThat(server).isNotNull();
        server.start();

        baseUrl = server.url("/").toString();
        Truth.assertThat(baseUrl).isNotNull();
    }

    @Test
    public void studentApi() {
        HTTPComponent httpComponent = DaggerHTTPComponent.builder().baseUrl(baseUrl).build();
        StudentApi api = DaggerApiComponent.builder().HTTPComponent(httpComponent).build().studentApi();
        Truth.assertThat(api).isNotNull();
    }

    @Test
    public void teacherApi() {
        HTTPComponent httpComponent = DaggerHTTPComponent.builder().baseUrl(baseUrl).build();
        TeacherApi api = DaggerApiComponent.builder().HTTPComponent(httpComponent).build().teacherApi();
        Truth.assertThat(api).isNotNull();
    }

    @Test
    public void schoolApi() {
        HTTPComponent httpComponent = DaggerHTTPComponent.builder().baseUrl(baseUrl).build();
        SchoolApi api = DaggerApiComponent.builder().HTTPComponent(httpComponent).build().schoolApi();
        Truth.assertThat(api).isNotNull();
    }

    @Test
    public void testApi() {
        HTTPComponent httpComponent = DaggerHTTPComponent.builder().baseUrl(baseUrl).build();
        TestApi api = DaggerApiComponent.builder().HTTPComponent(httpComponent).build().testApi();
        Truth.assertThat(api).isNotNull();
    }
}
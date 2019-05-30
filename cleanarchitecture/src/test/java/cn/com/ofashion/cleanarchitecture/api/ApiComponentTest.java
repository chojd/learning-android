package cn.com.ofashion.cleanarchitecture.api;

import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import okhttp3.mockwebserver.MockWebServer;

public class ApiComponentTest {

    @Mock
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
        StudentApi api = DaggerApiComponent.builder().baseUrl(baseUrl).build().studentApi();
        Truth.assertThat(api).isNotNull();
    }

    @Test
    public void teacherApi() {
        TeacherApi api = DaggerApiComponent.builder().baseUrl(baseUrl).build().teacherApi();
        Truth.assertThat(api).isNotNull();
    }

}
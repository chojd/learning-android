package cn.com.ofashion.cleanarchitecture.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.junit.Assert.*;

public class DashboardRespositoryTest {

    private MockWebServer mServer;
    private String mBaseUrl;

    @Before
    public void setUp() throws Exception {
        mServer = new MockWebServer();
        assertNotNull(mServer);
        mServer.start();

        mBaseUrl = mServer.url("/").toString();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDashboard() throws IOException {
        MockResponse mockResponse = new MockResponse()
                .setBody("{\"teacher\":{\"name\":\"teacher_name\"},\"student\":{\"name\":\"student_name\"}}");
        mServer.enqueue(mockResponse);

        Dashboard dashboard = new DashboardRespository().getDashboard(mBaseUrl);

        assertNotNull(dashboard);

        assertNotNull(dashboard.teacher());
        assertEquals(dashboard.teacher().name(), "teacher_name");

        assertNotNull(dashboard.student());
        assertEquals(dashboard.student().name(), "student_name");
    }
}
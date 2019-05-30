package cn.com.ofashion.cleanarchitecture.repository;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.api.DaggerApiComponent;
import cn.com.ofashion.cleanarchitecture.api.SchoolApi;
import cn.com.ofashion.cleanarchitecture.di.DaggerHTTPComponent;
import cn.com.ofashion.cleanarchitecture.di.HTTPComponent;
import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.model.Student;
import cn.com.ofashion.cleanarchitecture.model.Teacher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class DashboardRepositoryTest {

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

    @After
    public void tearDown() {
    }

    @Test
    public void getDashboard() throws IOException {
        MockResponse mockResponse = new MockResponse()
                .setBody("{\"teacher\":{\"name\":\"teacher_name\",\"age\":35},\"student\":{\"name\":\"student_name\",\"age\":15}}");
        server.enqueue(mockResponse);

        SchoolApi api = DaggerApiComponent.builder().baseUrl(baseUrl).build().schoolApi();

        Dashboard dashboard = new DashboardRepository(api).getDashboard();

        Truth.assertThat(dashboard).isNotNull();

        Teacher teacher = Teacher.builder().name("teacher_name").age(35).build();
        Truth.assertThat(dashboard.teacher()).isEqualTo(teacher);

        Student student = Student.builder().name("student_name").age(15).build();
        Truth.assertThat(dashboard.student()).isEqualTo(student);
    }
}
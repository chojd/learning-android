package cn.com.ofashion.cleanarchitecture.usecase;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.model.Student;
import cn.com.ofashion.cleanarchitecture.model.Teacher;
import io.reactivex.Single;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class FetchDashboardUseCaseTest {

    private MockWebServer server;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        Truth.assertThat(server).isNotNull();
        server.start();

        baseUrl = server.url("/").toString();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDashboard() throws IOException {
        MockResponse mockResponse = new MockResponse()
                .setBody("{\"teacher\":{\"name\":\"teacher_name\",\"age\":35},\"student\":{\"name\":\"student_name\",\"age\":15}}");
        server.enqueue(mockResponse);

        Single<Dashboard> dashboardSingle = new FetchDashboardUseCase().getDashboard(baseUrl);
        Teacher teacher = Teacher.builder().name("teacher_name").age(35).build();
        Student student = Student.builder().name("student_name").age(15).build();
        dashboardSingle.test().assertValue(Dashboard.builder().student(student).teacher(teacher).build());
    }
}
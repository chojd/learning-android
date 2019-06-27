package cn.com.ofashion.cleanarchitecture.repository;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.api.ApiComponent;
import cn.com.ofashion.cleanarchitecture.api.DaggerApiComponent;
import cn.com.ofashion.cleanarchitecture.api.StudentApi;
import cn.com.ofashion.cleanarchitecture.api.TeacherApi;
import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.model.MockApiConstants;
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
    public void dashboard() throws IOException {
        MockResponse mockResponse = new MockResponse()
                .setBody("{\"name\":\"student_name\",\"age\":15}");
        server.enqueue(mockResponse);

        MockResponse mockResponse1 = new MockResponse()
                .setBody("{\"name\":\"teacher_name\",\"age\":35}");
        server.enqueue(mockResponse1);

        ApiComponent apiComponent = DaggerApiComponent.builder().baseUrl(baseUrl).build();

        StudentApi studentApi = apiComponent.studentApi();
        TeacherApi teacherApi = apiComponent.teacherApi();

        StudentRepository studentRepository = new StudentRepository(studentApi);
        TeacherRepository teacherRepository = new TeacherRepository(teacherApi);

        DashboardRepository repository = new DashboardRepository(studentRepository, teacherRepository);
        Dashboard dashboard = repository.dashboard(MockApiConstants.STUDENT_ID, MockApiConstants.TEACHER_ID);

        Truth.assertThat(dashboard).isNotNull();

        Teacher teacher = Teacher.builder().name("teacher_name").age(35).build();
        Truth.assertThat(dashboard.teacher()).isEqualTo(teacher);

        Student student = Student.builder().name("student_name").age(15).build();
        Truth.assertThat(dashboard.student()).isEqualTo(student);
    }
}
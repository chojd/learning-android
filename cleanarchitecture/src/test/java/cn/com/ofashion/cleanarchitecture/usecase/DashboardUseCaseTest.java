package cn.com.ofashion.cleanarchitecture.usecase;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.api.ApiComponent;
import cn.com.ofashion.cleanarchitecture.api.DaggerApiComponent;
import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.model.MockApiConstants;
import cn.com.ofashion.cleanarchitecture.model.Student;
import cn.com.ofashion.cleanarchitecture.model.Teacher;
import cn.com.ofashion.cleanarchitecture.repository.DashboardRepository;
import cn.com.ofashion.cleanarchitecture.repository.StudentRepository;
import cn.com.ofashion.cleanarchitecture.repository.TeacherRepository;
import io.reactivex.Single;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.mockito.BDDMockito.given;

public class DashboardUseCaseTest {

    private MockWebServer server;
    private String baseUrl;

    @Mock
    private TeacherRepository teacherRepository;
    @Mock
    private StudentRepository studentRepository;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        Truth.assertThat(server).isNotNull();
        server.start();

        baseUrl = server.url("/").toString();

        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void dashboard() {
        // given
        MockResponse mockResponse = new MockResponse()
                .setBody("{\"name\":\"student_name\",\"age\":15}");
        server.enqueue(mockResponse);

        MockResponse mockResponse1 = new MockResponse()
                .setBody("{\"name\":\"teacher_name\",\"age\":35}");
        server.enqueue(mockResponse1);

        ApiComponent apiComponent = DaggerApiComponent.builder().baseUrl(baseUrl).build();

        StudentRepository studentRepository = new StudentRepository(apiComponent.studentApi());
        TeacherRepository teacherRepository = new TeacherRepository(apiComponent.teacherApi());

        DashboardRepository dashboardRepository = new DashboardRepository(studentRepository, teacherRepository);

        DashboardUseCase dashboardUseCase = new DashboardUseCase(dashboardRepository);

        // when
        Single<Dashboard> dashboardSingle = dashboardUseCase.getDashboard(MockApiConstants.STUDENT_ID, MockApiConstants.TEACHER_ID);

        Teacher teacher = Teacher.builder().name("teacher_name").age(35).build();
        Student student = Student.builder().name("student_name").age(15).build();

        // then
        dashboardSingle.test().assertValue(Dashboard.builder().student(student).teacher(teacher).build());
    }

    @Test
    public void mockitoDashboard() throws IOException {

        Student student = Student.builder().name("student_name").age(15).build();
        Teacher teacher = Teacher.builder().name("teacher_name").age(35).build();

        given(studentRepository.fetch(MockApiConstants.STUDENT_ID)).willReturn(student);
        given(teacherRepository.fetch(MockApiConstants.TEACHER_ID)).willReturn(teacher);

        DashboardRepository dashboardRepository = new DashboardRepository(studentRepository, teacherRepository);
        Dashboard dashboard = dashboardRepository.dashboard(MockApiConstants.STUDENT_ID, MockApiConstants.TEACHER_ID);
        Truth.assertThat(dashboard).isEqualTo(Dashboard.builder().student(student).teacher(teacher).build());
    }

}
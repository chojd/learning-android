package cn.com.ofashion.cleanarchitecture.api;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cn.com.ofashion.cleanarchitecture.di.DaggerHTTPComponent;
import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.model.Student;
import cn.com.ofashion.cleanarchitecture.model.Teacher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Retrofit;

public class SchoolApiTest{

    private MockWebServer server;
    private Retrofit retrofit;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        Truth.assertThat(server).isNotNull();
        server.start();

        String baseUrl = server.url("/").toString();
        Truth.assertThat(baseUrl).isNotNull();
        System.out.println(baseUrl);

        retrofit = DaggerHTTPComponent.builder().baseUrl(baseUrl).build().retrofit();
        Truth.assertThat(retrofit).isNotNull();
    }

    @After
    public void tearDown() throws Exception {
        server.close();
    }

    @Test
    public void getDashboard() throws IOException {

        MockResponse mockResponse = new MockResponse()
                .setBody("{\"teacher\":{\"name\":\"teacher_name\",\"age\":35},\"student\":{\"name\":\"student_name\",\"age\":15}}");
        server.enqueue(mockResponse);

        SchoolApi api = retrofit.create(SchoolApi.class);
        Call<Dashboard> dashboardCall = api.getDashboard();
        Dashboard dashboard = dashboardCall.execute().body();

        Truth.assertThat(dashboard).isNotNull();
        
        Teacher teacher = Teacher.builder().name("teacher_name").age(35).build();
        Truth.assertThat(dashboard.teacher()).isEqualTo(teacher);

        Student student = Student.builder().name("student_name").age(15).build();
        Truth.assertThat(dashboard.student()).isEqualTo(student);
    }

}
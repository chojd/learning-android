package cn.com.ofashion.httpservice;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.com.ofashion.httpservice.api.RetrofitApi;
import cn.com.ofashion.httpservice.di.DaggerHTTPComponent;
import cn.com.ofashion.httpservice.model.Member;
import cn.com.ofashion.httpservice.model.Metadata;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;

public class HTTPServiceTest {

    static final String MOCK_BASE_URL = "https://easy-mock.com/mock/5cdff32c6a71205ae88096dd/";

    private RetrofitApi mRetrofitApi;

    @Before
    public void setUp() {
        mRetrofitApi = DaggerHTTPComponent.builder().baseUrl(MOCK_BASE_URL).build().retrofitApi();
        assertNotNull(mRetrofitApi);
    }

    @Test
    public void retrofitGETService() throws IOException {
        Call<Metadata> call = mRetrofitApi.getService("who");
        Response<Metadata> execute = call.execute();
        Metadata metadata = execute.body();
        assertEquals(metadata.message(), "success");
        assertEquals(metadata.code(), 0);
        assertNotNull(metadata.data());
        assertTrue(metadata.data() instanceof Map);
    }

    @Test
    public void getFamily() throws IOException {
        Response<List<Member>> execute = mRetrofitApi.getFamily().execute();
        List<Member> members = execute.body();
        assertEquals(members.size(), 4);
        for (Member member:
             members) {
            String print = "role : " + member.role() + " age : " + member.age() + " name : " + member.name();
            System.out.println (print);
            assertNotNull(member.role());
            assertNotNull(member.age());
            assertNotNull(member.name());
        }
    }
}
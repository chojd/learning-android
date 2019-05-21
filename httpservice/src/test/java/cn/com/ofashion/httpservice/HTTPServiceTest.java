package cn.com.ofashion.httpservice;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;

public class HTTPServiceTest {

    static final String URL = "https://ofashion.com.cn";
    static final String whoURL = "https://easy-mock.com/mock/5cdff32c6a71205ae88096dd/who";
    static final String MOCK_BASE_URL = "https://easy-mock.com/mock/5cdff32c6a71205ae88096dd/";

    @Test
    public void retrofitGETService() throws IOException {
        RetrofitApi retrofitApi = DaggerHTTPComponent.builder().baseUrl(MOCK_BASE_URL).build().retrofit();
        Call<Metadata> call = retrofitApi.getService("who");
        Response<Metadata> execute = call.execute();
        Metadata metadata = execute.body();
        assertEquals(metadata.message, "success");
        assertEquals(metadata.code, 0);
        assertNotNull(metadata.data);
        assertTrue(metadata.data instanceof Map);
    }
}
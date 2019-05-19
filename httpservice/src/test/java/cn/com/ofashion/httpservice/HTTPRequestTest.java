package cn.com.ofashion.httpservice;

import org.junit.Test;

import okhttp3.Request;

import static org.junit.Assert.*;

public class HTTPRequestTest {

    @Test
    public void execute() {
        HTTPRequest httpRequest = DaggerHTTPComponent.create().httpRequest();
        Request request = new Request.Builder().url("https://easy-mock.com/mock/5cdff32c6a71205ae88096dd/who").build();
        String response = httpRequest.execute(request);
        assertEquals(response, "{\"status\":\"success\",\"data\":{\"name\":\"gene\"}}");
    }
}
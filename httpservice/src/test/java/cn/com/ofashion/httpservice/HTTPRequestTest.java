package cn.com.ofashion.httpservice;

import org.junit.Test;

import static org.junit.Assert.*;

public class HTTPRequestTest {

    static final String whoURL = "https://easy-mock.com/mock/5cdff32c6a71205ae88096dd/who";

    @Test
    public void execute() {
        HTTPRequest httpRequest = DaggerHTTPComponent.builder().url(whoURL).build().httpRequest();
        String response = httpRequest.execute();
        assertEquals(response, "{\"status\":\"success\",\"data\":{\"name\":\"gene\"}}");
    }
}
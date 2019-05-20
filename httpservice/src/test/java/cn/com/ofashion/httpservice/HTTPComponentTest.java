package cn.com.ofashion.httpservice;

import org.junit.Test;

import static org.junit.Assert.*;

public class HTTPComponentTest {

    static final String URL = "https://ofashion.com.cn";

    @Test
    public void httpRequest() {
        HTTPRequest request = DaggerHTTPComponent.builder().url(URL).build().httpRequest();
        assertNotNull(request);
    }


}
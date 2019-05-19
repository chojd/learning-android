package cn.com.ofashion.httpservice;

import org.junit.Test;
import org.junit.runner.Request;

import static org.junit.Assert.*;

public class HTTPComponentTest {

    @Test
    public void httpRequest() {
        HTTPRequest request = DaggerHTTPComponent.create().httpRequest();
        assertNotNull(request);
    }


}
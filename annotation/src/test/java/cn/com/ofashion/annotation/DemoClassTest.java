package cn.com.ofashion.annotation;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DemoClassTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sayHello() {
        DemoClass demoClass = new DemoClass();
        Truth.assertThat(demoClass.sayHello()).isEqualTo("Hello");
    }
}
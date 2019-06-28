package cn.com.ofashion.montage.using;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.ofashion.montage.MontageFactory;

public class HelloBeanTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void annotation() {
        HelloBean helloBean = new HelloBean();
        Truth.assertThat(helloBean).isNotNull();
    }

    @Test
    public void beanFactory() {
        MontageFactory montageFactory = new MontageFactory();
        Truth.assertThat(montageFactory).isNotNull();
    }
}
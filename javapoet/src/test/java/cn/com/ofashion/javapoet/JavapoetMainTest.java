package cn.com.ofashion.javapoet;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JavapoetMainTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void makeFileContent() {
        JavapoetMain javapoetMain = new JavapoetMain();
        String content = javapoetMain.makeFileContent();
        Truth.assertThat(content).isNotNull();
        Truth.assertThat(content).contains("class MontageFactory");
        Truth.assertThat(content).contains("public void helloWorld");
        System.out.println(content);
    }
}
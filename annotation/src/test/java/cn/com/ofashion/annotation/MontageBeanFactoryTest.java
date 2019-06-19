package cn.com.ofashion.annotation;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MontageBeanFactoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInstance() {
        MontageBeanFactory instance = MontageBeanFactory.getInstance();
        Truth.assertThat(instance).isNotNull();

        MontageBeanFactory instance1 = MontageBeanFactory.getInstance();
        Truth.assertThat(instance1).isEqualTo(instance);
    }

    @Test
    public void registerBean() {
        MontageBeanFactory instance = MontageBeanFactory.getInstance();
        instance.registerBean(20, MontageBeanFactoryTest.class);
    }

    @Test
    public void createBean() {
        MontageBeanFactory instance = MontageBeanFactory.getInstance();
        instance.registerBean(20, MontageBeanFactoryTest.class);
        Class clzz = instance.createBean(20);
        Truth.assertThat(clzz).isNotNull();
    }
}
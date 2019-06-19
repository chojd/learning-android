package cn.com.ofashion.annotation;

import java.util.HashMap;

public class MontageBeanFactory {

    private HashMap<Integer, Class>mapping;

    private static MontageBeanFactory instance = new MontageBeanFactory();
    private MontageBeanFactory() {
        mapping = new HashMap<>();
    }

    public static MontageBeanFactory getInstance() {
        return instance;
    }

    public int registerBean(Integer type, Class beanClass) {
        mapping.put(type, beanClass);
        return 0;
    }

    public Class createBean(Integer type) {
        Class beanClass = mapping.get(type);
        return beanClass;
    }

}

package cn.com.ofashion.dagger2;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerTest {

    @Test
    public void getMaker() {
        CoffeeMaker maker = DaggerCoffeeMakerComponent.create().getCoffeeMaker();
        assertNotNull(maker);
    }

    @Test
    public void makeCoffee() {
        CoffeeMaker maker = DaggerCoffeeMakerComponent.create().getCoffeeMaker();
        Coffee coffee = maker.makeCoffee();
        assertNotNull(coffee);
    }
}
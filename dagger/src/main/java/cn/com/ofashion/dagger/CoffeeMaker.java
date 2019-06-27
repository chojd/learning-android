package cn.com.ofashion.dagger;

import javax.inject.Inject;

public class CoffeeMaker {
    private final Heater heater;
    private final Pump pump;
    private final Bean bean;

    @Inject
    CoffeeMaker(Heater heater, Pump pump, Bean bean) {
        this.heater = heater;
        this.pump = pump;
        this.bean = bean;
    }

    @Inject
    Coffee makeCoffee() {
        return new Coffee();
    }
}

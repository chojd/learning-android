package cn.com.ofashion.dagger2;

import android.support.annotation.NonNull;

import javax.inject.Inject;

public class CoffeeMaker {
    private final Heater heater;
    private final Pump pump;
    private final Bean bean;

    @Inject CoffeeMaker(@NonNull Heater heater, @NonNull Pump pump, @NonNull Bean bean) {
        this.heater = heater;
        this.pump = pump;
        this.bean = bean;
    }

    @Inject Coffee makeCoffee() {
        return new Coffee();
    }
}

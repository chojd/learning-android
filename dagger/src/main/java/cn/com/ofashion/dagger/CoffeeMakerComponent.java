package cn.com.ofashion.dagger;

import dagger.Component;

@Component(modules = CoffeeModule.class)
public interface CoffeeMakerComponent {
    CoffeeMaker getCoffeeMaker();
}

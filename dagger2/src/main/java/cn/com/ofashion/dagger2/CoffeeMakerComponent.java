package cn.com.ofashion.dagger2;

import dagger.Component;

@Component(modules = CoffeeModule.class)
public interface CoffeeMakerComponent {
    CoffeeMaker getCoffeeMaker();
}

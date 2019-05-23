package cn.com.ofashion.dagger2;

import dagger.Module;
import dagger.Provides;

@Module
public class CoffeeModule {

    @Provides
    Heater provideHeater() {
        return new ElectricHeater();
    }

    @Provides
    Pump providePump(Heater heater) {
        return new Thermosiphon();
    }
}

package coffehome;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CofferHomeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createCoffeeA() {
        // Given
        CofferHome givenHome = new CofferHome();
        String givenSpec = "A";
        // When
        ICoffee realCoffee = givenHome.createCoffee(givenSpec);
        // Then
        Class expectClass = CoffeeA.class;
        Truth.assertThat(realCoffee).isInstanceOf(expectClass);
    }

    @Test
    public void createCoffeeB() {
        // Given
        CofferHome givenHome = new CofferHome();
        String givenSpec = "B";
        // When
        ICoffee realCoffee = givenHome.createCoffee(givenSpec);
        // Then
        Class expectClass = CoffeeB.class;
        Truth.assertThat(realCoffee).isInstanceOf(expectClass);
    }

    @Test
    public void createCoffeeC() {
        // Given
        CofferHome givenHome = new CofferHome();
        String givenSpec = "C";
        // When
        ICoffee realCoffee = givenHome.createCoffee(givenSpec);
        // Then
        Truth.assertThat(realCoffee).isNull();
    }
}
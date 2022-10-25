package betterpizza;

import org.junit.Before;
import pizza.Crust;
import pizza.Size;

/**
 * Tests the operations in the VeggiePizza class.
 */
public class VeggiePizzaTest {

  ObservablePizza veggie;

  @Before
  public void init() {
    veggie = new VeggiePizza.VeggiePizzaBuilder()
        .crust(Crust.Thin)
        .size(Size.Large)
        .noCheese()
        .noSauce()
        .noBlackOlive()
        .noGreenPepper()
        .noJalapeno()
        .noOnion()
        .noTomato()
        .build();
  }

}
package betterpizza;

import org.junit.Before;
import pizza.Crust;
import pizza.Size;

/**
 * Tests the operations in the CheesePizza class.
 */
public class CheesePizzaTest {
  ObservablePizza cheese;
  ObservablePizza cheese2;
  ObservablePizza cheese3;

  ObservablePizza p1;
  ObservablePizza p2;


  @Before
  public void init() {
    cheese = new CheesePizza.CheesePizzaBuilder()
        .crust(Crust.Thin)
        .size(Size.Large)
        .build();
    cheese2 = new CheesePizza.CheesePizzaBuilder()
        .crust(Crust.Stuffed)
        .size(Size.Medium)
        .build();
    cheese3 = new CheesePizza.CheesePizzaBuilder()
        .crust(Crust.Stuffed)
        .size(Size.Medium)
        .leftHalfCheese()
        .build();
    p1 = new CheesePizza.CheesePizzaBuilder()
        .crust(Crust.Stuffed)
        .size(Size.Medium)
        .build();
    p2 = new VeggiePizza.VeggiePizzaBuilder()
        .crust(Crust.Thin)
        .size(Size.Large)
        .build();

  }

}
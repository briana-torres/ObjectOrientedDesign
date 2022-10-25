package betterpizza;

import org.junit.Before;
import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * Tests the operations in the AlaCartePizza class.
 */
public class AlaCartePizzaTest {

  ObservablePizza alacarte;

  @Before
  public void init() {
    ObservablePizza alacarte = new AlaCartePizza.AlaCartePizzaBuilder()
        .crust(Crust.Classic)
        .size(Size.Medium)
        .addTopping(ToppingName.Cheese, ToppingPortion.Full)
        .addTopping(ToppingName.Sauce,ToppingPortion.Full)
        .addTopping(ToppingName.GreenPepper,ToppingPortion.Full)
        .addTopping(ToppingName.Onion,ToppingPortion.Full)
        .addTopping(ToppingName.Jalapeno,ToppingPortion.LeftHalf)
        .build();
  }

}
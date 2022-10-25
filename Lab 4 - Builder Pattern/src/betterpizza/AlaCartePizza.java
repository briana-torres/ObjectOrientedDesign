package betterpizza;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an ala carte pizza (i.e. a pizza that can
 * have an arbitrary number of ingredients.
 */
public class AlaCartePizza implements ObservablePizza {
  protected Crust crust;
  protected Size size;
  protected Map<ToppingName, ToppingPortion> toppings;

  /**
   * Create a pizza given its crust type, size and toppings.
   */
  public AlaCartePizza(Size size, Crust crust) {
    this.crust = crust;
    this.size = size;
    this.toppings = new HashMap<ToppingName, ToppingPortion>();
  }

  /**
   * Create a pizza given its crust type, size and toppings.
   */
  protected AlaCartePizza(Crust crust, Size size, Map<ToppingName, ToppingPortion> toppings)
      throws IllegalArgumentException {
    if (size == null) {
      throw new IllegalStateException("Size cannot be null");
    }
    if (crust == null) {
      throw new IllegalStateException("Crust cannot be null");
    }
    if (toppings == null) {
      throw new IllegalStateException("Toppings cannot be null");
    }
    this.crust = crust;
    this.size = size;
    this.toppings = toppings;
  }

  /**
   * Allows the client to build an alacarte pizza.
   */
  public static class AlaCartePizzaBuilder extends PizzaBuilder<AlaCartePizzaBuilder> {

    /**
     * Creates a pizza builder.
     */
    public AlaCartePizzaBuilder() {
      this.toppings = new HashMap<ToppingName, ToppingPortion>();
    }

    @Override
    public AlaCartePizzaBuilder crust(Crust crust)  {
      this.crust = crust;
      return this.returnBuilder();
    }

    @Override
    public AlaCartePizzaBuilder size(Size size) {
      this.size = size;
      return this.returnBuilder();
    }

    @Override
    public AlaCartePizzaBuilder addTopping(ToppingName name, ToppingPortion portion) {
      this.toppings.put(name, portion);
      return this.returnBuilder();
    }

    /**
     * Creates a new alacarte pizza.
     *
     * @return an {@code AlaCartePizza} object
     */
    public AlaCartePizza build() {
      if (this.size == null) {
        throw new IllegalStateException("Size cannot be null");
      }
      AlaCartePizza alacarte = new AlaCartePizza(this.crust, this.size, this.toppings);
      return alacarte;
    }

    @Override
    public AlaCartePizzaBuilder returnBuilder() {
      return this;
    }

  }

  @Override
  public ToppingPortion hasTopping(ToppingName name) {
    return this.toppings.getOrDefault(name, null);
  }

  @Override
  public double cost() {
    double cost = 0.0;
    for (Map.Entry<ToppingName, ToppingPortion> item : this.toppings.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultiplier();
    }
    return cost + this.size.getBaseCost();
  }

}

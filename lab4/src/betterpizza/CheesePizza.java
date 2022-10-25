package betterpizza;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a cheese pizza.
 */
public class CheesePizza extends AlaCartePizza {

  /**
   * Create a cheese pizza of the specified size with the specified crust.
   *
   * @param size  the size of this pizza
   * @param crust the crust of this pizza
   */
  public CheesePizza(Size size, Crust crust) {
    super(size, crust);
    //this.addTopping(ToppingName.Cheese, ToppingPortion.Full);
    //this.addTopping(ToppingName.Sauce, ToppingPortion.Full);
  }

  protected CheesePizza(Crust crust, Size size, Map<ToppingName, ToppingPortion> toppings) {
    super(crust, size, toppings);
  }

  /**
   * Allows the client to build a cheese pizza.
   */
  public static class CheesePizzaBuilder extends PizzaBuilder<CheesePizzaBuilder> {

    /**
     * Adds the correct toppings for a cheese pizza.
     */
    public CheesePizzaBuilder() {
      this.toppings = new HashMap<ToppingName, ToppingPortion>();
      this.addTopping(ToppingName.Cheese, ToppingPortion.Full);
      this.addTopping(ToppingName.Sauce, ToppingPortion.Full);
    }

    @Override
    public CheesePizzaBuilder crust(Crust crust) {
      this.crust = crust;
      return this.returnBuilder();
    }

    @Override
    public CheesePizzaBuilder size(Size size) {
      this.size = size;
      return this.returnBuilder();
    }

    @Override
    public CheesePizzaBuilder addTopping(ToppingName name, ToppingPortion portion) {
      this.toppings.put(name, portion);
      return this.returnBuilder();
    }

    @Override
    public CheesePizza build() {
      CheesePizza cheese = new CheesePizza(this.crust, this.size, this.toppings);
      return cheese;
    }

    @Override
    public CheesePizzaBuilder returnBuilder() {
      return this;
    }

    /**
     * Removes the cheese from a pizza.
     *
     * @return the pizza builder
     */
    public CheesePizzaBuilder noCheese() {
      this.toppings.remove(ToppingName.Cheese);
      return this.returnBuilder();
    }

    /**
     * Ensures only the left half of the pizza has cheese.
     *
     * @return the pizza builder
     */
    public CheesePizzaBuilder leftHalfCheese() {
      this.addTopping(ToppingName.Cheese, ToppingPortion.LeftHalf);
      return this.returnBuilder();
    }

    /**
     * Ensures only the right half of the pizza has cheese.
     *
     * @return the pizza builder
     */
    public CheesePizzaBuilder rightHalfCheese() {
      this.addTopping(ToppingName.Cheese, ToppingPortion.RightHalf);
      return this.returnBuilder();
    }
  }

}
package betterpizza;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

import java.util.Map;

/**
 * An abstract class for a pizza builder.
 *
 * @param <T> the builder type
 */
public abstract class PizzaBuilder<T extends PizzaBuilder<T>> {
  protected Crust crust;
  protected Size size;
  protected Map<ToppingName, ToppingPortion> toppings;

  /**
   * Sets the pizza crust.
   *
   * @param crust the given crust
   * @return the pizza builder
   */
  public abstract PizzaBuilder<T> crust(Crust crust);

  /**
   * Sets the pizza size.
   *
   * @param size the given size
   * @return the pizza builder
   */
  public abstract PizzaBuilder<T> size(Size size);

  /**
   * Adds a topping to the pizza.
   *
   * @param name    the topping name
   * @param portion the topping portion
   * @return the pizza builder
   */
  public abstract PizzaBuilder<T> addTopping(ToppingName name, ToppingPortion portion);

  /**
   * Builds the final pizza object.
   *
   * @return a new pizza object
   */
  public abstract ObservablePizza build();

  /**
   * Gets the crust.
   *
   * @return the crust
   */
  public Crust getCrust() {
    return this.crust;
  }

  /**
   * Gets the size.
   *
   * @return the size
   */
  public Size getSize() {
    return this.size;
  }

  /**
   * Gets the toppings.
   *
   * @return the toppings
   */
  public Map<ToppingName, ToppingPortion> getToppings() {
    return this.toppings;
  }

  /**
   * Determines the builder type.
   *
   * @return the builder type
   */
  public abstract PizzaBuilder<T> returnBuilder();


}

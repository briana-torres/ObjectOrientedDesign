package betterpizza;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a vegetarian pizza.
 */
public class VeggiePizza extends AlaCartePizza {

  /**
   * Create a veggie pizza with all vegetarian toppings, of the specified
   * size with the specified crust.
   *
   * @param size  the size of this pizza
   * @param crust the crust of this pizza
   */
  public VeggiePizza(Size size, Crust crust) {
    super(size, crust);
    //this.addTopping(ToppingName.Cheese, ToppingPortion.Full);
    //this.addTopping(ToppingName.Sauce,ToppingPortion.Full);
    //this.addTopping(ToppingName.BlackOlive,ToppingPortion.Full);
    //this.addTopping(ToppingName.GreenPepper,ToppingPortion.Full);
    //this.addTopping(ToppingName.Onion,ToppingPortion.Full);
    //this.addTopping(ToppingName.Jalapeno,ToppingPortion.Full);
    //this.addTopping(ToppingName.Tomato,ToppingPortion.Full);
  }

  protected VeggiePizza(Crust crust, Size size, Map<ToppingName, ToppingPortion> toppings) {
    super(crust, size, toppings);
  }

  /**
   * Allows the client to create a veggie pizza.
   */
  public static class VeggiePizzaBuilder extends PizzaBuilder<VeggiePizzaBuilder> {

    /**
     * Adds the correct toppings for a veggie pizza.
     */
    public VeggiePizzaBuilder() {
      this.toppings = new HashMap<ToppingName, ToppingPortion>();
      this.addTopping(ToppingName.Cheese, ToppingPortion.Full);
      this.addTopping(ToppingName.Sauce, ToppingPortion.Full);
      this.addTopping(ToppingName.BlackOlive, ToppingPortion.Full);
      this.addTopping(ToppingName.GreenPepper, ToppingPortion.Full);
      this.addTopping(ToppingName.Onion, ToppingPortion.Full);
      this.addTopping(ToppingName.Jalapeno, ToppingPortion.Full);
      this.addTopping(ToppingName.Tomato, ToppingPortion.Full);
    }

    @Override
    public VeggiePizzaBuilder crust(Crust crust) {
      this.crust = crust;
      return this.returnBuilder();
    }

    @Override
    public VeggiePizzaBuilder size(Size size) {
      this.size = size;
      return this.returnBuilder();
    }

    @Override
    public VeggiePizzaBuilder addTopping(ToppingName name, ToppingPortion portion) {
      this.toppings.put(name, portion);
      return this.returnBuilder();
    }

    @Override
    public ObservablePizza build() {
      VeggiePizza veggie = new VeggiePizza(this.crust, this.size, this.toppings);
      return veggie;
    }

    @Override
    public VeggiePizzaBuilder returnBuilder() {
      return this;
    }

    /**
     * Removes the cheese.
     * @return the pizza builder
     */
    public VeggiePizzaBuilder noCheese() {
      this.toppings.remove(ToppingName.Cheese);
      return returnBuilder();
    }

    /**
     * Removes the sauce.
     * @return the pizza builder
     */
    public VeggiePizzaBuilder noSauce() {
      this.toppings.remove(ToppingName.Sauce);
      return returnBuilder();
    }

    /**
     * Removes the black olives.
     * @return the pizza builder
     */
    public VeggiePizzaBuilder noBlackOlive() {
      this.toppings.remove(ToppingName.BlackOlive);
      return returnBuilder();
    }

    /**
     * Removes the green pepper.
     * @return the pizza builder
     */
    public VeggiePizzaBuilder noGreenPepper() {
      this.toppings.remove(ToppingName.GreenPepper);
      return returnBuilder();
    }

    /**
     * Removes the onion.
     * @return the pizza builder
     */
    public VeggiePizzaBuilder noOnion() {
      this.toppings.remove(ToppingName.Onion);
      return returnBuilder();
    }

    /**
     * Removes the jalapeno.
     * @return the pizza builder
     */
    public VeggiePizzaBuilder noJalapeno() {
      this.toppings.remove(ToppingName.Jalapeno);
      return returnBuilder();
    }

    /**
     * Removes the tomato.
     * @return the pizza builder
     */
    public VeggiePizzaBuilder noTomato() {
      this.toppings.remove(ToppingName.Tomato);
      return returnBuilder();
    }


  }


}

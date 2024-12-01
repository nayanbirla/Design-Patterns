package DecoratorDesignPattern.Decorator;

import DecoratorDesignPattern.BasePizza;

public class Mushroom extends Toppins {
    
    BasePizza pizza;

    public Mushroom(BasePizza pizza) {
        this.pizza=pizza;
    }

    @Override
    public int cost() {
        // TODO Auto-generated method stub
        return pizza.cost()+15;
    }
}

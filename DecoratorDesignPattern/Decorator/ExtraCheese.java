package DecoratorDesignPattern.Decorator;

import DecoratorDesignPattern.BasePizza;

public class ExtraCheese extends Toppins{

    BasePizza basePizza;

    public ExtraCheese(BasePizza pizza)
    {
        this.basePizza=pizza;
    }

    @Override
    public int cost() {
        // TODO Auto-generated method stub
        return basePizza.cost()+10;
    }

}
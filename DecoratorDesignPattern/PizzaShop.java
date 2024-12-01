package DecoratorDesignPattern;

import DecoratorDesignPattern.Decorator.ExtraCheese;
import DecoratorDesignPattern.Decorator.Mushroom;

public class PizzaShop {
    public static void main(String[] args) {
        BasePizza pizza=new Mushroom(new ExtraCheese(new FarmHourse()));
        System.out.println(pizza.cost());
    }
}

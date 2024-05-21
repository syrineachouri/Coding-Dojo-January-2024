import java.util.ArrayList;

public class TestOrder {
    public static void main(String[] args) {
    
        // Menu items

        Item item1 = new Item();
        item1.name = "Latte";
        item1.price = 2.5;
        Item item2 = new Item();
        item2.name = "cappucino";
        item2.price = 3.5;
        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 2;
        Item item4 = new Item();
        item4.name = "mocha";
        item4.price = 4;
        // Order variables -- order1, order2 etc.

        Order order1 = new Order();
        order1.name = "Cindhuri";
        order1.ready = true; 

        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.items.add(item1);
        order2.total += item1.price;
        order2.ready = true;

        Order order3 = new Order();
        order3.name = "Noah";
        order3.items.add(item2);
        order3.total += item2.price; 
        order3.ready = false;

        Order order4 = new Order();
        order4.name = "Sam";
        order4.items.add(item1);
        order4.total += 3*item1.price;
        order4.ready = false;
        
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
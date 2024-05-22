public class TestOrders {
    public static void main(String[] args) {
        // creating two items
        Item item1 = new Item("cappucino", 1.5);
        Item item2 =  new Item("latte", 2);

        // testing getters and setters for items

        //System.out.println(item1.getName());
        //System.out.println(item1.getPrice());
        //item2.setName("coffee");
        // System.out.println(item2.getName());

        // creating two orders with no name
        Order order1 = new Order();
        Order order2 = new Order("Cindhuri");

        // testing getters and setters for orders 

        System.out.println(order1.getName());
        System.out.println(order1.getItems());
        System.out.println(order1.getStatusMessage());
        order1.addItems(item2);
        order1.addItems(item1);
        order1.addItems(item2);
        System.out.printf("Your total is %s %n", order1.getOrderTotal());
        order2.addItems(item2);
        order2.addItems(item2);
        order2.addItems(item1);
        order2.addItems(item1);
        System.out.printf("Your total is %s %n", order2.getOrderTotal());
        order1.display();
        order2.display();
    }
}

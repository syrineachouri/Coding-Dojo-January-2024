import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil cafeUtil = new CafeUtil(); 

        int testSum = cafeUtil.getStreakGoal(20);

        double[] prices = {1.5, 2, 1, 4.5};
        double testPrices = cafeUtil.getOrderTotal(prices);

        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("Coffee Drip");
        menuItems.add("capuccino");
        menuItems.add("latte");
        cafeUtil.displayMenu(menuItems);



        System.out.println("The total sum is " + testSum);
        System.out.println("The total price of the items is " + testPrices);
        System.out.println("------------Menu----------");
        cafeUtil.displayMenu(menuItems);

        System.out.println("------------Add Customer---------");
        ArrayList<String> customers = new ArrayList<String>();
        /*for (int i = 0; i < 4; i++) {
            cafeUtil.addCustomer(customers);
            System.out.println("\n");
        } */

        System.out.println("----------Print price chart--------");
        cafeUtil.printPriceChart("latte", 15.0, 3 );
    }
}
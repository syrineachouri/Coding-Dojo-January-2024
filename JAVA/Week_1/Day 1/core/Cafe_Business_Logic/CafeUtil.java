import java.util.ArrayList;

public class CafeUtil{
    public int getStreakGoal(int numWeeks){
        int sum = 0; 
        for (int i = 1; i < numWeeks+1 ; i++) {
            sum = sum + i;
        }
        return sum; 
    }

    public double getOrderTotal(double[] prices){
        double sum = 0;
        for (double price : prices) {
            sum = sum + price;
        }
        return sum; 
    }
    
    public void displayMenu(ArrayList<String> menuItems){
        for (int i=0; i < menuItems.size(); i++ ){
            System.out.printf("%s %s ", i+1 , menuItems.get(i));
        }
    }

    public void addCustomer (ArrayList<String> customers){
        System.out.println("Please Enter your name: ");
        String username = System.console().readLine();
        System.out.printf("Hello %s !", username);
        customers.add(username); 
        System.out.printf("There are %s people in front of you", customers.size());
        System.out.println(customers);
    }

    public void printPriceChart (String product, double price, int maxQuantity){
        int i = 1; 
        System.out.println(product);
        while ( i < maxQuantity + 1){
            System.out.printf("%s -$%s %n", i, i*price);
            i++; 
        }
    }
}
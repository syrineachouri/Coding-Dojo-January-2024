public class cafe_Java {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 4.5;
        double latte = 7;
        double capuccino = 4.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
         String customer2 = "Noah";
        String customer3 = "Sam";
        String customer4 = "Jimmy";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true ;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //

         if (isReadyOrder1) {
            System.out.println( customer1 +readyMessage);
        }
        else {
            System.out.println(customer1 + pendingMessage);
        }




         if (isReadyOrder2) {
            System.out.println( customer2 + readyMessage + " and " + displayTotalMessage);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }




         System.out.println(displayTotalMessage + 2*latte);
        if (isReadyOrder3){
            System.out.println(customer3 + readyMessage);
        }
        else {
            System.out.println( customer3 + pendingMessage);
        }
        System.out.println(displayTotalMessage + (latte - dripCoffee));


        double priceDifference = latte - dripCoffee;
        System.out.println(generalGreeting + customer4 + ", you were charged for a coffee but had ordered a latte.");
        System.out.println("You owe $" + priceDifference + " to make up the difference.");


    }
}

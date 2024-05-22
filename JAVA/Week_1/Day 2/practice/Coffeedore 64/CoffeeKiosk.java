import java.util.ArrayList;


public class CoffeeKiosk {

    // member variables 
    private ArrayList<Item> menu;
    private ArrayList<Orders> orders;

    // constructor method
    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Orders>();
    }

    // add menu Method 
    public void addMenuItem(String name, double price){
        Item item = new Item(name, price);
        menu.add(item);
        item.setIndex(menu.indexOf(item));
    }

    //display menu method
    public void displayMenu(){
        for (Item item : menu){
            System.out.printf("%s %s -- %S %n", item.getIndex(),
            item.getName(), item.getPrice());
        }
    }
    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Orders newOrder = new Orders(name);
        // Show the user the menu, so they can choose items to add.
        this.displayMenu();

        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
            try{
                newOrder.addItems(menu.get(Integer.parseInt(itemNumber)));
            }
            catch(Exception e){
                System.out.println(e);
            }
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();

        }
        // After you have collected their order, print the order details 
        newOrder.display();
        
    }


}
import java.util.ArrayList;

public class Orders {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    // constructor method
    public Orders(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    //Overloaded Constructor
    public Orders(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    //Getters 
    public String getName(){
        return name;
    }
    public boolean isReady(){
        return ready;
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    // Setters 

    public void setName(String name){
        this.name = name;
    }

    public void setReady(){
        this.ready = true;
    }
    public void addItems(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if (this.ready == true){
            return "Your order is ready";
        }
        else{
            return "Thank you for waiting. Your order will be ready soon";
        }
    }

    public double getOrderTotal(){
        double sum = 0;
        for (int i =0; i< this.items.size(); i++){
            double newPrice = this.items.get(i).getPrice();
            sum += newPrice;
        }
        return sum;
    }

    public void display(){
        System.out.printf("Customer Name : %s %n", this.getName());
        for (Item item : this.getItems()){
            System.out.printf("%s - $%s %n", item.getName(), item.getPrice());
        }
        System.out.printf("Total : $%s %n", this.getOrderTotal());
    }
}
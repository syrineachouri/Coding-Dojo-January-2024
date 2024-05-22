public class Item {

    private String name;
    private double price;
    private int index;

    // contructor method
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    //Getters 
    public String getName(){
        return name; 
    }
    public double getPrice(){
        return price;
    }

    public int getIndex(){
        return index;
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setIndex(int index){
        this.index = index;
    }
}
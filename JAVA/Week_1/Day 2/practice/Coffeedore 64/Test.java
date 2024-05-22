public class Test {
    public static void main(String[] args) {
        CoffeeKiosk orderKiosk = new CoffeeKiosk();

        orderKiosk.addMenuItem("cappucino", 1.5);
        orderKiosk.addMenuItem("latte", 2);
        orderKiosk.displayMenu();
        orderKiosk.newOrder();
    }
}

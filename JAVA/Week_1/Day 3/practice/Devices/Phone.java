public class Phone extends Device{

    public void makeCall(){
        this.battery -= 5;
        System.out.println("You are making a call.");
        super.deviceStatus();
        if (this.battery <= 10 ){
            System.out.println("Battery is low");
        }
    }

    public void playGame(){
        this.battery -= 20;
        System.out.println("You are playing a game.");
        super.deviceStatus();
        if (this.battery <= 10 ){
            System.out.println("Battery is low");
        }
    }

    public void charge(){
        this.battery +=50;
        System.out.println("You are charging.");
        super.deviceStatus();
    }


}

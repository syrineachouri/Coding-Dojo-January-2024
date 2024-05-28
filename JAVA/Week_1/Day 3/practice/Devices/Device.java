public class Device {
    public int battery;

    public Device() {
        this.battery = 100;
    }

    public void deviceStatus(){
        System.out.printf("Battery remaining : %s %n", this.battery);
    }
}
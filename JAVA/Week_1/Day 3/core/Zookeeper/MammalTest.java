public class MammalTest {
    public static void main(String[] args) {
        Gorilla gorilla = new Gorilla();
        gorilla.throwSomething();
        gorilla.eatBananas();
        gorilla.climb();
        gorilla.displayEnergy();

        Bat bat = new Bat();
        bat.attackTown();
        bat.eatHumans();
        bat.fly();
        bat.displayEnergy();
    }
}
class Ninja {
    constructor(name) {
        this.name = name;
        this.health = 90;
        this.speed = 3;
        this.strength = 3;
    }

    sayName() {
        console.log(" Name ");
        console.log(this.name);
    }
    showStats() {
        console.log(" Stats ");
        console.log("Name: ", this.name);
        console.log("strength: ", this.strength);
        console.log("speed: ", this.speed);
        console.log("health: ", this.health);
    }
    drinkSake() {
        console.log(" Drinking Sake ");
        this.health = + 10;
        console.log("health: ", this.health);
    }
}

class Sensei extends Ninja {
    constructor(name) {
        super(name);
        this.health = 200;
        this.strength = 10;
        this.speed = 10;
        this.wisdom = 10;
    }

    speakWisdom() {
        const wisdom = super.drinkSake();
        console.log(`You've become more wise!  Your health is now ${this.health}`)
    }

}
const ninja1 = new Ninja("Hyabusa")
ninja1.sayName()
ninja1.drinkSake()
ninja1.showStats()

const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
superSensei.showStats();
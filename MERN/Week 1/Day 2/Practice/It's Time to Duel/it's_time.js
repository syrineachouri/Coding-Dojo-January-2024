class Card {
    constructor(name, cost) {
        this.name = name;
        this.cost = cost;
    }
}

class Unit extends Card {
    constructor(name, cost, power, resilience) {
        super(name, cost);
        this.power = power;
        this.resilience = resilience;
    }

    attack(target) {
        if (target instanceof Unit) {
            target.resilience -= this.power;
        } else {
            throw new Error("Unit.attack(): Target must be a unit!");
        }
    }
}

class Effect extends Card {
    constructor(name, cost, stat, magnitude) {
        super(name, cost);
        this.stat = stat;
        this.magnitude = magnitude;
        this.text = this.formatText(stat, magnitude);
    }

    formatText(stat, magnitude) {
        let direction;
        if (magnitude > 0) {
            direction = "increase";
        } else {
            direction = "reduce";
        }
        return `${direction} target's ${stat} by ${Math.abs(magnitude)}`;
    }
    play(target) {
        if (target instanceof Unit) {
            if (this.stat === "resilience") {
                target.resilience += this.magnitude;
            } else {
                target.power += this.magnitude;
            }
        } else {
            throw new Error("Effect.play(): Target must be a unit!");
        }
    }
}
const redBeltNinja = new Unit("Red Belt Ninja", 3, 3, 4);
const blackBeltNinja = new Unit("Black Belt Ninja", 4, 5, 4);
const hardAlgorithm = new Effect("Hard Algorithm", 2, "resilience", 3);
hardAlgorithm.play(redBeltNinja);
const unhandledPromiseRejection = new Effect(
    "Unhandled Promise Rejection",
    1,
    "resilience",
    -2
);
unhandledPromiseRejection.play(redBeltNinja);

const pairProgramming = new Effect("Pair Programming", 3, "power", 2);
pairProgramming.play(redBeltNinja);
redBeltNinja.attack(blackBeltNinja);



console.log(redBeltNinja);
console.log(blackBeltNinja);
console.log(hardAlgorithm);
// problem n°1
console.log(hello);
var hello = 'world';
//var hello
// console.log(hello);//undefined;
// hello = "world"


// problem n°2
var needle = 'haystack';
test();
function test(){
    var needle = 'magnet';
    console.log(needle);
}
// var needle= "haystack";
//function test()=magnet;


// problem n°3
var brendan = 'super cool';
function print(){
    brendan = 'only okay';
    console.log(brendan);
}
console.log(brendan);
//var brendan="super cool"
// function print()="only okay"

// problem n°4
var food = 'chicken';
console.log(food);
eat();
function eat(){
    food = 'half-chicken';
    console.log(food);
    var food = 'gone';
}
// var food="chicken"
//console.log(food)//"chiken";
//function eat():half-chicken;

// problem n°5
mean();
console.log(food);
var mean = function() {
    food = "chicken";
    console.log(food);
    var food = "fish";
    console.log(food);
}
console.log(food);
//var mean
// console.log(food)/undefined
// mean=fish

// problem n°6
console.log(genre);
var genre = "disco";
rewind();
function rewind() {
    genre = "rock";
    console.log(genre);
    var genre = "r&b";
    console.log(genre);
}
console.log(genre);
// var genre;
// rewind();
//function rewind()="r&b";
//genre=disco

// problem n°7
dojo = "san jose";
console.log(dojo);
learn();
function learn() {
    dojo = "seattle";
    console.log(dojo);
    var dojo = "burbank";
    console.log(dojo);
}
console.log(dojo);
// dojo="san jose";
//undefined
//"seattle"
//"burbank" 
//"san jose"

// problem n°8
console.log(makeDojo("Chicago", 65));
console.log(makeDojo("Berkeley", 0));
function makeDojo(name, students){
    const dojo = {};
    dojo.name = name;
    dojo.students = students;
    if(dojo.students > 50){
    dojo.hiring = true;
    }
    else if(dojo.students <= 0){
    dojo = "closed for now";
    }
    return dojo;
}

















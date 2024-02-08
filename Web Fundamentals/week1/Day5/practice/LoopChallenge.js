// Print odds 1-20
var i=1;
while (i<= 20 ){
    if (i%2 !== 0 ){
        console.log(i)
        i++
    }else i++
}
// Decreasing Multiples of 3
var i=100;
while(i>=0){
    if(i % 3 ==0){
        console.log(i);
        i--;
    }else i--;
}
// Print the sequence
for (var i = 4 ; i>= -4; i=i-1.5){
    console.log(i);
}
// Sigma
var i=0;
var sum=0;
while (i<= 100){
    sum += i ;
    i++
}
console.log(sum);
// Factorial
var product = 1 ;
var i = 1 ;
while(i<=12){
    product *= i ;
    i++;
}
console.log(product);


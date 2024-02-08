function logOut(element){
    if(element.innerText == "Login"){

        element.innerText="Logout"
    }else{
        element.innerText="Login"

    }
}
function addShadow(element){
    element.classList.add("shadow");
}
function removeShadow(element){
    element.classList.remove("shadow");
}
function hide(element){
    element.remove();
}
function Like() {
    alert('Ninja was liked');
}